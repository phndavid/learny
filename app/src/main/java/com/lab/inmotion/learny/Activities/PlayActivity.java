package com.lab.inmotion.learny.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.lab.inmotion.learny.Application.App;
import com.lab.inmotion.learny.Model.Category;
import com.lab.inmotion.learny.R;
import com.parse.ParseUser;

public class PlayActivity extends AppCompatActivity {

    public  void btnLogOut(View view){
        // Call the Parse log out method
        ParseUser.logOut();
        // Start and intent for the dispatch activity
        Intent theIntent = new Intent(this, LoginActivity.class);
        startActivity(theIntent);
        finish();

    }
    public void btnChildlist(View view){
        Intent theIntent = new Intent(this, ChildListActivity.class);
        startActivity(theIntent);
    }
    public void btnStart(View view){
        Intent theIntent = new Intent(this, ChildRecordActivity.class);
        startActivity(theIntent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        App app = (App) getApplication();
        System.out.println("size de los child: " + app.getModel().getEspecialista().getChilldren().size());
    }

}
