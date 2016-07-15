package com.example.guest.daughtersofeve.models;

import org.parceler.Parcel;

@Parcel
public class Event {
    private String name;
    private String imageUrl;
    private String description;
    private String pushId;

    public Event(){}

    public Event(String name, String imageUrl, String description){
        this.name = name;
        this.imageUrl = imageUrl;
        this.description = description;
    }

    public String getName(){
        return name;
    }

    public String getImageUrl(){
        return imageUrl;
    }

    public String getDescription(){
        return description;
    }

    public String getPushId(){
        return pushId;
    }

    public void setPushId(String pushId){
        this.pushId = pushId;
    }
}
