package com.example.guest.daughtersofeve.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.guest.daughtersofeve.Constants;
import com.example.guest.daughtersofeve.adapters.EventsViewHolder;
import com.example.guest.daughtersofeve.adapters.TestimonialsViewHolder;
import com.example.guest.daughtersofeve.models.Event;
import com.example.guest.daughtersofeve.models.Testimonial;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import butterknife.Bind;
import butterknife.ButterKnife;

public class TestimonialsListActivity extends AppCompatActivity implements View.OnClickListener{
    private SharedPreferences mSharedPreferences;
    private String mTestimonial;
    private boolean viewGroupIsVisible = false;

    @Bind(R.id.popUpMenu) LinearLayout mPopUpMenu;
    @Bind(R.id.toggleMenu) ImageView mToggleMenu;
    @Bind(R.id.previousPage) ImageView mPreviousPage; //Change for each page
    @Bind(R.id.logoutButton) ImageView mLogoutButton;


    @Bind(R.id.recyclerView) RecyclerView mRecyclerView;

    private DatabaseReference mTestimonialRef;
    private FirebaseRecyclerAdapter mFirebaseAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testimonials_list);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        String testimonial = intent.getStringExtra("testimonial");


        mToggleMenu.setOnClickListener(this);
        mPreviousPage.setOnClickListener(this); //Add page it goes to
        mLogoutButton.setOnClickListener(this);

        mTestimonialRef = FirebaseDatabase
                .getInstance()
                .getReference("testimonial");
        setUpFirebaseAdapter();

    }

    @Override
    public void onClick(View v) {
        if(v == mToggleMenu){
            if(viewGroupIsVisible){
                mPopUpMenu.setVisibility(View.GONE);
            }else{
                mPopUpMenu.setVisibility(View.VISIBLE);
            }
            viewGroupIsVisible = !viewGroupIsVisible;
        } else if(v == mLogoutButton){
            logout();
        } else if (v == mPreviousPage) {
            Intent intent = new Intent(TestimonialsListActivity.this, TestimonialActivity.class);
            startActivity(intent);
        }
    }


    private void logout() {
        FirebaseAuth.getInstance().signOut();
        Intent intent = new Intent(TestimonialsListActivity.this, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }

    private void setUpFirebaseAdapter(){
        mFirebaseAdapter = new FirebaseRecyclerAdapter<Testimonial, TestimonialsViewHolder>
                (Testimonial.class, R.layout.activity_individual_testimonials, TestimonialsViewHolder.class, mTestimonialRef) {

            @Override
            protected void populateViewHolder(TestimonialsViewHolder viewHolder, Testimonial model, int position){
                viewHolder.bindEvent(model);
            }
        };
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mFirebaseAdapter);
    }


    @Override
    protected void onDestroy(){
        super.onDestroy();
        mFirebaseAdapter.cleanup();
    }
}
