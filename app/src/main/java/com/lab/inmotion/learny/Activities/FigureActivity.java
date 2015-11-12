package com.lab.inmotion.learny.Activities;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.lab.inmotion.learny.R;

public class FigureActivity extends AppCompatActivity {

    private int[] imgResourceIds = {R.mipmap.carro_xhdpi, R.mipmap.gato_xhdpi,R.mipmap.reloj_xhdpi,R.mipmap.espejo,R.mipmap.mesa_xhdpi};
    private int[] fontResourceIds = {R.mipmap.nivelunoamarillo_xhdpi, R.mipmap.nivelunoazul_xhdpi,R.mipmap.nivelunorosa_xhdpi,R.mipmap.nivelunoverde_xhdpi,R.mipmap.nivelunovioleta_xhdpi};
    private  int count;
    private RelativeLayout relativeLayout;
    private ImageView imgFigure;
    public void  btn_q(View view){

    }
    public void  btn_w(View view){

    }
    public void btn_next(View view){
        count++;
        switch (count){
            case 1:
                relativeLayout.setBackgroundResource(fontResourceIds[1]);
                imgFigure.setBackgroundResource(imgResourceIds[1]);
                break;
            case 2:
                relativeLayout.setBackgroundResource(fontResourceIds[2]);
                imgFigure.setBackgroundResource(imgResourceIds[2]);
                break;
            case 3:
                relativeLayout.setBackgroundResource(fontResourceIds[3]);
                imgFigure.setBackgroundResource(imgResourceIds[3]);
                break;
            case 4:
                relativeLayout.setBackgroundResource(fontResourceIds[4]);
                imgFigure.setBackgroundResource(imgResourceIds[4]);
                break;
            case 5:
                Intent theIntent = new Intent(this,CategoryActivity.class);
                startActivity(theIntent);
                finish();
                break;
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_figure);
        relativeLayout = (RelativeLayout) findViewById(R.id.backgroundFigure);
        imgFigure = (ImageView) findViewById(R.id.imgFigure);
    }

}
