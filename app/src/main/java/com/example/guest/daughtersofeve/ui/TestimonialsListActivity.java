package com.example.guest.daughtersofeve.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class TestimonialsListActivity extends AppCompatActivity {
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
    }
}
