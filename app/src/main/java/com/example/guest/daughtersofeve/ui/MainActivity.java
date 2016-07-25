package com.example.guest.daughtersofeve.ui;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.guest.daughtersofeve.ui.R;
import com.google.firebase.auth.FirebaseAuth;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Bind(R.id.popUpMenu) LinearLayout mPopUpMenu;
    @Bind(R.id.toggleMenu) ImageView mToggleMenu;
    @Bind(R.id.previousPage) ImageView mPreviousPage; //Change for each page

    @Bind(R.id.profileAbout) ImageView mProfileAbout;
    @Bind(R.id.profileAboutLayout) RelativeLayout mProfileAboutLayout;
    @Bind(R.id.profileAboutText) TextView mProfileAboutText;

    @Bind(R.id.profileEvents) ImageView mProfileEvents;
    @Bind(R.id.profileEventsLayout) RelativeLayout mProfileEventsLayout;
    @Bind(R.id.profileEventsText) TextView mProfileEventsText;

    @Bind(R.id.profilePhotos) ImageView mProfilePhotos;
    @Bind(R.id.profilePhotosLayout) RelativeLayout mProfilePhotosLayout;
    @Bind(R.id.profilePhotosText) TextView mProfilePhotosText;

    @Bind(R.id.profileTestimonial) ImageView mProfileTestimonial;
    @Bind(R.id.profileTestimonialLayout) RelativeLayout mProfileTestimonialLayout;
    @Bind(R.id.profileTestimonialText) TextView mProfileTestimonialText;

    @Bind(R.id.profileAccount) ImageView mProfileAccount;
    @Bind(R.id.profileAccountLayout) RelativeLayout mProfileAccountLayout;
    @Bind(R.id.profileAccountText) TextView mProfileAccountText;

    @Bind(R.id.logoutButton) ImageView mLogoutButton;


    private boolean viewGroupIsVisible = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        mToggleMenu.setOnClickListener(this);
        mPreviousPage.setOnClickListener(this); //Add page it goes to

        mProfileAbout.setOnClickListener(this);
        mProfileAboutLayout.setOnClickListener(this);
        mProfileAboutText.setOnClickListener(this);

        mProfileEvents.setOnClickListener(this);
        mProfileEventsLayout.setOnClickListener(this);
        mProfileEventsText.setOnClickListener(this);

        mProfilePhotos.setOnClickListener(this);
        mProfilePhotosLayout.setOnClickListener(this);
        mProfilePhotosText.setOnClickListener(this);

        mProfileTestimonial.setOnClickListener(this);
        mProfileTestimonialLayout.setOnClickListener(this);
        mProfileTestimonialText.setOnClickListener(this);

        mProfileAccount.setOnClickListener(this);
        mProfileAccountLayout.setOnClickListener(this);
        mProfileAccountText.setOnClickListener(this);

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
        }

        else if(v == mProfileAbout){
            Intent intent = new Intent(MainActivity.this, AboutActivity.class);
            startActivity(intent);
        }else if(v == mProfileAboutLayout){
            Intent intent = new Intent(MainActivity.this, AboutActivity.class);
            startActivity(intent);
        }else if(v == mProfileAboutText){
            Intent intent = new Intent(MainActivity.this, AboutActivity.class);
            startActivity(intent);
        }

        else if(v == mProfileEvents){
            Intent intent = new Intent(MainActivity.this, EventsActivity.class);
            startActivity(intent);
        }else if(v == mProfileEventsLayout){
            Intent intent = new Intent(MainActivity.this, EventsActivity.class);
            startActivity(intent);
        }else if(v == mProfileEventsText){
            Intent intent = new Intent(MainActivity.this, EventsActivity.class);
            startActivity(intent);
        }

        else if(v == mProfilePhotos){
            Intent intent = new Intent(MainActivity.this, PhotosActivity.class);
            startActivity(intent);
        }else if(v == mProfilePhotosLayout){
            Intent intent = new Intent(MainActivity.this, PhotosActivity.class);
            startActivity(intent);
        }else if(v == mProfilePhotosText){
            Intent intent = new Intent(MainActivity.this, PhotosActivity.class);
            startActivity(intent);
        }

        else if(v == mProfileTestimonial){
            Intent intent = new Intent(MainActivity.this, TestimonialActivity.class);
            startActivity(intent);
        }else if(v == mProfileTestimonialLayout){
            Intent intent = new Intent(MainActivity.this, TestimonialActivity.class);
            startActivity(intent);
        }else if(v == mProfileTestimonialText){
            Intent intent = new Intent(MainActivity.this, TestimonialActivity.class);
            startActivity(intent);
        }

        else if(v == mProfileAccount){
            Intent intent = new Intent(MainActivity.this, MainActivity.class);
            startActivity(intent);
        }else if(v == mProfileAccountLayout){
            Intent intent = new Intent(MainActivity.this, MainActivity.class);
            startActivity(intent);
        }else if(v == mProfileAccountText){
            Intent intent = new Intent(MainActivity.this, MainActivity.class);
            startActivity(intent);
        }
    }

    private void logout() {
        FirebaseAuth.getInstance().signOut();
        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }
}
