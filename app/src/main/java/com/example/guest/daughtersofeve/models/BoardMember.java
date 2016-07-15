package com.example.guest.daughtersofeve.models;

public class BoardMember {
    private String name;
    private String imageUrl;
    private String position;
    private String pushId;


    public BoardMember(){}

    public BoardMember(String name, String imageUrl, String position){
        this.name = name;
        this.imageUrl = imageUrl;
        this.position = position;
    }

    public String getName(){
        return name;
    }

    public String getImageUrl(){
        return imageUrl;
    }

    public String getPosition(){
        return position;
    }

    public String getPushId(){
        return pushId;
    }

    public void setPushId(String pushId){
        this.pushId = pushId;
    }
}
