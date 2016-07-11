package com.example.guest.daughtersofeve.models;

/**
 * Created by Guest on 7/11/16.
 */
public class Event {
    private String mName;
    private String mDate;
    private String mLocation;
    private Integer mTicketPrice;
    private Integer mSpotsAvailable;


    public Event(){}

    public Event(String name, String date, String location, Integer ticketPrice, Integer spotsAvailable){
        this.mName = name;
        this.mDate = date;
        this.mLocation = location;
        this.mTicketPrice = ticketPrice;
        this.mSpotsAvailable = spotsAvailable;
    }

    public String getName(){
        return mName;
    }

    public String getDate(){
        return mDate;
    }

    public String getLocation(){
        return mLocation;
    }

    public Integer getTicketPrice(){
        return mTicketPrice;
    }

    public Integer getSpotsAvailable(){
        return mSpotsAvailable;
    }
}

