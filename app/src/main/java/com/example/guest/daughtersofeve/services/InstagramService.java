package com.example.guest.daughtersofeve.services;

import android.util.Log;

import com.example.guest.daughtersofeve.Constants;
import com.example.guest.daughtersofeve.models.Photo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import se.akerfeldt.okhttp.signpost.OkHttpOAuthConsumer;
import se.akerfeldt.okhttp.signpost.SigningInterceptor;


public class InstagramService {
    public static final String TAG = "----------";
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

    public ArrayList<Photo> processResults(Response response){
        ArrayList<Photo> photos = new ArrayList<>();

        try{
            String jsonData = response.body().string();
            if (response.isSuccessful()) {
                JSONObject instagramJson = new JSONObject(jsonData);
                JSONArray photosJSON = instagramJson.getJSONArray("data");
                for(int i = 0; i < photosJSON.length(); i++){
                    JSONObject photoJSON = photosJSON.getJSONObject(i);
                    String caption = photoJSON.getJSONObject("caption").getString("text");
                    String url = photoJSON.getJSONObject("images").getJSONObject("thumbnail").getString("url");

                    Photo photo = new Photo(caption, url);
                    photos.add(photo);
                }
        }
    }   catch (JSONException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return photos;
    }
}


//https://api.instagram.com/v1/users/self/media/recent/?access_token=410998711.15224cc.d9b897443adf4d7d90bfb2fe10ffb174