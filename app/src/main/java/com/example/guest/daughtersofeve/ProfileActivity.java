package com.example.guest.daughtersofeve;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.ButterKnife;

public class ProfileActivity extends AppCompatActivity {

    private TextView mProfileName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        mProfileName = (TextView) findViewById(R.id.profileName);
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");

        mProfileName.setText(name);

    }
}
