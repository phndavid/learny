package com.lab.inmotion.learny.Activities;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.lab.inmotion.learny.Application.App;
import com.lab.inmotion.learny.Model.Learny;
import com.lab.inmotion.learny.R;

public class KeyActivity extends AppCompatActivity {


    private TextView textNumber;
    private String number;
    private Learny model;
    private ImageView imgPosOne;
    private ImageView imgPosTwo;
    private ImageView imgPosThree;
    private ImageView imgPosFour;
    private ImageView imgPosFive;

    private Typeface tf;

    private int[] imgResourceIds = {R.mipmap.uno, R.mipmap.dos, R.mipmap.tres, R.mipmap.cuatro, R.mipmap.cinco, R.mipmap.seis, R.mipmap.siete,
            R.mipmap.ocho, R.mipmap.nueve};
    private String[] numbers = {"31242", "76532", "98421", "78128","45892"};

    public void init() {
        number = "";
        imgPosOne = (ImageView) findViewById(R.id.imgDigOne);
        imgPosTwo = (ImageView) findViewById(R.id.imgDigTwo);
        imgPosThree = (ImageView) findViewById(R.id.imgDigThree);
        imgPosFour = (ImageView) findViewById(R.id.imgDigFour);
        imgPosFive = (ImageView) findViewById(R.id.imgDigFive);
    }

    public void validePostion(int imgResourceIds, String num) {
        if (imgPosOne.getBackground().getConstantState() == getResources().getDrawable(R.mipmap.fondonumero).getConstantState()) {
            imgPosOne.setBackgroundResource(imgResourceIds);
            number += num;
        } else if (imgPosTwo.getBackground().getConstantState() == getResources().getDrawable(R.mipmap.fondonumero).getConstantState()) {
            imgPosTwo.setBackgroundResource(imgResourceIds);
            number += num;
        } else if (imgPosThree.getBackground().getConstantState() == getResources().getDrawable(R.mipmap.fondonumero).getConstantState()) {
            imgPosThree.setBackgroundResource(imgResourceIds);
            number += num;
        } else if (imgPosFour.getBackground().getConstantState() == getResources().getDrawable(R.mipmap.fondonumero).getConstantState()) {
            imgPosFour.setBackgroundResource(imgResourceIds);
            number += num;
        } else if (imgPosFive.getBackground().getConstantState() == getResources().getDrawable(R.mipmap.fondonumero).getConstantState()) {
            imgPosFive.setBackgroundResource(imgResourceIds);
            number += num;
        }
        Toast.makeText(this, "Num: " + number, Toast.LENGTH_LONG).show();
    }

    public void btnOne(View view) {
        validePostion(imgResourceIds[0], "1");
    }

    public void btnTwo(View view) {
        validePostion(imgResourceIds[1], "2");
    }

    public void btnThree(View view) {
        validePostion(imgResourceIds[2], "3");
    }

    public void btnFour(View view) {
        validePostion(imgResourceIds[3], "4");
    }

    public void btnFive(View view) {
        validePostion(imgResourceIds[4], "5");
    }

    public void btnSix(View view) {
        validePostion(imgResourceIds[5], "6");
    }

    public void btnSeven(View view) {
        validePostion(imgResourceIds[6], "7");
    }

    public void btnEight(View view) {
        validePostion(imgResourceIds[7], "8");
    }

    public void btnNine(View view) {
        validePostion(imgResourceIds[8], "9");
    }

    public void btnContinueKey(View view) {
        Intent intent = new Intent(this,FeedBackActivity.class);
        intent.putExtra("category", "descifraClave");
        intent.putExtra("count", model.getCurrent().getCurrentTest().getId());
        startActivity(intent);
        finish();
        int actual = model.getCurrent().getCurrentTest().getId();
        if(actual<4) {
            System.out.println("puntaje acumulado: " + model.getCurrent().getPuntaje());
            model.nextTest();
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_key);
        init();
        tf=Typeface.createFromAsset(getAssets(), "fonts/CAFE.TTF");
        textNumber = (TextView) findViewById(R.id.textViewNumber);
        textNumber.setTypeface(tf);
        App app = (App) getApplication();
        model = app.getModel();
    }
    @Override
    protected void onResume() {
        super.onResume();
        int thecount= model.getCurrent().getCurrentTest().getId();
        if (thecount > 0) {
            switch (thecount) {
                case 1:
                    textNumber.setText(numbers[1]);
                    break;
                case 2:
                    textNumber.setText(numbers[2]);
                    break;
                case 3:
                    textNumber.setText(numbers[3]);
                    break;
                case 4:
                    textNumber.setText(numbers[4]);
                    break;
                case 5:

                    break;
            }
        }
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        System.out.println("se ejecuta el onrestart");

    }
}