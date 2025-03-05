package com.example.myapplication;

public class Note {
    private String date;
    private String context;
    public Note(String date, String context){
        this.date=date;
        this.context=context;
    }
    public String getDate(){
        return date;
    }
    public String getContext(){
        return context;
    }
}