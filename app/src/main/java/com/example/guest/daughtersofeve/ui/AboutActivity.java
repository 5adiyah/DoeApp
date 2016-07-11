package com.example.guest.daughtersofeve.ui;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.guest.daughtersofeve.ui.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class AboutActivity extends AppCompatActivity implements View.OnClickListener{
    @Bind(R.id.aboutNameSadio) TextView mAboutNameSadio;
    @Bind(R.id.aboutNameAbeer) TextView mAboutNameAbeer;
    @Bind(R.id.aboutNameFatma) TextView mAboutNameFatma;
    @Bind(R.id.aboutNameFarah) TextView mAboutNameFarah;
    @Bind(R.id.aboutNameRaneem) TextView mAboutNameRaneem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        ButterKnife.bind(this);

        mAboutNameSadio.setOnClickListener(this);
        mAboutNameAbeer.setOnClickListener(this);
        mAboutNameFatma.setOnClickListener(this);
        mAboutNameFarah.setOnClickListener(this);
        mAboutNameRaneem.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == mAboutNameSadio) {
            Intent emailIntent = new Intent(Intent.ACTION_SEND);
            emailIntent.setData(Uri.parse("mailto:"));
            emailIntent.setType("text/plain");
            emailIntent.putExtra(Intent.EXTRA_EMAIL, "sadiyah@daughtersofeve.org");
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Your subject");
            emailIntent.putExtra(Intent.EXTRA_TEXT, "Message goes here");
            startActivity(Intent.createChooser(emailIntent, "Send mail..."));
            finish();
        } else if(v == mAboutNameAbeer){
            Intent emailIntent = new Intent(Intent.ACTION_SEND);
            emailIntent.setData(Uri.parse("mailto:"));
            emailIntent.setType("text/plain");
            emailIntent.putExtra(Intent.EXTRA_EMAIL, "abeer@daughtersofeve.org");
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Your subject");
            emailIntent.putExtra(Intent.EXTRA_TEXT, "Message goes here");
            startActivity(Intent.createChooser(emailIntent, "Send mail..."));
            finish();
        }else if(v == mAboutNameFatma){
            Intent emailIntent = new Intent(Intent.ACTION_SEND);
            emailIntent.setData(Uri.parse("mailto:"));
            emailIntent.setType("text/plain");
            emailIntent.putExtra(Intent.EXTRA_EMAIL, "fatma@daughtersofeve.org");
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Your subject");
            emailIntent.putExtra(Intent.EXTRA_TEXT, "Message goes here");
            startActivity(Intent.createChooser(emailIntent, "Send mail..."));
            finish();
        }else if(v == mAboutNameFarah){
            Intent emailIntent = new Intent(Intent.ACTION_SEND);
            emailIntent.setData(Uri.parse("mailto:"));
            emailIntent.setType("text/plain");
            emailIntent.putExtra(Intent.EXTRA_EMAIL, "farah@daughtersofeve.org");
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Your subject");
            emailIntent.putExtra(Intent.EXTRA_TEXT, "Message goes here");
            startActivity(Intent.createChooser(emailIntent, "Send mail..."));
            finish();
        }else if(v == mAboutNameRaneem){
            Intent emailIntent = new Intent(Intent.ACTION_SEND);
            emailIntent.setData(Uri.parse("mailto:"));
            emailIntent.setType("text/plain");
            emailIntent.putExtra(Intent.EXTRA_EMAIL, "raneem@daughtersofeve.org");
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Your subject");
            emailIntent.putExtra(Intent.EXTRA_TEXT, "Message goes here");
            startActivity(Intent.createChooser(emailIntent, "Send mail..."));
            finish();
        }

    }
}
