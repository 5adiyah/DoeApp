package com.example.guest.daughtersofeve;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import se.akerfeldt.okhttp.signpost.OkHttpOAuthConsumer;
import se.akerfeldt.okhttp.signpost.SigningInterceptor;


public class InstagramService {
    public static void findImages(Callback callback){
        OkHttpOAuthConsumer consumer = new OkHttpOAuthConsumer(Constants.ClientId, Constants.ClientSecret);

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new SigningInterceptor(consumer))
                .build();

        HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.BaseUrl).newBuilder();
        urlBuilder.addQueryParameter(Constants.QueryParameter, Constants.AccessToken);
        String url = urlBuilder.build().toString();

        Request request = new Request.Builder()
                .url(url)
                .build();

        Call call = client.newCall(request);
        call.enqueue(callback);
    }
}


//https://api.instagram.com/v1/users/self/media/recent/?access_token=410998711.15224cc.d9b897443adf4d7d90bfb2fe10ffb174