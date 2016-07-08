package com.example.guest.daughtersofeve;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class PhotosActivity extends AppCompatActivity {
    public static final String TAG = "----";
    @Bind(R.id.listView) ListView mListView;
    @Bind(R.id.photoTextView) TextView mPhotoTextView;

    public ArrayList<Photo> mPhotos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photos);

        getPhotos();
    }

    private void getPhotos(){
        final InstagramService instagramService = new InstagramService();
        instagramService.findImages(new Callback(){

            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                try{
                    String jsonData = response.body().string();
                    if(response.isSuccessful()){
                        Log.v(TAG, jsonData);
                        mPhotos = instagramService.processResults(response);
                    }
                } catch(IOException e){
                    e.printStackTrace();
                }
            }
        });
    }
}
