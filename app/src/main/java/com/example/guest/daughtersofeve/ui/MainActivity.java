package com.example.guest.daughtersofeve.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.guest.daughtersofeve.ui.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.loginName) EditText mLoginName;
//    @Bind(R.id.loginPassword) EditText mLoginPassword;
    @Bind(R.id.loginButton) Button mLoginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        mLoginButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String name = mLoginName.getText().toString();
                Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
                intent.putExtra("name", name);
                startActivity(intent);
            }
        });
    }
}
