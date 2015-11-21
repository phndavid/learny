package com.lab.inmotion.learny.Activities;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RelativeLayout;

import com.lab.inmotion.learny.R;

public class FeedBackActivity extends AppCompatActivity {

    private int[] backgrounds = {R.mipmap.retrouno_xhdpi,R.mipmap.retrodos_xhdpi};

    private RelativeLayout relativeLayout;
    private int globalCount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed_back);
        relativeLayout = (RelativeLayout) findViewById(R.id.relafeedback);
        Bundle bundle = getIntent().getExtras();
        String level = bundle.getString("category");
        int count = bundle.getInt("count");
        globalCount = count;
        System.out.println(globalCount+ " este es el globalcount");
        if(count==0){
            relativeLayout.setBackgroundResource(backgrounds[0]);
        }
        if(count==1){
            relativeLayout.setBackgroundResource(backgrounds[1]);
        }


    }

    public void defineBackground(String category, String count){


    }
    public void tap(View view){
        if(globalCount<5){
            Intent theIntent = new Intent(this, FigureActivity.class);
            int  next = globalCount+1;
            System.out.println(next+ " este es el next");
            theIntent.putExtra("count",next);
            startActivity(theIntent);
            finish();
        }else{
            Intent theIntent = new Intent(this,CategoryActivity.class);
            startActivity(theIntent);
            finish();
        }
    }

}
