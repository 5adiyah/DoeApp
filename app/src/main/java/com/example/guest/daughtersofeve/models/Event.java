package com.example.guest.daughtersofeve.models;

import org.parceler.Parcel;

@Parcel
public class Event {
    private String name;
    private String age;
    private String price;
    private String pushId;

    public Event(){}

    public Event(String name, String age, String price){
        this.name = name;
        this.age = age;
        this.price = price;
    }

    public String getName(){
        return name;
    }

    public String getAge(){
        return age;
    }

    public String getPrice(){
        return price;
    }

    public String getPushId(){
        return pushId;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setPushId(String pushId){
        this.pushId = pushId;
    }
}
