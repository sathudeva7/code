package com.example.mpl;


import com.google.firebase.database.Exclude;

public class User {
    private String name;
    private  String id;
    private String num;

    public User(){

    }
    @Exclude
    private  String getId(){
        return id;
    }
    public void setId(String id){
        this.id=id;
    }
    public User(String name,String num){
        this.name = name;
        this.num = num;

    }

    public String getName(){
        return name;
    }


    public String getNum(){
        return num;
    }



}


