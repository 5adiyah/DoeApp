package com.example.guest.daughtersofeve;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import se.akerfeldt.okhttp.signpost.OkHttpOAuthConsumer;
import se.akerfeldt.okhttp.signpost.SigningInterceptor;

/**
 * Created by Guest on 7/8/16.
 */
public class InstagramService {
    public static void findImages(){
        OkHttpOAuthConsumer consumer = new OkHttpOAuthConsumer(Constants.ClientId, Constants.ClientSecret);

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new SigningInterceptor(consumer))
                .build();

        HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.BaseUrl).newBuilder();
        urlBuilder.addQueryParameter(Constants.QueryParameter, Constants.AccessToken);
        String url = urlBuilder.build().toString();
    }
}


//https://api.instagram.com/v1/users/self/media/recent/?access_token=410998711.15224cc.d9b897443adf4d7d90bfb2fe10ffb174