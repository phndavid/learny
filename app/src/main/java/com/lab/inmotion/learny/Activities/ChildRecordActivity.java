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
       TextView lbl_school = (TextView) findViewById(R.id.lbl_school);
       lbl_school.setTypeface(tf);
       TextView lbl_semester = (TextView) findViewById(R.id.lbl_semester);
       lbl_semester.setTypeface(tf);
       TextView lbl_place = (TextView) findViewById(R.id.lbl_place);
       lbl_place.setTypeface(tf);
       TextView lbl_dateTest = (TextView) findViewById(R.id.lbl_dateTest);
       lbl_dateTest.setTypeface(tf);

       EditText txt_school = (EditText) findViewById(R.id.txt_school);
       txt_school.setTypeface(tf);
       EditText txt_semester = (EditText) findViewById(R.id.txt_semester);
       txt_semester.setTypeface(tf);
       EditText txt_place = (EditText) findViewById(R.id.txt_place);
       txt_place.setTypeface(tf);
       EditText txt_dayTest = (EditText) findViewById(R.id.txt_dayTest);
       txt_dayTest.setTypeface(tf);
       EditText txt_mothTest = (EditText) findViewById(R.id.txt_mothTest);
       txt_mothTest.setTypeface(tf);
       EditText txt_yearTest = (EditText) findViewById(R.id.txt_yearTest);
       txt_yearTest.setTypeface(tf);
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
        TextView lbl_birth = (TextView) findViewById(R.id.lbl_birth);
        lbl_birth.setTypeface(tf);
        TextView lbl_sex = (TextView) findViewById(R.id.lbl_sex);
        lbl_sex.setTypeface(tf);
        TextView lbl_address = (TextView) findViewById(R.id.lbl_address);
        lbl_address.setTypeface(tf);
        TextView lbl_parents = (TextView) findViewById(R.id.lbl_parents);
        lbl_parents.setTypeface(tf);



        EditText txt_name = (EditText) findViewById(R.id.txt_name);
        txt_name.setTypeface(tf);
        EditText txt_address = (EditText) findViewById(R.id.txt_address);
        txt_address.setTypeface(tf);
        EditText txt_dayBirth = (EditText) findViewById(R.id.txt_dayBirth);
        txt_dayBirth.setTypeface(tf);
        EditText txt_mothBirth = (EditText) findViewById(R.id.txt_mothBirth);
        txt_mothBirth.setTypeface(tf);
        EditText txt_yearBirth = (EditText) findViewById(R.id.txt_yearBirth);
        txt_yearBirth.setTypeface(tf);
        EditText txt_paretns = (EditText) findViewById(R.id.txt_parents);
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
