package com.lab.inmotion.learny.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lab.inmotion.learny.Application.App;
import com.lab.inmotion.learny.Model.Learny;
import com.lab.inmotion.learny.R;

import java.lang.reflect.Field;

import static com.lab.inmotion.learny.R.*;

public class KeyActivity extends AppCompatActivity {

    private RelativeLayout relativeLayout;
    private ImageView imgFigure;
    private TextView textNumber;
    private String word;
    private LinearLayout miL;
    private Learny model;
    private ImageView elIma;

    private  int count;
    private int[] imgResourceIds = {R.mipmap.uno, R.mipmap.dos, R.mipmap.tres, R.mipmap.cuatro, R.mipmap.cinco, R.mipmap.seis, R.mipmap.siete,
            R.mipmap.ocho, R.mipmap.nueve};
    private String[] numbers = {"31242","76532","98421","78128"};

    public void btnOne(View view ){
        ImageView myImage = new ImageView(this);
        myImage.setImageResource(R.mipmap.uno);
        miL.addView(myImage);
        setContentView(miL);
    }
    public void btnTwo(View view ){
        ImageView myImage = new ImageView(this);
        myImage.setImageResource(R.mipmap.uno);
        miL.addView(myImage);
        setContentView(miL);

    }
    public void btnThree(View view ){
        ImageView myImage = new ImageView(this);
        myImage.setImageResource(R.mipmap.uno);
        miL.addView(myImage);
        setContentView(miL);
    }
    public void btnFour(View view ){
        ImageView myImage = new ImageView(this);
        myImage.setImageResource(R.mipmap.uno);
        miL.addView(myImage);
        setContentView(miL);
    }
    public void btnFive(View view ){
        ImageView myImage = new ImageView(this);
        myImage.setImageResource(R.mipmap.uno);
        miL.addView(myImage);
        setContentView(miL);
    }
    public void btnSix(View view ){
        ImageView myImage = new ImageView(this);
        myImage.setImageResource(R.mipmap.uno);
        miL.addView(myImage);
        setContentView(miL);
    }
    public void btnSeven(View view ){
        ImageView myImage = new ImageView(this);
        myImage.setImageResource(R.mipmap.uno);
        miL.addView(myImage);
        setContentView(miL);
    }
    public void btnEight(View view ){
        ImageView myImage = new ImageView(this);
        myImage.setImageResource(R.mipmap.uno);
        miL.addView(myImage);
        setContentView(miL);
    }
    public void btnNine(View view ){
        ImageView myImage = new ImageView(this);
        myImage.setImageResource(R.mipmap.uno);
        miL.addView(myImage);
        setContentView(miL);
    }
    public void btnContinueKey(View view){
        Intent intent = new Intent(this,FeedBackActivity.class);
        intent.putExtra("category", "descifraClave");
        intent.putExtra("count", model.getCurrent().getCurrentTest().getId());
        startActivity(intent);
        count++;
        int actual = model.getCurrent().getCurrentTest().getId();
        if(actual<4) {
            System.out.println("puntaje acumulado:" + model.getCurrent().getPuntaje());
            model.nextTest();
        }

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_key);
        setContentView(layout.activity_figure);
        System.out.println("se ejecuta el oncreate");
        imgFigure = (ImageView) findViewById(id.imgFigure);
        textNumber = (TextView) findViewById(id.textViewNumber);
        App app = (App) getApplication();
        model = app.getModel();
        miL= (LinearLayout) findViewById(id.linearLa);
    }

    protected void onResume() {
        super.onResume();
        System.out.println("OnResume Counter Sequence: " +count);
        int thecount= model.getCurrent().getCurrentTest().getId();
        if(thecount>0) {
            switch (thecount){
                case 1:
                    word = word+numbers[1];
                    textNumber.setText(word);
                    break;
                case 2:
                    word = word+numbers[2];
                    textNumber.setText(word);
                    break;
                case 3:
                    word = word+numbers[3];
                    textNumber.setText(word);
                    break;
                case 4:
                    word = word+numbers[4];
                    textNumber.setText(word);
                    break;
            }
        }
    }
}
