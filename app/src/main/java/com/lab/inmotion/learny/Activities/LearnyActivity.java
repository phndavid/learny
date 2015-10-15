package com.lab.inmotion.learny.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.lab.inmotion.learny.R;

public class LearnyActivity extends AppCompatActivity {

    public void playLearny(View view){
        Intent theIntent = new Intent(this, QuestionActivity.class);
        startActivity(theIntent);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learny);
    }

}
