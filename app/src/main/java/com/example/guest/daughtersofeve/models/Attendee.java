package com.example.guest.daughtersofeve.models;

/**
 * Created by Guest on 7/11/16.
 */
public class Attendee {
    private String mName;
    private String mPaymentType;
    private Integer mAge;


    public Attendee(){}

    public Attendee(String name, String paymentType, Integer age){
        this.mName = name;
        this.mPaymentType = paymentType;
        this.mAge = age;
    }

    public String getName(){
        return mName;
    }

    public String getPaymentType(){
        return mPaymentType;
    }

    public Integer getAge(){
        return mAge;
    }
}
