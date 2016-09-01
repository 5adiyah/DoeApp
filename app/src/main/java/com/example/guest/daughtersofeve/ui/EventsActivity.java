package com.example.guest.daughtersofeve.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.example.guest.daughtersofeve.adapters.EventsViewHolder;
import com.example.guest.daughtersofeve.models.Event;
import com.example.guest.daughtersofeve.ui.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import butterknife.Bind;
import butterknife.ButterKnife;

public class EventsActivity extends AppCompatActivity implements View.OnClickListener{
    @Bind(R.id.recyclerView) RecyclerView mRecyclerView;
    @Bind(R.id.popUpMenu) LinearLayout mPopUpMenu;
    @Bind(R.id.toggleMenu) ImageView mToggleMenu;
    @Bind(R.id.previousPage) ImageView mPreviousPage; //Change for each page
    @Bind(R.id.logoutButton) ImageView mLogoutButton;
    @Bind(R.id.addEventButton) ImageView mAddEventButton;
    @Bind(R.id.topMenuBar) RelativeLayout mTopMenuBar;

    private boolean viewGroupIsVisible = false;

    private DatabaseReference mEventReference;
    private FirebaseRecyclerAdapter mFirebaseAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);
        ButterKnife.bind(this);

        mEventReference = FirebaseDatabase
                .getInstance()
                .getReference("Event");
        setUpFirebaseAdapter();

        mToggleMenu.setOnClickListener(this);
        mPreviousPage.setOnClickListener(this); //Add page it goes to
        mLogoutButton.setOnClickListener(this);
        mAddEventButton.setOnClickListener(this);
        mTopMenuBar.setOnClickListener(this);
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
        } else if (v == mPreviousPage) {
            Intent intent = new Intent(EventsActivity.this, MainActivity.class);
            startActivity(intent);
        } else if (v == mTopMenuBar) {
            Intent intent = new Intent(EventsActivity.this, MainActivity.class);
            startActivity(intent);
        } else if (v == mAddEventButton) {
            Intent intent = new Intent(EventsActivity.this, AdminActivity.class);
            startActivity(intent);
        }
    }

    private void setUpFirebaseAdapter(){
        mFirebaseAdapter = new FirebaseRecyclerAdapter<Event, EventsViewHolder>
                (Event.class, R.layout.activity_event_list, EventsViewHolder.class, mEventReference) {

            @Override
            protected void populateViewHolder(EventsViewHolder viewHolder, Event model, int position){
                viewHolder.bindEvent(model);
            }
        };
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mFirebaseAdapter);

//        mFirebaseAdapter.registerAdapterDataObserver(new RecyclerView.AdapterDataObserver() {
//            @Override
//            public void onItemRangeInserted(int positionStart, int itemCount) {
//                super.onItemRangeInserted(positionStart, itemCount);
//                mFirebaseAdapter.notifyDataSetChanged();
//            }
//        });
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        mFirebaseAdapter.cleanup();
    }

    private void logout() {
        FirebaseAuth.getInstance().signOut();
        Intent intent = new Intent(EventsActivity.this, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }
}
