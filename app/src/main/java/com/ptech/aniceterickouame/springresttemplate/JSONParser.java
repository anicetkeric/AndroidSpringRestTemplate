package com.ptech.aniceterickouame.springresttemplate;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by ANICET ERIC KOUAME on 12/04/2017.
 */

public class JSONParser {


    public static ArrayList<Post> PostList = new ArrayList<>();

    public static Post parsePost(JSONObject obj) {

        try {
            Post p = new Post();
            p.setId(Integer.parseInt(obj.getString("id")));
            p.setTitie(obj.getString("title"));
            p.setBody(obj.getString("body"));
            p.setUserId(Integer.parseInt(obj.getString("userId")));

            return p;
        } catch (JSONException e1) {
            e1.printStackTrace();
            return null;
        }
    }


    public static ArrayList<Post> parseArrayPost(JSONArray arr) {
        JSONObject obj=null;
        Post p = null;
        PostList.clear();
        try {

            for(int i = 0;i<arr.length();i++) {
                obj = arr.getJSONObject(i);
                p= new Post();
                p.setId(Integer.parseInt(obj.getString("id")));
                p.setTitie(obj.getString("title"));
                p.setBody(obj.getString("body"));
                p.setUserId(Integer.parseInt(obj.getString("userId")));
                PostList.add(p);
            }
            return PostList;
        } catch (JSONException e1) {
            e1.printStackTrace();
            return null;
        }
    }




}
