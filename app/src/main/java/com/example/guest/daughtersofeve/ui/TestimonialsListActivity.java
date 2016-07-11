package com.example.guest.daughtersofeve.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.guest.daughtersofeve.Constants;

import butterknife.Bind;
import butterknife.ButterKnife;

public class TestimonialsListActivity extends AppCompatActivity {
    private SharedPreferences mSharedPreferences;
    private String mTestimonial;

    @Bind(R.id.testimonials)
    TextView mTestimonials;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testimonials_list);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        String testimonial = intent.getStringExtra("testimonial");
        mTestimonials.setText(testimonial);

        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        mTestimonial = mSharedPreferences.getString(Constants.TESTIMONIAL, null);
        Log.d("Shared pref testimonail", mTestimonial);

    }
}
