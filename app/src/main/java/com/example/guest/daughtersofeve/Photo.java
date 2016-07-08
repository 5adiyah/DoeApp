package com.example.guest.daughtersofeve;

/**
 * Created by Guest on 7/8/16.
 */
public class Photo {
    private String mCaption;
    private String mUrl;

    public Photo(){
        //For Firebase
    }

    public Photo(String caption, String url){
        this.mCaption = caption;
        this.mUrl = url;
    }

    public String getCaption(){
        return mCaption;
    }

    public String getUrl(){
        return mUrl;
    }
}
