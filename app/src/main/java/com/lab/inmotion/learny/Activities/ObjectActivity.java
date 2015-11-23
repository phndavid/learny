package com.lab.inmotion.learny.Activities;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.lab.inmotion.learny.Application.App;
import com.lab.inmotion.learny.Model.Learny;
import com.lab.inmotion.learny.R;

import java.io.ObjectStreamException;

public class ObjectActivity extends AppCompatActivity {


    private int[] imgResourceIds = {
            R.mipmap.ovejauno,R.mipmap.ovejados,R.mipmap.ovejatres,R.mipmap.ovejacuatro,
            R.mipmap.ovejacinco,R.mipmap.ovejaseis,R.mipmap.ovejasiete,R.mipmap.ovejaocho,R.mipmap.ovejanueve,

            R.mipmap.neverauno,R.mipmap.neverados,R.mipmap.neveratres,R.mipmap.neveracuatro,
            R.mipmap.neveracinco,R.mipmap.neveraseis,R.mipmap.neverasiete,R.mipmap.neveraoccho,R.mipmap.neveranueve,

            R.mipmap.camarauno,R.mipmap.camarados,R.mipmap.camaratres,R.mipmap.camaracuatro,
            R.mipmap.camaracinco,R.mipmap.camaraseis,R.mipmap.camarasiete,R.mipmap.camaraocho,R.mipmap.camaranueve,

            R.mipmap.micouno,R.mipmap.micodos,R.mipmap.micotres,R.mipmap.micocuatro,
            R.mipmap.micocinco,R.mipmap.micoseis,R.mipmap.micosiete,R.mipmap.micoocho,R.mipmap.miconueve,

            R.mipmap.leuno,R.mipmap.ledos,R.mipmap.letres,R.mipmap.leacuatro,
            R.mipmap.lecinco,R.mipmap.leseis,R.mipmap.lesiete,R.mipmap.leocho,R.mipmap.lenueve
    };

    private int[] fontResourceIds = {R.mipmap.fondooveja,R.mipmap.fondonevera,R.mipmap.fondocamara,R.mipmap.fondomico,R.mipmap.fondole};

    private  AlertDialog.Builder alertadd;
    private int position;
    private int count;
    private RelativeLayout relativeLayout;
    private Learny model;

    private Button imgRompe1;
    private Button imgRompe2;
    private Button imgRompe3;
    private Button imgRompe4;
    private Button imgRompe5;
    private Button imgRompe6;
    private Button imgRompe7;
    private Button imgRompe8;
    private Button imgRompe9;

    public void popupOptions(){
        alertadd = new AlertDialog.Builder(ObjectActivity.this);
        LayoutInflater factory = LayoutInflater.from(ObjectActivity.this);
        final View view1 = factory.inflate(R.layout.activity_options_object, null);
        alertadd.setView(view1);
        alertadd.show();
        setChangeTitleOption(view1);
        setChangeOptionsBackground(view1);
    }
    public void setChangeTitleOption(View view){
        int thecount= model.getCurrent().getCurrentTest().getId();
        switch (thecount){
            case 1:
                ImageView titleOption1 = (ImageView) view.findViewById(R.id.titleOption);
                titleOption1.setBackgroundResource(R.mipmap.popupnevera);
                break;
            case 2:
                ImageView titleOption2 = (ImageView) view.findViewById(R.id.titleOption);
                titleOption2.setBackgroundResource(R.mipmap.popupcamara);
                break;
            case 3:
                ImageView titleOption3 = (ImageView) view.findViewById(R.id.titleOption);
                titleOption3.setBackgroundResource(R.mipmap.popupmico);
                break;
            case 4:
                ImageView titleOption4 = (ImageView) view.findViewById(R.id.titleOption);
                titleOption4.setBackgroundResource(R.mipmap.popuple);
                break;
            case 5:
                break;
        }
    }
    public void setChangeOptionsBackground(View view){
        int count= model.getCurrent().getCurrentTest().getId();
        ImageButton option1 = (ImageButton) view.findViewById(R.id.option1);
        option1.setBackgroundResource(imgResourceIds[count*9]);
        ImageButton option2 = (ImageButton) view.findViewById(R.id.option2);
        option2.setBackgroundResource(imgResourceIds[count*9+1]);
        ImageButton option3 = (ImageButton) view.findViewById(R.id.option3);
        option3.setBackgroundResource(imgResourceIds[count*9+2]);
        ImageButton option4 = (ImageButton) view.findViewById(R.id.option4);
        option4.setBackgroundResource(imgResourceIds[count*9+3]);
        ImageButton option5 = (ImageButton) view.findViewById(R.id.option5);
        option5.setBackgroundResource(imgResourceIds[count*9+4]);
        ImageButton option6 = (ImageButton) view.findViewById(R.id.option6);
        option6.setBackgroundResource(imgResourceIds[count*9+5]);
        ImageButton option7 = (ImageButton) view.findViewById(R.id.option7);
        option7.setBackgroundResource(imgResourceIds[count*9+6]);
        ImageButton option8 = (ImageButton) view.findViewById(R.id.option8);
        option8.setBackgroundResource(imgResourceIds[count*9+7]);
        ImageButton option9 = (ImageButton) view.findViewById(R.id.option9);
        option9.setBackgroundResource(imgResourceIds[count*9+8]);
    }
    public void validateAnswer(int count) {
        if (imgRompe1.getBackground().getConstantState() == getResources().getDrawable(imgResourceIds[count*9]).getConstantState()) {
            if (imgRompe2.getBackground().getConstantState() == getResources().getDrawable(imgResourceIds[count * 9 + 1]).getConstantState())
                if (imgRompe3.getBackground().getConstantState() == getResources().getDrawable(imgResourceIds[count * 9 + 2]).getConstantState())
                    if (imgRompe4.getBackground().getConstantState() == getResources().getDrawable(imgResourceIds[count * 9 + 3]).getConstantState())
                        if (imgRompe5.getBackground().getConstantState() == getResources().getDrawable(imgResourceIds[count * 9 + 4]).getConstantState())
                            if (imgRompe6.getBackground().getConstantState() == getResources().getDrawable(imgResourceIds[count * 9 + 5]).getConstantState())
                                if (imgRompe7.getBackground().getConstantState() == getResources().getDrawable(imgResourceIds[count * 9 + 6]).getConstantState())
                                    if (imgRompe8.getBackground().getConstantState() == getResources().getDrawable(imgResourceIds[count * 9 + 7]).getConstantState())
                                        if (imgRompe9.getBackground().getConstantState() == getResources().getDrawable(imgResourceIds[count * 9 + 8]).getConstantState()){
                                            Toast.makeText(this, "Armo el rompecabezas bien!", Toast.LENGTH_LONG).show();
                                        }
        }


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
        int count= model.getCurrent().getCurrentTest().getId();
        changeImageoption(imgResourceIds[count*9]);
    }
    //---------------------------------------
    public void btnRompe2(View view){
        position = 2;
        popupOptions();
    }
    public void btnOption2(View view){
        int count= model.getCurrent().getCurrentTest().getId();
        changeImageoption(imgResourceIds[count*9+1]);
    }
    //----------------------------------------
    public void btnRompe3(View view){
        position = 3;
        popupOptions();
    }
    public void btnOption3(View view){
        int count= model.getCurrent().getCurrentTest().getId();
        changeImageoption(imgResourceIds[count*9+2]);
    }
    //---------------------------------------
    public void btnRompe4(View view){
        position = 4;
        popupOptions();
    }
    public void btnOption4(View view){
        int count= model.getCurrent().getCurrentTest().getId();
        changeImageoption(imgResourceIds[count*9+3]);
    }
    //---------------------------------------

