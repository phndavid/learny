package com.lab.inmotion.learny.Activities;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.lab.inmotion.learny.Application.App;
import com.lab.inmotion.learny.Model.Child;
import com.lab.inmotion.learny.R;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseRelation;
import com.parse.ParseUser;
import com.parse.SaveCallback;

import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ChildRecordActivity extends AppCompatActivity {

    private ImageView gif;
    private Typeface tf;
    private EditText txt_name;
    private EditText txt_address;
    private EditText txt_dayBirth;
    private EditText txt_mothBirth;
    private EditText txt_yearBirth;
    private EditText txt_paretns;
    private EditText txt_school;
    private EditText txt_semester;
    private EditText txt_place;
    private EditText txt_dayTest;
    private EditText txt_mothTest;
    private EditText txt_yearTest;
    private Spinner spinner;

   public void btnRegisterChild(View view){

       boolean cancontinue = false;


       String fullName = txt_name.getText().toString();
       String birthday = txt_dayBirth.getText().toString();
       String birthmonth = txt_mothBirth.getText().toString();
       String birthyear = txt_yearBirth.getText().toString();
       String sDate = birthday + "/" + birthmonth + "/" + birthyear;
       System.out.println("seleccion del spinner: " + spinner.getSelectedItem().toString());
       SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
       try{
           String [] names = fullName.split(" ");
           String firstName = names[0];
           String lastName = names[1];
           Date birthdate = df.parse(sDate);
           cancontinue=true;
       } catch (IndexOutOfBoundsException e){
           String message = "por favor use un formato: 'nombre apellido' para el nombre del paciente";
           Context context = getApplicationContext();
           int duration = Toast.LENGTH_LONG;
           Toast toast = Toast.makeText(context,message,duration);
           toast.show();

       } catch (Exception e){
           boolean canContinue = false;
           Context context = getApplicationContext();
           String message = "Por favor utilice un formato dd MM yyyy para la fecha";
           int duration = Toast.LENGTH_SHORT;
           Toast toast = Toast.makeText(context,message,duration);
           toast.show();

       }
       if(cancontinue){
           setContentView(R.layout.activity_childdos);
           TextView lbl_school = (TextView) findViewById(R.id.lbl_school);
           lbl_school.setTypeface(tf);
           TextView lbl_semester = (TextView) findViewById(R.id.lbl_semester);
           lbl_semester.setTypeface(tf);
           TextView lbl_place = (TextView) findViewById(R.id.lbl_place);
           lbl_place.setTypeface(tf);
           TextView lbl_dateTest = (TextView) findViewById(R.id.lbl_dateTest);
           lbl_dateTest.setTypeface(tf);

           txt_school = (EditText) findViewById(R.id.txt_school);
           txt_school.setTypeface(tf);
           txt_semester = (EditText) findViewById(R.id.txt_semester);
           txt_semester.setTypeface(tf);
           txt_place = (EditText) findViewById(R.id.txt_place);
           txt_place.setTypeface(tf);
           txt_dayTest = (EditText) findViewById(R.id.txt_dayTest);
           txt_dayTest.setTypeface(tf);
           txt_mothTest = (EditText) findViewById(R.id.txt_mothTest);
           txt_mothTest.setTypeface(tf);
           txt_yearTest = (EditText) findViewById(R.id.txt_yearTest);
           txt_yearTest.setTypeface(tf);
       }
   }
    public void btnFinishRecord(View view){
        boolean cancontinue = false;
        String fullName = txt_name.getText().toString();
        String [] names = fullName.split(" ");
        String firstName = names[0];
        String lastName = names[1];
        String birthday = txt_dayBirth.getText().toString();
        String birthmonth = txt_mothBirth.getText().toString();
        String birthyear = txt_yearBirth.getText().toString();
        String sDate = birthday + "/" + birthmonth + "/" + birthyear;
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        String parentname = txt_paretns.getText().toString();
        String address = txt_address.getText().toString();
        String school = txt_school.getText().toString();
        String semester = txt_semester.getText().toString();
        String testPlace = txt_place.getText().toString();
        String testday = txt_dayTest.getText().toString();
        String testmonth = txt_mothTest.getText().toString();
        String testyear = txt_yearTest.getText().toString();
        String sex = spinner.getSelectedItem().toString();
        String sTestDate = testday + "/" + testmonth + "/" + testyear;
        Date birthdate = null;
        Date testdate = null;
        try{
            birthdate = df.parse(sDate);
            testdate = df.parse(sTestDate);
            cancontinue=true;
        }catch (Exception e){
            cancontinue = false;
            Context context = getApplicationContext();
            String message = "Por favor utilice un formato dd MM yyyy para la fecha";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context,message,duration);
            toast.show();

        }
        System.out.println("birthdate: " + birthdate.toString());
        System.out.println("birthdate: " + testdate.toString());
        if(cancontinue){
            App app = (App) getApplication();
            Child child = new Child();
            child.setFirstName(firstName);
            child.setLastName(lastName);
            child.setBirth(birthdate);
            child.setAddress(address);
            child.setSchool(school);
            child.setEducationLevel(semester);
            child.setTestPlace(testPlace);
            child.setParentName(parentname);
            child.setTestDate(testdate);
            child.setSex(sex);
            app.getModel().getEspecialista().addChild(child);
            registerChildInDB(child);
            Intent theIntent = new Intent(this, LearnyActivity.class);
            startActivity(theIntent);
        }
    }
    public void registerChildInDB(final Child thechild){
        // Set up a progress dialog
        final ProgressDialog dialog = new ProgressDialog(this);
        dialog.setMessage("Registrando paciente");
        dialog.show();
        final ParseObject object = ParseObject.create("Child");
        System.out.println("datos del child:" + thechild.getFirstName());
        object.put("firstName", thechild.getFirstName());
        object.put("lastName", thechild.getLastName());
        object.put("birth",thechild.getBirth());
        object.put("educationLevel",thechild.getEducationLevel());
        object.put("parentName",thechild.getParentName());
        object.put("school",thechild.getSchool());
        object.put("address", thechild.getAddress());
        object.put("testPlace",thechild.getTestPlace());
        object.put("testDate",thechild.getTestDate());
        object.put("sex",thechild.getSex());
        object.saveInBackground(new SaveCallback() {
            @Override
            public void done(ParseException e) {
                if (e != null) {
                    System.out.println("e del primer save");
                    e.printStackTrace();
                } else {
                    System.out.println("success primer save");
                    final ParseUser user = ParseUser.getCurrentUser();
                    //user.setUsername(username);
                    System.out.println("currentUser: " + user.getObjectId());
                    System.out.println("currentUsername: " + user.getUsername());
                    ParseRelation relation = user.getRelation("children");
                    System.out.println("relacion children:" + relation.toString());
                    System.out.println("---prueba de datos---");
                    System.out.println("firstName: " + thechild.getFirstName());
                    System.out.println("lastName: " + thechild.getLastName());
                    System.out.println("birthdate:" + thechild.getBirth());
                    System.out.println("address: " + thechild.getAddress());
                    System.out.println("---Prueba de datos---");
                    relation.add(object);
                    user.saveInBackground(new SaveCallback() {
                        @Override
                        public void done(ParseException e) {
                            if (e != null) {
                                e.printStackTrace();
                            } else {
                                System.out.println("lo registro oh yeah");
                                dialog.dismiss();
                                try {
                                    user.fetch();
                                } catch (ParseException e1) {
                                    e1.printStackTrace();
                                    System.out.println("entro al excepcion del fetch");
                                }
                            }
                        }
                    });
                }
            }
        });
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child);
        tf=Typeface.createFromAsset(getAssets(), "fonts/CAFE.TTF");
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


        txt_name = (EditText) findViewById(R.id.txt_name);
        txt_name.setTypeface(tf);

        txt_address = (EditText) findViewById(R.id.txt_address);
        txt_address.setTypeface(tf);

        txt_dayBirth = (EditText) findViewById(R.id.txt_dayBirth);
        txt_dayBirth.setTypeface(tf);
        txt_mothBirth = (EditText) findViewById(R.id.txt_mothBirth);
        txt_mothBirth.setTypeface(tf);

        txt_yearBirth = (EditText) findViewById(R.id.txt_yearBirth);
        txt_yearBirth.setTypeface(tf);

        txt_paretns = (EditText) findViewById(R.id.txt_parents);
        txt_paretns.setTypeface(tf);


        // Spinner element
        spinner = (Spinner) findViewById(R.id.spinnerSex);

        // Spinner click listener
        //spinner.setOnItemSelectedListener(this);

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
