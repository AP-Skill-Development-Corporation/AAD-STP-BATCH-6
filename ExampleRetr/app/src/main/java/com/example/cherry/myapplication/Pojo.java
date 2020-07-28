package com.example.cherry.myapplication;


public class Pojo {
    String name,author,title,desc,urltoimage,date;

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public String getDesc() {
        return desc;
    }

    public String getDate() {
        return date;
    }

    public Pojo(String name, String author, String title, String desc, String urltoimage, String date) {
        this.name = name;
        this.author = author;
        this.title = title;
        this.desc = desc;
        this.urltoimage = urltoimage;
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public String getUrltoimage() {
        return urltoimage;
    }


}

