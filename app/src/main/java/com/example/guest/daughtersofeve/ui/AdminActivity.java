package com.example.guest.daughtersofeve.ui;

import android.content.Intent;
import android.support.annotation.BinderThread;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;

public class AdminActivity extends AppCompatActivity implements View.OnClickListener {
    @Bind(R.id.passwordEditText) EditText mPasswordEditText;
    @Bind(R.id.passwordLoginButton) Button mPasswordLoginButton;
    @Bind(R.id.topMenuBar) RelativeLayout mTopMenuBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        ButterKnife.bind(this);

        mPasswordLoginButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == mPasswordLoginButton) {
            String password = mPasswordEditText.getText().toString();
            if (password.equals("DOEADMIN")) {
                Intent intent = new Intent(AdminActivity.this, AddEventsActivity.class);
                startActivity(intent);
            } else {
                Toast.makeText(AdminActivity.this, "Authentication failed.", Toast.LENGTH_SHORT).show();
            }
        }

        if (v==mTopMenuBar){
            Intent intent = new Intent(AdminActivity.this, MainActivity.class);
            startActivity(intent);
        }
    }

}
