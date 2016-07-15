package com.example.guest.daughtersofeve.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.guest.daughtersofeve.ui.R;
import com.google.firebase.auth.FirebaseAuth;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Bind(R.id.loginName) EditText mLoginName;
//    @Bind(R.id.loginPassword) EditText mLoginPassword;
    @Bind(R.id.loginButton) Button mLoginButton;
    @Bind(R.id.logoutButton) Button mLogoutButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        mLoginButton.setOnClickListener(this);
        mLogoutButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view){
        if(view == mLoginButton){
            String name = mLoginName.getText().toString();
            Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
            intent.putExtra("name", name);
            startActivity(intent);
        }

        if(view == mLogoutButton){
            logout();
        }
    }

    private void logout() {
        FirebaseAuth.getInstance().signOut();
        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }
}