    public void btnRompe5(View view){
        position = 5;
        popupOptions();
    }
    public void btnOption5(View view){
        int count= model.getCurrent().getCurrentTest().getId();
        changeImageoption(imgResourceIds[count*9+4]);
    }
    //---------------------------------------

    public void btnRompe6(View view){
        position = 6;
        popupOptions();
    }
    public void btnOption6(View view){
        int count= model.getCurrent().getCurrentTest().getId();
        changeImageoption(imgResourceIds[count*9+5]);
    }
    //---------------------------------------
    public void btnRompe7(View view){
        position = 7;
        popupOptions();
    }
    public void btnOption7(View view){
        int count= model.getCurrent().getCurrentTest().getId();
        changeImageoption(imgResourceIds[count*9+6]);
    }
    //---------------------------------------
    public void btnRompe8(View view){
        position = 8;
        popupOptions();
    }
    public void btnOption8(View view){
        int count= model.getCurrent().getCurrentTest().getId();
        changeImageoption(imgResourceIds[count*9+7]);
    }
    //---------------------------------------
    public void btnRompe9(View view){
        position = 9;
        popupOptions();
    }
    public void btnOption9(View view){
        int count= model.getCurrent().getCurrentTest().getId();
        changeImageoption(imgResourceIds[count*9+8]);
    }
    //---------------------------------------
    public void btnContinue(View view){
        Intent intent = new Intent(this,FeedBackActivity.class);
        intent.putExtra("category", "construyelos");
        intent.putExtra("count", model.getCurrent().getCurrentTest().getId());
        startActivity(intent);
        finish();
        count++;
        int actual = model.getCurrent().getCurrentTest().getId();
        if(actual<4) {
            validateAnswer(actual);
            System.out.println("puntaje acumulado: " + model.getCurrent().getPuntaje());
            model.nextTest();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_object);
        relativeLayout = (RelativeLayout) findViewById(R.id.backgroundObject);
        App app = (App) getApplication();
        model = app.getModel();
        imgRompe1 = (Button) findViewById(R.id.btn_rompe1);
        imgRompe2 = (Button) findViewById(R.id.btn_rompe2);
        imgRompe3 = (Button) findViewById(R.id.btn_rompe3);
        imgRompe4 = (Button) findViewById(R.id.btn_rompe4);
        imgRompe5 = (Button) findViewById(R.id.btn_rompe5);
        imgRompe6 = (Button) findViewById(R.id.btn_rompe6);
        imgRompe7 = (Button) findViewById(R.id.btn_rompe7);
        imgRompe8 = (Button) findViewById(R.id.btn_rompe8);
        imgRompe9 = (Button) findViewById(R.id.btn_rompe9);
    }
    @Override
    protected void onResume() {
        super.onResume();
        //init();
        System.out.println("OnResume Counter Sequence: " + count);
        int thecount= model.getCurrent().getCurrentTest().getId();
        if(thecount>0) {
            switch (thecount){
                case 1:
                    relativeLayout.setBackgroundResource(fontResourceIds[1]);
                    break;
                case 2:
                    relativeLayout.setBackgroundResource(fontResourceIds[2]);
                    break;
                case 3:
                    relativeLayout.setBackgroundResource(fontResourceIds[3]);
                    break;
                case 4:
                    relativeLayout.setBackgroundResource(fontResourceIds[4]);
                    break;
                case 5:
                    relativeLayout.setBackgroundResource(fontResourceIds[5]);
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
