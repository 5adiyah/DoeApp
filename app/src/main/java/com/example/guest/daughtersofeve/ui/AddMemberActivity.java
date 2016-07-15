package com.example.guest.daughtersofeve.ui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.guest.daughtersofeve.models.BoardMember;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.api.model.StringList;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import butterknife.Bind;
import butterknife.ButterKnife;

public class AddMemberActivity extends AppCompatActivity implements View.OnClickListener{
    @Bind(R.id.nameEditText) EditText mNameEditText;
    @Bind(R.id.positionEditText) EditText mPositionEditText;
    @Bind(R.id.imageUrl) EditText mImageUrl;
    @Bind(R.id.membersListView) TextView mMembersListView;
    @Bind(R.id.createMemberButton) Button mCreateMemberButton;

    public static final String TAG = CreateAccountActivity.class.getSimpleName();
    private DatabaseReference mMemberReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_member);
        ButterKnife.bind(this);

        mMemberReference = FirebaseDatabase
                .getInstance()
                .getReference()
                .child("BoardMember");

        mCreateMemberButton.setOnClickListener(this);
        mMembersListView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        if(v==mCreateMemberButton){
            String name = mNameEditText.getText().toString();
            String position = mPositionEditText.getText().toString();
            String imageUrl = mImageUrl.getText().toString();
            saveMemberToFirebase(name, imageUrl, position);

            Intent intent = new Intent(AddMemberActivity.this, MainActivity.class);
            startActivity(intent);
        }

        if(v==mMembersListView){
            Intent intent = new Intent(AddMemberActivity.this, AboutActivity.class);
            startActivity(intent);
        }
    }

    public void saveMemberToFirebase(String name, String imageUrl, String position){
        BoardMember member = new BoardMember(name, imageUrl, position);
        mMemberReference.push().setValue(member);
    }
}
