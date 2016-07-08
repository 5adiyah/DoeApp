package com.example.guest.daughtersofeve.adapters;

import com.example.guest.daughtersofeve.ui.R;
import com.example.guest.daughtersofeve.models.Photo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import com.squareup.picasso.Picasso;

import butterknife.Bind;
import butterknife.ButterKnife;
/**
 * Created by Guest on 7/8/16.
 */
public class PhotoListAdapter extends RecyclerView.Adapter<PhotoListAdapter.PhotoViewHolder> {
    private ArrayList<Photo> mPhotos = new ArrayList<>();
    private Context mContext;

    public PhotoListAdapter(Context context, ArrayList<Photo> photos){
        mContext = context;
        mPhotos = photos;
    }

    @Override
    public PhotoListAdapter.PhotoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_photo_list, parent, false);
        PhotoViewHolder viewHolder = new PhotoViewHolder(view);
        return viewHolder;
    }
    @Override
    public void onBindViewHolder(PhotoListAdapter.PhotoViewHolder holder, int position) {
        holder.bindPhoto(mPhotos.get(position));
    }

    @Override
    public int getItemCount() {
        return mPhotos.size();
    }

    public class PhotoViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.photosImageView) ImageView mPhotosImageView;
        @Bind(R.id.captionTextView) TextView mCaptionTextView;
        private Context mContext;

        public PhotoViewHolder(View itemView){
            super(itemView);
           ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
        }


        public void bindPhoto(Photo photo) {
            Picasso.with(mContext).load(photo.getUrl()).into(mPhotosImageView);
            mCaptionTextView.setText(photo.getCaption());
        }
    }

}