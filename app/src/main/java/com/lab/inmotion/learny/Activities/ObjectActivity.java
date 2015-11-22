package com.lab.inmotion.learny.Activities;

import android.app.AlertDialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import com.lab.inmotion.learny.R;

import java.io.ObjectStreamException;

public class ObjectActivity extends AppCompatActivity {


    private int[] imgResourceIds = {
            R.mipmap.ovejauno,R.mipmap.ovejados,R.mipmap.ovejatres,R.mipmap.ovejacuatro,
            R.mipmap.ovejacinco,R.mipmap.ovejaseis,R.mipmap.ovejasiete,R.mipmap.ovejaocho,R.mipmap.ovejanueve,

            R.mipmap.neverauno,R.mipmap.neverados,R.mipmap.neveratres,R.mipmap.neveracuatro,
            R.mipmap.neveracinco,R.mipmap.neveraseis,R.mipmap.neverasiete,R.mipmap.neveraoccho,R.mipmap.neveranueve};
    private int[] fontResourceIds = {R.mipmap.fondouno,R.mipmap.fondodos,R.mipmap.fondotres,R.mipmap.fondocuatro,R.mipmap.fondocinco};

    private  AlertDialog.Builder alertadd;
    private int position;
    public void popupOptions(){
        alertadd = new AlertDialog.Builder(ObjectActivity.this);
        LayoutInflater factory = LayoutInflater.from(ObjectActivity.this);
        final View view1 = factory.inflate(R.layout.activity_options_object, null);
        alertadd.setView(view1);
        alertadd.show();
    }
    public void changeImageoption(int imgResourceIds){
        switch (position){
            case 1:
                Button btn_rompe1 = (Button) findViewById(R.id.btn_rompe1);
                btn_rompe1.setBackgroundResource(imgResourceIds);
                break;
            case 2:
                Button btn_rompe2 = (Button) findViewById(R.id.btn_rompe2);
                btn_rompe2.setBackgroundResource(imgResourceIds);
                break;
            case 3:
                Button btn_rompe3 = (Button) findViewById(R.id.btn_rompe3);
                btn_rompe3.setBackgroundResource(imgResourceIds);
                break;
            case 4:
                Button btn_rompe4 = (Button) findViewById(R.id.btn_rompe4);
                btn_rompe4.setBackgroundResource(imgResourceIds);
                break;
            case 5:
                Button btn_rompe5 = (Button) findViewById(R.id.btn_rompe5);
                btn_rompe5.setBackgroundResource(imgResourceIds);
                break;
            case 6:
                Button btn_rompe6 = (Button) findViewById(R.id.btn_rompe6);
                btn_rompe6.setBackgroundResource(imgResourceIds);
                break;
            case 7:
                Button btn_rompe7 = (Button) findViewById(R.id.btn_rompe7);
                btn_rompe7.setBackgroundResource(imgResourceIds);
                break;
            case 8:
                Button btn_rompe8 = (Button) findViewById(R.id.btn_rompe8);
                btn_rompe8.setBackgroundResource(imgResourceIds);
                break;
            case 9:
                Button btn_rompe9 = (Button) findViewById(R.id.btn_rompe9);
                btn_rompe9.setBackgroundResource(imgResourceIds);
                break;

        }
    }
    public void btnRompe1(View view){
        position = 1;
        popupOptions();
    }
    public void btnOption1(View view){
        changeImageoption(imgResourceIds[0]);
    }
    //---------------------------------------
    public void btnRompe2(View view){
        position = 2;
        popupOptions();
    }
    public void btnOption2(View view){
        changeImageoption(imgResourceIds[1]);
    }
    //----------------------------------------
    public void btnRompe3(View view){
        position = 3;
        popupOptions();
    }
    public void btnOption3(View view){
        changeImageoption(imgResourceIds[2]);
    }
    //---------------------------------------
    public void btnRompe4(View view){
        position = 4;
        popupOptions();
    }
    public void btnOption4(View view){
        changeImageoption(imgResourceIds[3]);
    }
    //---------------------------------------

    public void btnRompe5(View view){
        position = 5;
        popupOptions();
    }
    public void btnOption5(View view){
        changeImageoption(imgResourceIds[4]);
    }
    //---------------------------------------

    public void btnRompe6(View view){
        position = 6;
        popupOptions();
    }
    public void btnOption6(View view){
        changeImageoption(imgResourceIds[5]);
    }
    //---------------------------------------
    public void btnRompe7(View view){
        position = 7;
        popupOptions();
    }
    public void btnOption7(View view){
        changeImageoption(imgResourceIds[6]);
    }
    //---------------------------------------
    public void btnRompe8(View view){
        position = 8;
        popupOptions();
    }
    public void btnOption8(View view){
        changeImageoption(imgResourceIds[7]);
    }
    //---------------------------------------
    public void btnRompe9(View view){
        position = 9;
        popupOptions();
    }
    public void btnOption9(View view){
        changeImageoption(imgResourceIds[8]);
    }
    //---------------------------------------

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_object);
    }

}
