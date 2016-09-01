package com.example.guest.daughtersofeve.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.example.guest.daughtersofeve.Constants;
import com.example.guest.daughtersofeve.models.Testimonial;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import butterknife.Bind;
import butterknife.ButterKnife;

public class TestimonialActivity extends AppCompatActivity implements View.OnClickListener {
    //private SharedPreferences mSharedPreferences;
    //private SharedPreferences.Editor mEditor;

    private DatabaseReference mTestimonialReference;
    private boolean viewGroupIsVisible = false;

    @Bind(R.id.testimonialButton) Button mTestimonialButton;
    @Bind(R.id.testimonialText) EditText mTestimonialText;
    @Bind(R.id.eventText) EditText mEventText;
    @Bind(R.id.popUpMenu) LinearLayout mPopUpMenu;
    @Bind(R.id.toggleMenu) ImageView mToggleMenu;
    @Bind(R.id.previousPage) ImageView mPreviousPage; //Change for each page
    @Bind(R.id.logoutButton) ImageView mLogoutButton;
    @Bind(R.id.topMenuBar) RelativeLayout mTopMenuBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        mTestimonialReference = FirebaseDatabase
                .getInstance()
                .getReference()
                .child(Constants.FIREBASE_CHILD_TESTIMONIAL);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testimonial);
        ButterKnife.bind(this);

        //mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        //mEditor = mSharedPreferences.edit();

        mTestimonialButton.setOnClickListener(this);
        mToggleMenu.setOnClickListener(this);
        mPreviousPage.setOnClickListener(this); //Add page it goes to
        mLogoutButton.setOnClickListener(this);
        mTopMenuBar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        if(v == mTestimonialButton){
            String testimonial = mTestimonialText.getText().toString();
            saveTestimonialToFirebase(testimonial);

            Intent intent = new Intent(TestimonialActivity.this, TestimonialsListActivity.class);
            //addToSharedPreferences(testimonial);
            intent.putExtra("testimonial", testimonial);
            startActivity(intent);
        }else if(v == mToggleMenu){
            if(viewGroupIsVisible){
                mPopUpMenu.setVisibility(View.GONE);
            }else{
                mPopUpMenu.setVisibility(View.VISIBLE);
            }
            viewGroupIsVisible = !viewGroupIsVisible;
        } else if(v == mLogoutButton){
            logout();
        } else if (v == mPreviousPage) {
            Intent intent = new Intent(TestimonialActivity.this, MainActivity.class);
            startActivity(intent);
        } else if (v == mTopMenuBar) {
            Intent intent = new Intent(TestimonialActivity.this, MainActivity.class);
            startActivity(intent);
        }
    }

    private void logout() {
        FirebaseAuth.getInstance().signOut();
        Intent intent = new Intent(TestimonialActivity.this, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }


    public void saveTestimonialToFirebase(String testimonial){
        Testimonial newTestimonial = new Testimonial(testimonial);
        mTestimonialReference.push().setValue(newTestimonial);
    }

//    private void addToSharedPreferences(String testimonial){
//        mEditor.putString(Constants.TESTIMONIAL, testimonial).apply();
//    }
}
