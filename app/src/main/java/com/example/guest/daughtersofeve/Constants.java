package com.example.guest.daughtersofeve;
import com.example.guest.daughtersofeve.ui.BuildConfig;;
/**
 * Created by Guest on 7/8/16.
 */
public class Constants {
    public static final String ClientId = BuildConfig.ClientId;
    public static final String ClientSecret = BuildConfig.ClientSecret;
    public static final String AccessToken = BuildConfig.AccessToken;
    public static final String RedirectUrl = BuildConfig.RedirectUrl;
    public static final String BaseUrl = "https://api.instagram.com/v1/users/self/media/recent/";
    public static final String QueryParameter = "access_token";
    public static final String TESTIMONIAL = "testimonial";
    public static final String FIREBASE_CHILD_TESTIMONIAL = "testimonial";
}


//https://api.instagram.com/v1/users/self/media/recent/?access_token=410998711.15224cc.d9b897443adf4d7d90bfb2fe10ffb174