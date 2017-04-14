package com.ptech.aniceterickouame.springresttemplate;

/**
 * Created by ANICET ERIC KOUAME on 12/04/2017.
 */

public class Post {

    private  int userId;
    private int id;
    private String titie;
    private String body;


    public Post() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitie() {
        return titie;
    }

    public void setTitie(String titie) {
        this.titie = titie;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
