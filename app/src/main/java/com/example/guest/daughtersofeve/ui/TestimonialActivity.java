package com.example.guest.daughtersofeve.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.guest.daughtersofeve.Constants;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import butterknife.Bind;
import butterknife.ButterKnife;

public class TestimonialActivity extends AppCompatActivity implements View.OnClickListener {
    //private SharedPreferences mSharedPreferences;
    //private SharedPreferences.Editor mEditor;

    private DatabaseReference mTestimonialReference;

    @Bind(R.id.testimonialButton) Button mTestimonialButton;
    @Bind(R.id.testimonialText) EditText mTestimonialText;
    @Bind(R.id.eventText) EditText mEventText;

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
        }
    }

    public void saveTestimonialToFirebase(String testimonial){
        mTestimonialReference.push().setValue(testimonial);
    }

//    private void addToSharedPreferences(String testimonial){
//        mEditor.putString(Constants.TESTIMONIAL, testimonial).apply();
//    }
}
