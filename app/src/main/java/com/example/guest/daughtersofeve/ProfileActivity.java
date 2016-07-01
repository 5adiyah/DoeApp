package com.example.guest.daughtersofeve;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.ButterKnife;

public class ProfileActivity extends AppCompatActivity implements View.OnClickListener {

    @Bind(R.id.profileName) TextView mProfileName;
    @Bind(R.id.profileAbout) TextView mProfileAbout;
    @Bind(R.id.profileEvents) TextView mProfileEvents;
    @Bind(R.id.profilePhotos) TextView mProfilePhotos;
    @Bind(R.id.profileTickets) TextView mProfileTickets;
    @Bind(R.id.profileAccount) TextView mProfileAccount;
    @Bind(R.id.profileSignOut) TextView mProfileSignOut;

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
        mProfileSignOut.setOnClickListener(this);

    }

    @Override
    public void onClick(View v){
        if(v == mProfileAbout){
            Intent intent = new Intent(ProfileActivity.this, AboutActivity.class);
            startActivity(intent);
        }else if(v == mProfileEvents){
            Intent intent = new Intent(ProfileActivity.this, MainActivity.class);
            startActivity(intent);
        }else if(v == mProfilePhotos){
            Intent intent = new Intent(ProfileActivity.this, MainActivity.class);
            startActivity(intent);
        }else if(v == mProfileTickets){
            Intent intent = new Intent(ProfileActivity.this, MainActivity.class);
            startActivity(intent);
        }else if(v == mProfileAccount){
            Intent intent = new Intent(ProfileActivity.this, MainActivity.class);
            startActivity(intent);
        }else if(v == mProfileSignOut){
            Intent intent = new Intent(ProfileActivity.this, MainActivity.class);
            startActivity(intent);
        }
    }
}
