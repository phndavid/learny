package com.lab.inmotion.learny.Activities;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.lab.inmotion.learny.R;

import java.util.ArrayList;
import java.util.List;

public class ChildRecordActivity extends AppCompatActivity {

    private ImageView gif;
    private Typeface tf;
   public void btnRegisterChild(View view){

       setContentView(R.layout.activity_childdos);
   }
    public void btnFinishRecord(View view){
        Intent theIntent = new Intent(this, LearnyActivity.class);
        startActivity(theIntent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child);
        tf=Typeface.createFromAsset(getAssets(),"fonts/CAFE.TTF");
        TextView lbl_name = (TextView) findViewById(R.id.lbl_name);
        lbl_name.setTypeface(tf);
        EditText txt_name = (EditText) findViewById(R.id.txt_escuOcol);
        txt_name.setTypeface(tf);
        TextView lbl_parents = (TextView) findViewById(R.id.lbl_parents);
        lbl_parents.setTypeface(tf);
        EditText txt_paretns = (EditText) findViewById(R.id.txt_lugar);
        txt_paretns.setTypeface(tf);
        // Spinner element
        Spinner spinner = (Spinner) findViewById(R.id.spinnerSex);

        // Spinner click listener
       // spinner.setOnItemSelectedListener(this);

        // Spinner Drop down elements
        List<String> categories = new ArrayList<String>();
        categories.add("Masculino");
        categories.add("Femenino");


        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);
    }
}
