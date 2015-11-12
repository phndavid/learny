package com.lab.inmotion.learny.Activities;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.lab.inmotion.learny.R;

public class ChildRecordActivity extends AppCompatActivity {

    private ImageView gif;
   public void btnRegisterChild(View view){
       Intent theIntent = new Intent(this, LearnyActivity.class);
       startActivity(theIntent);
   }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child);
  /*      ImageView img = (ImageView)findViewById(R.id.gif);
        img.setBackgroundResource(R.mipmap.loading);
        AnimationDrawable frameAnimation = (AnimationDrawable) img.getBackground();
        frameAnimation.start();
*/
    }
}
