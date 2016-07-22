package com.example.guest.daughtersofeve.models;

/**
 * Created by Guest on 7/22/16.
 */
public class Testimonial {
    private String comment;
    private String pushId;


    public Testimonial(){}

    public Testimonial(String comment){
        this.comment = comment;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getPushId() {
        return pushId;
    }

    public void setPushId(String pushId) {
        this.pushId = pushId;
    }
}
