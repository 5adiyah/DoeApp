package com.example.guest.daughtersofeve.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.guest.daughtersofeve.ui.R;
import com.example.guest.daughtersofeve.ui.AboutActivity;
import com.example.guest.daughtersofeve.ui.EventsActivity;
import com.example.guest.daughtersofeve.ui.MainActivity;
import com.example.guest.daughtersofeve.ui.PhotosActivity;

import okhttp3.Call;
import okhttp3.Callback;
import java.io.IOException;

import java.io.IOException;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Response;

public class ProfileActivity extends AppCompatActivity implements View.OnClickListener {

    @Bind(R.id.profileName) TextView mProfileName;
    @Bind(R.id.profileAbout) TextView mProfileAbout;
    @Bind(R.id.profileEvents) TextView mProfileEvents;
    @Bind(R.id.profilePhotos) TextView mProfilePhotos;
    @Bind(R.id.profileTickets) TextView mProfileTickets;
    @Bind(R.id.profileAccount) TextView mProfileAccount;
    @Bind(R.id.profileTestimonial) TextView mProfileTestimonial;
    @Bind(R.id.relativeLayout) RelativeLayout mRelativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        mProfileName.setText(name);

        mProfileAbout.setOnClickListener(this);
        mProfileEvents.setOnClickListener(this);
        mProfilePhotos.setOnClickListener(this);
        mProfileTickets.setOnClickListener(this);
        mProfileAccount.setOnClickListener(this);
        mProfileTestimonial.setOnClickListener(this);
        mRelativeLayout.setOnClickListener(this);

    }


    @Override
    public void onClick(View v){
        if(v == mProfileAbout){
            Intent intent = new Intent(ProfileActivity.this, AboutActivity.class);
            startActivity(intent);
        }else if(v == mProfileEvents){
            Intent intent = new Intent(ProfileActivity.this, EventsActivity.class);
            startActivity(intent);
        }else if(v == mProfilePhotos){
            Intent intent = new Intent(ProfileActivity.this, PhotosActivity.class);
            startActivity(intent);
        }else if(v == mProfileTickets){
            Intent intent = new Intent(ProfileActivity.this, AddEventsActivity.class);
            startActivity(intent);
        }else if(v == mProfileAccount){
            Intent intent = new Intent(ProfileActivity.this, AddMemberActivity.class);
            startActivity(intent);
        }else if(v == mProfileTestimonial){
            Intent intent = new Intent(ProfileActivity.this, TestimonialActivity.class);
            startActivity(intent);
        }else if(v == mRelativeLayout){
            Intent intent = new Intent(ProfileActivity.this, MainActivity.class);
            startActivity(intent);
        }
    }
}
