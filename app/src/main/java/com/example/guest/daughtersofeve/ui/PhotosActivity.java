package com.example.guest.daughtersofeve.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.guest.daughtersofeve.ui.R;
import com.example.guest.daughtersofeve.adapters.PhotoListAdapter;
import com.example.guest.daughtersofeve.models.Photo;
import com.example.guest.daughtersofeve.services.InstagramService;

import java.io.IOException;
import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class PhotosActivity extends AppCompatActivity {
    public static final String TAG = PhotosActivity.class.getSimpleName();

    @Bind(R.id.RecyclerView) RecyclerView mRecyclerView;
    private PhotoListAdapter mAdapter;

    public ArrayList<Photo> mPhotos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photos);
        ButterKnife.bind(this);
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
                mPhotos = instagramService.processResults(response);

                PhotosActivity.this.runOnUiThread(new Runnable() {

                    @Override
                    public void run(){
                        mAdapter = new PhotoListAdapter(getApplicationContext(), mPhotos);
                        mRecyclerView.setAdapter(mAdapter);
//                        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(PhotosActivity.this);
                        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(), 2);
                        mRecyclerView.setLayoutManager(layoutManager);
                        mRecyclerView.setHasFixedSize(true);
                        String[] photoCaptions = new String[mPhotos.size()];

                    }

                });
            }
        });
    }

}