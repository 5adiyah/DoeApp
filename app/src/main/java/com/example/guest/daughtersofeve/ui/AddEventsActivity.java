package com.example.guest.daughtersofeve.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.guest.daughtersofeve.models.Event;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import butterknife.Bind;
import butterknife.ButterKnife;

public class AddEventsActivity extends AppCompatActivity implements View.OnClickListener{
    @Bind(R.id.nameEditText) EditText mNameEditText;
    @Bind(R.id.descriptionEditText) EditText mDescriptionEditText;
    @Bind(R.id.imageUrl) EditText mImageUrl;
    @Bind(R.id.eventListView) TextView mEventsListView;
    @Bind(R.id.createEventButton) Button mCreateEventButton;

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
    }

    @Override
    public void onClick(View v){
        if(v==mCreateEventButton){
            String name = mNameEditText.getText().toString();
            String description = mDescriptionEditText.getText().toString();
            String imageUrl = mImageUrl.getText().toString();
            saveEventToFirebase(name, imageUrl, description);

            Intent intent = new Intent(AddEventsActivity.this, MainActivity.class);
            startActivity(intent);
        }

        if(v==mEventsListView){
            Intent intent = new Intent(AddEventsActivity.this, EventsActivity.class);
            startActivity(intent);
        }
    }

    public void saveEventToFirebase(String name, String imageUrl, String description){
        Event event = new Event(name, imageUrl, description);
        mEventReference.push().setValue(event);
    }
}
