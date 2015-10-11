package com.lab.inmotion.learny.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.lab.inmotion.learny.R;

public class IntroActivity extends AppCompatActivity {

    public void btnLogin(View view){
        Intent theIntent = new Intent(this, LoginActivity.class);
        startActivity(theIntent);
        finish();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
    }


}
