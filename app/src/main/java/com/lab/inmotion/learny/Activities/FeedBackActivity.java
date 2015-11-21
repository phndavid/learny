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

import com.lab.inmotion.learny.Application.App;
import com.lab.inmotion.learny.Model.Category;
import com.lab.inmotion.learny.R;

public class FeedBackActivity extends AppCompatActivity {

    private int[] backgrounds = {R.mipmap.retrouno_xhdpi,R.mipmap.retrodos_xhdpi,R.mipmap.retrotres_xhdpi,R.mipmap.retrocuatro_xhdpi,R.mipmap.retrocinco};


    private RelativeLayout relativeLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed_back);
        relativeLayout = (RelativeLayout) findViewById(R.id.relafeedback);
        Bundle bundle = getIntent().getExtras();
        String level = bundle.getString("category");
        int count = bundle.getInt("count");
        relativeLayout.setBackgroundResource(backgrounds[count]);
    }

    public void defineBackground(String category, String count){


    }
    public void tap(View view){
        App app = (App) getApplication();

        int globalCount = app.getModel().getCurrent().getCurrentTest().getId();
        if(globalCount<4){
            Intent theIntent = new Intent(this, FigureActivity.class);
            int  next = globalCount+1;
            System.out.println(next+ " este es el next");
            theIntent.putExtra("count",next);
            startActivity(theIntent);
            finish();
        }else{
            app.getModel().nextCategory();
            Intent theIntent = new Intent(this,CategoryActivity.class);
            startActivity(theIntent);
            finish();
        }
    }

}
