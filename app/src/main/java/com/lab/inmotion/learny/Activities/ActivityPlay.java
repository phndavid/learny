package com.lab.inmotion.learny.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.lab.inmotion.learny.R;
import com.parse.ParseUser;

public class ActivityPlay extends AppCompatActivity {

    public  void btnLogOut(View view){
        // Call the Parse log out method
        ParseUser.logOut();
        // Start and intent for the dispatch activity
        Intent theIntent = new Intent(this, ActivityLogin.class);
        startActivity(theIntent);
        finish();

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_play);

    }

}
