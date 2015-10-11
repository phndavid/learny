package com.lab.inmotion.learny;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class ActivityLogin extends AppCompatActivity {

    public void btnSignIn(View view){
        Intent theIntent = new Intent(this, ActivityPlay.class);
        startActivity(theIntent);
        finish();
    }
    public void btnSignUp(View view){
        Intent theIntent = new Intent(this, ActivitySignUp.class);
        startActivity(theIntent);
        finish();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_login);
    }

}
