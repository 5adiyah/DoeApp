package com.example.guest.daughtersofeve.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.guest.daughtersofeve.ui.R;
import com.example.guest.daughtersofeve.adapters.PhotoListAdapter;
import com.example.guest.daughtersofeve.models.Photo;
import com.example.guest.daughtersofeve.services.InstagramService;
import com.google.firebase.auth.FirebaseAuth;

import java.io.IOException;
import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class PhotosActivity extends AppCompatActivity implements View.OnClickListener{
    public static final String TAG = PhotosActivity.class.getSimpleName();

    @Bind(R.id.RecyclerView) RecyclerView mRecyclerView;
    @Bind(R.id.popUpMenu) LinearLayout mPopUpMenu;
    @Bind(R.id.toggleMenu) ImageView mToggleMenu;
    @Bind(R.id.previousPage) ImageView mPreviousPage; //Change for each page
    @Bind(R.id.logoutButton) ImageView mLogoutButton;

    private PhotoListAdapter mAdapter;
    private boolean viewGroupIsVisible = false;
    public ArrayList<Photo> mPhotos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photos);
        ButterKnife.bind(this);
        getPhotos();

        mToggleMenu.setOnClickListener(this);
        mPreviousPage.setOnClickListener(this); //Add page it goes to
        mLogoutButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        if(v == mToggleMenu){
            if(viewGroupIsVisible){
                mPopUpMenu.setVisibility(View.GONE);
            }else{
                mPopUpMenu.setVisibility(View.VISIBLE);
            }
            viewGroupIsVisible = !viewGroupIsVisible;
        } else if(v == mLogoutButton){
            logout();
        } else if (v == mPreviousPage) {
            Intent intent = new Intent(PhotosActivity.this, MainActivity.class);
            startActivity(intent);
        }
    }

    private void logout() {
        FirebaseAuth.getInstance().signOut();
        Intent intent = new Intent(PhotosActivity.this, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
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