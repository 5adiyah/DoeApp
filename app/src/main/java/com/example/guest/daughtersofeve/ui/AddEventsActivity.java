package com.example.guest.daughtersofeve.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.guest.daughtersofeve.models.Event;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import butterknife.Bind;
import butterknife.ButterKnife;

public class AddEventsActivity extends AppCompatActivity implements View.OnClickListener{
    @Bind(R.id.nameEditText) EditText mNameEditText;
    @Bind(R.id.eventAge) EditText mEventAge;
    @Bind(R.id.eventPrice) EditText mEventPrice;
    @Bind(R.id.eventListView) TextView mEventsListView;
    @Bind(R.id.createEventButton) Button mCreateEventButton;
    @Bind(R.id.topMenuBar) RelativeLayout mTopMenuBar;

    public static final String TAG = AddEventsActivity.class.getSimpleName();
    private DatabaseReference mEventReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_events);
        ButterKnife.bind(this);

        mEventReference = FirebaseDatabase
                .getInstance()
                .getReference()
                .child("Event");

        mCreateEventButton.setOnClickListener(this);
        mEventsListView.setOnClickListener(this);
        mTopMenuBar.setOnClickListener(this);

    }

    @Override
    public void onClick(View v){
        if(v==mCreateEventButton){
            String name = mNameEditText.getText().toString();
            String eventAge = mEventAge.getText().toString();
            String eventPrice = mEventPrice.getText().toString();
            saveEventToFirebase(name, eventAge, eventPrice);

            Intent intent = new Intent(AddEventsActivity.this, MainActivity.class);
            startActivity(intent);
        } else if (v == mTopMenuBar) {
            Intent intent = new Intent(AddEventsActivity.this, MainActivity.class);
            startActivity(intent);
        }

    }

    public void saveEventToFirebase(String name, String eventAge, String eventPrice){
        Event event = new Event(name, eventAge, eventPrice);
        mEventReference.push().setValue(event);
    }

}
