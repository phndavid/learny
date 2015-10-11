package com.lab.inmotion.learny.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.parse.ParseUser;

public class ActivityDispatch extends AppCompatActivity {

    public ActivityDispatch() {
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Check if there is current user info
        if (ParseUser.getCurrentUser() != null) {
            // Start an intent for the logged in activity
            startActivity(new Intent(this, ActivityPlay.class));
        } else {
            // Start and intent for the logged out activity
            startActivity(new Intent(this, ActivityLogin.class));
        }
    }
}
