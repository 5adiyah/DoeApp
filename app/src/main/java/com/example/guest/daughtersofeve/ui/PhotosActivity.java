package com.example.guest.daughtersofeve.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.guest.daughtersofeve.R;
import com.example.guest.daughtersofeve.models.Photo;
import com.example.guest.daughtersofeve.services.InstagramService;

import java.io.IOException;
import java.util.ArrayList;

import butterknife.Bind;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class PhotosActivity extends AppCompatActivity {
    public static final String TAG = PhotosActivity.class.getSimpleName();
    @Bind(R.id.listView) ListView mListView;

    public ArrayList<Photo> mPhotos = new ArrayList<>();
    public String test;

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
            public void onResponse(Call call, Response response){
                test = response.body().toString();
                mPhotos = instagramService.processResults(response);

                PhotosActivity.this.runOnUiThread(new Runnable() {

                    @Override
                    public void run(){
                        String[] photoCaptions = new String[mPhotos.size()];
                        for(int i = 0; i < photoCaptions.length-1; i++){
                            photoCaptions[i] = mPhotos.get(i).getCaption();
                        }

                        ArrayAdapter adapter = new ArrayAdapter(PhotosActivity.this,
                                android.R.layout.simple_list_item_1, photoCaptions);
//                        mListView.setAdapter(adapter);

                        for(Photo photo : mPhotos){
                            Log.d(TAG, "Caption: " + photo.getCaption());
                            Log.d(TAG, "Url: " + photo.getUrl());
                        }
                    }

                });
            }
        });
}

}