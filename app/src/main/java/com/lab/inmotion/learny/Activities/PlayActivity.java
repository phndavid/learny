package com.lab.inmotion.learny.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.lab.inmotion.learny.Application.App;
import com.lab.inmotion.learny.Model.Category;
import com.lab.inmotion.learny.Model.Learny;
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
        App app = (App) getApplication();
        int size = app.getModel().getEspecialista().getChilldren().size();
        if(size>0){
            Intent theIntent = new Intent(this, ChildListActivity.class);
            startActivity(theIntent);
        }else{
            Toast toast = Toast.makeText(this,"Aun no hay pacientes registrados",Toast.LENGTH_LONG);
            toast.show();
        }

    }
    public void btnStart(View view){
        App app = (App) getApplication();
        boolean currentChild = app.getModel().getEspecialista().theresCurrentChild();
        if(currentChild){
            Intent theIntent = new Intent(this, LearnyActivity.class);
            startActivity(theIntent);
        }else{
            Intent theIntent = new Intent(this, ChildRecordActivity.class);
            startActivity(theIntent);
        }

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        App app = (App) getApplication();
        System.out.println("size de los child: " + app.getModel().getEspecialista().getChilldren().size());
    }

}
