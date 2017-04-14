package com.ptech.aniceterickouame.springresttemplate;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    final String URL_BASE="https://jsonplaceholder.typicode.com/";
    Activity ACTIVITY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ACTIVITY=(Activity)this;

        Button getAll =(Button) findViewById(R.id.getAll);
        Button getOne =(Button) findViewById(R.id.getOne);


        getAll.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                new HttpAllPostTask(ACTIVITY).execute();
            }
        });


        getOne.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                new HttpOnePostTask(ACTIVITY).execute();
            }
        });

    }



    private class HttpAllPostTask extends AsyncTask<Void, Void, String> {


        private ProgressDialog dialog;
        ArrayList<Post> PostList = new ArrayList<>();
        public HttpAllPostTask(Activity activity){
            dialog = new ProgressDialog(activity);
        }

        @Override
        protected String doInBackground(Void... params) {
            try {

                // Create a new RestTemplate instance
                RestTemplate restTemplate = new RestTemplate(true);

                // Add the Jackson and String message converters
                restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
                restTemplate.getMessageConverters().add(new StringHttpMessageConverter());

                    // Make the HTTP POST request, marshaling the request to JSON, and the response to a String
                    String response = restTemplate.getForObject(URL_BASE+"posts/",  String.class);



                return  response ;
            } catch (Exception ex) {
                Log.e("Connexion", ex.getMessage());
                Toast.makeText(getBaseContext(),ex.toString(), Toast.LENGTH_LONG).show();
            }
            return null;
        }

        @Override
        protected void onPreExecute() {
            dialog.setMessage("loading....");
            dialog.show();
            // dialog.setCancelable(false);
            dialog.setCanceledOnTouchOutside(false);
        }

        @Override
        protected void onPostExecute(String response) {


            try{
                if(response!=null){
                    JSONArray jsonObj = new JSONArray(response);

                    PostList= JSONParser.parseArrayPost(jsonObj);
                    Toast.makeText(getBaseContext(),"result count list: "+PostList.size(), Toast.LENGTH_LONG).show();
                }


                if (dialog.isShowing()) {
                    dialog.dismiss();
                }

            }catch (Exception e){
                 Toast.makeText(getBaseContext(),e.toString(), Toast.LENGTH_LONG).show();
                if (dialog.isShowing()) {
                    dialog.dismiss();
                }
            }

        }

    }

    private class HttpOnePostTask extends AsyncTask<Void, Void, String> {

        Post p=new Post();
        private ProgressDialog dialog;
        public HttpOnePostTask(Activity activity){
            dialog = new ProgressDialog(activity);
        }

        @Override
        protected String doInBackground(Void... params) {
            try {



                // Create a new RestTemplate instance
                RestTemplate restTemplate = new RestTemplate(true);

// Add the Jackson and String message converters
                restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
                restTemplate.getMessageConverters().add(new StringHttpMessageConverter());



                    // Make the HTTP POST request, marshaling the request to JSON, and the response to a String
                    String response = restTemplate.getForObject(URL_BASE+"posts/1",  String.class);


                return  response ;
            } catch (Exception ex) {
                Log.e("Connexion", ex.getMessage());
                Toast.makeText(getBaseContext(),ex.toString(), Toast.LENGTH_LONG).show();
            }
            return null;
        }

        @Override
        protected void onPreExecute() {
            dialog.setMessage("loading....");
            dialog.show();
            // dialog.setCancelable(false);
            dialog.setCanceledOnTouchOutside(false);
        }

        protected void onPostExecute(String response) {



            try{
                if(response!=null){
                    JSONObject jsonObj = new JSONObject(response);

                    p= JSONParser.parsePost(jsonObj);
                    Toast.makeText(getBaseContext(),"result: ******* \n body: "+p.getBody()+"\n Id:"+p.getId()+"\n Title: "+p.getTitie(), Toast.LENGTH_LONG).show();
                }




                if (dialog.isShowing()) {
                    dialog.dismiss();
                }

            }catch (Exception e){
                 Toast.makeText(getBaseContext(),e.toString(), Toast.LENGTH_LONG).show();
                Log.e("---MainActivity", e.getMessage(), e);
              if (dialog.isShowing()) {
                    dialog.dismiss();
                }
            }

        }

    }


}
