package com.example.guest.daughtersofeve.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.guest.daughtersofeve.models.Event;
import com.example.guest.daughtersofeve.models.Testimonial;
import com.example.guest.daughtersofeve.ui.TestimonialsListActivity;
import com.example.guest.daughtersofeve.ui.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import org.parceler.Parcel;
import org.parceler.Parcels;

import java.util.ArrayList;

import org.parceler.Parcels;

import java.util.ArrayList;

/**
 * Created by Guest on 7/22/16.
 */
public class TestimonialsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    View mView;
    Context mContext;

    public TestimonialsViewHolder(View itemView){
        super(itemView);
        mView = itemView;
        mContext = itemView.getContext();
        itemView.setOnClickListener(this);
    }

    public void bindEvent(Testimonial testimonial){
        TextView testimonialText = (TextView) mView.findViewById(R.id.testimonials);
        testimonialText.setText(testimonial.getComment());
    }

    @Override public void onClick(View view){
        final ArrayList<Testimonial> testimonials = new ArrayList<>();
        DatabaseReference ref = FirebaseDatabase
                .getInstance()
                .getReference("testimonial");
        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot snapshot : dataSnapshot.getChildren()){
                    testimonials.add(snapshot.getValue(Testimonial.class));
                }

                int itemPosition = getLayoutPosition();
                Intent intent = new Intent(mContext, TestimonialsListActivity.class);
                intent.putExtra("position", itemPosition + "");
                intent.putExtra("testimonials", Parcels.wrap(testimonials));

                mContext.startActivity(intent);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
