package com.example.guest.daughtersofeve.ui;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.guest.daughtersofeve.ui.R;
import com.google.firebase.auth.FirebaseAuth;

import butterknife.Bind;
import butterknife.ButterKnife;

public class AboutActivity extends AppCompatActivity implements View.OnClickListener{

    @Bind(R.id.popUpMenu) LinearLayout mPopUpMenu;
    @Bind(R.id.toggleMenu) ImageView mToggleMenu;
    @Bind(R.id.previousPage) ImageView mPreviousPage; //Change for each page
    @Bind(R.id.logoutButton) ImageView mLogoutButton;
    @Bind(R.id.topMenuBar) RelativeLayout mTopMenuBar;
    private boolean viewGroupIsVisible = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        ButterKnife.bind(this);


        mToggleMenu.setOnClickListener(this);
        mPreviousPage.setOnClickListener(this); //Add page it goes to
        mLogoutButton.setOnClickListener(this);
        mTopMenuBar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
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
            Intent intent = new Intent(AboutActivity.this, MainActivity.class);
            startActivity(intent);
        } else if (v == mTopMenuBar) {
            Intent intent = new Intent(AboutActivity.this, MainActivity.class);
            startActivity(intent);
        }

    }

    private void logout() {
        FirebaseAuth.getInstance().signOut();
        Intent intent = new Intent(AboutActivity.this, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }
}
