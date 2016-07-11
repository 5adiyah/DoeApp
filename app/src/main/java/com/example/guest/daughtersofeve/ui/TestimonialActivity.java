package com.example.guest.daughtersofeve.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import butterknife.Bind;
import butterknife.ButterKnife;

public class TestimonialActivity extends AppCompatActivity implements View.OnClickListener {

    @Bind(R.id.testimonialButton) Button mTestimonialButton;
    @Bind(R.id.testimonialText) EditText mTestimonialText;
    @Bind(R.id.eventText) EditText mEventText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testimonial);
        ButterKnife.bind(this);
        mTestimonialButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        if(v == mTestimonialButton){
            Intent intent = new Intent(TestimonialActivity.this, TestimonialsListActivity.class);
            String testimonial = mTestimonialText.getText().toString();
            intent.putExtra("testimonial", testimonial);
            startActivity(intent);
        }
    }
}
