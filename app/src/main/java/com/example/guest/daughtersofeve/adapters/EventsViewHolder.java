package com.example.guest.daughtersofeve.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.guest.daughtersofeve.models.Event;
import com.example.guest.daughtersofeve.ui.EventsActivity;
import com.example.guest.daughtersofeve.ui.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import org.parceler.Parcel;
import org.parceler.Parcels;

import java.util.ArrayList;

/**
 * Created by Guest on 7/15/16.
 */
public class EventsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    View mView;
    Context mContext;

    public EventsViewHolder(View itemView){
        super(itemView);
        mView = itemView;
        mContext = itemView.getContext();
        itemView.setOnClickListener(this);
    }

    public void bindEvent(Event event){
        TextView eventName = (TextView) mView.findViewById(R.id.eventName);
        eventName.setText(event.getName());
        TextView eventAge = (TextView) mView.findViewById(R.id.eventAge);
        eventAge.setText(event.getAge());
        TextView eventPrice = (TextView) mView.findViewById(R.id.eventPrice);
        eventPrice.setText(event.getPrice());
    }

    @Override public void onClick(View view){
        final ArrayList<Event> events = new ArrayList<>();
        DatabaseReference ref = FirebaseDatabase
                .getInstance()
                .getReference("Event");

        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot snapshot : dataSnapshot.getChildren()){
                    events.add(snapshot.getValue(Event.class));
                }

                int itemPosition = getLayoutPosition();
                Intent intent = new Intent(mContext, EventsActivity.class);
                intent.putExtra("position", itemPosition + "");
                intent.putExtra("events", Parcels.wrap(events));

                mContext.startActivity(intent);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
