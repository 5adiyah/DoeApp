package com.example.guest.daughtersofeve;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.loginEmail) EditText mLoginEmail;
    @Bind(R.id.loginPassword) EditText mLoginPassword;
    @Bind(R.id.loginButton) Button mLoginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        mLoginButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String email = mLoginEmail.getText().toString();
                Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
                intent.putExtra("email", email);
                startActivity(intent);
            }
        });
    }
}
