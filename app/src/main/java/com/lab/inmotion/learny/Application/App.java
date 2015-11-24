package com.lab.inmotion.learny.Application;

import android.app.Application;

import com.lab.inmotion.learny.Model.Category;
import com.lab.inmotion.learny.Model.Child;
import com.lab.inmotion.learny.Model.Especialista;
import com.lab.inmotion.learny.Model.Learny;
import com.lab.inmotion.learny.Model.Test;
import com.parse.FindCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseInstallation;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseRelation;
import com.parse.ParseUser;
import com.parse.SaveCallback;

import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by N.David on 10/10/2015.
 */
public class App extends Application {

    // model reference
    private Learny model;
    @Override
    public void onCreate()
    {
        super.onCreate();
        ParseObject.registerSubclass(Category.class);
        ParseObject.registerSubclass(Child.class);
        ParseObject.registerSubclass(Test.class);
        ParseObject.registerSubclass(Especialista.class);
        Parse.initialize(this, "wXDXG6sGkprEE3sOV3aEhT1e5GEYkb6wl2g8IGY0", "kOn4wiJimLZvvVRHPAPQkQ5iHjxtLup12rjU7e8v");
        ParseInstallation.getCurrentInstallation().saveInBackground();

    }

    public void inicializeModel(String username, String password){
        model = new Learny(username,password);
        System.out.println("Especialista: " + model.getEspecialista().getChilldren().size());
        ParseRelation relation = ParseUser.getCurrentUser().getRelation("children");
        System.out.println("esto sale---: " + relation.toString());
        ParseQuery<ParseObject> query = relation.getQuery();
        query.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> objects, ParseException e) {
                if (e != null) {
                    System.out.println("entro al error del query");
                    e.printStackTrace();
                } else {
                    System.out.println("al parecer hizo el query bien");
                    System.out.println("primera consulta a relacion size: " + objects.size());
                    for (int i = 0; i < objects.size(); i++) {
                        ParseObject theChild = objects.get(i);
                        String firstName = theChild.getString("firstName");
                        String lastName = theChild.getString("lastName");
                        Date birthDate = theChild.getDate("birth");
                        Date testDate = theChild.getDate("testDate");
                        String testPlace = theChild.getString("testPlace");
                        String address = theChild.getString("address");
                        String parentName = theChild.getString("parentName");
                        String school = theChild.getString("school");
                        String educationLevel = theChild.getString("educationLevel");
                        String sex = theChild.getString("sex");
                        List<Integer> scores = theChild.getList("scores");
                        List times = theChild.getList("times");
                        double[] theScore = null;
                        double[] theTime = null;
                        if(scores==null){
                            theScore=new double[5];
                            theScore[0]=0;
                            theScore[1]=0;
                            theScore[2]=0;
                            theScore[3]=0;
                            theScore[4]=0;

                        }
                        if(times==null){
                            theTime=new double[5];
                            theTime[0] = 0;
                            theTime[1] = 0;
                            theTime[2] = 0;
                            theTime[3] = 0;
                            theTime[4] = 0;

                        }
                        if(scores!=null){
                            theScore = new double[scores.size()];
                            for(int k=0;k<scores.size();k++){
                                theScore[k] = (double)scores.get(k).intValue();
                            }
                        }
                        if(times!=null){
                            theTime = new double[scores.size()];
                            for(int k=0;k<scores.size();k++){
                                try{
                                    DecimalFormat df = new DecimalFormat("#.00");
                                    double firstTime = (double)times.get(k);
                                    String sTime = df.format(firstTime);
                                    double time = Double.parseDouble(sTime);
                                    theTime[k] = time;
                                }catch (Exception ex){
                                    theTime[k] = 0;
                                    theScore[k] = 0;
                                }

                            }
                        }
                        Child child = new Child();
                        child.setPuntajes(theScore);
                        child.setTiempos(theTime);
                        child.setFirstName(firstName);
                        child.setLastName(lastName);
                        child.setBirth(birthDate);
                        child.setParentName(parentName);
                        child.setAddress(address);
                        child.setSchool(school);
                        child.setEducationLevel(educationLevel);
                        child.setTestPlace(testPlace);
                        child.setTestDate(testDate);
                        child.setSex(sex);

                        model.getEspecialista().addChildWithoutDB(child);

                    }
                }
            }
        });
    }
    public Learny getModel(){
        return model;
    }
    public void registerScoreInDB(String firstName,String lastName, final double[] scores){
        ParseRelation relation = ParseUser.getCurrentUser().getRelation("children");
        ParseQuery<ParseObject> query = relation.getQuery();
        query.whereEqualTo("firstName",firstName);
        query.whereEqualTo("lastName",lastName);
        query.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> objects, ParseException e) {
                if(e!=null){
                    System.out.println("entro al error");
                    e.printStackTrace();
                }else{
                    for(int i=0;i<objects.size();i++){
                        ParseObject object = objects.get(i);
                        String thefirstName = object.getString("firstName");
                        System.out.println("Este es el firstName que trae de la DB:" + thefirstName);

                        for(int j=0;j<scores.length;j++){
                            System.out.println("---cada score cuando va a guardar:" + scores[j]);
                            object.add("scores",scores[j]);
                        }
                        object.saveInBackground(new SaveCallback() {
                            @Override
                            public void done(ParseException e) {
                                if (e != null) {
                                    System.out.println("llega al error del guardar score");
                                } else {
                                    System.out.println("guardo score satisfactoriamente");
                                }
                            }
                        });
                    }
                }
            }
        });
    }
    public void registerTimesInDB(String firstName,String lastName, final double[] times){
        ParseRelation relation = ParseUser.getCurrentUser().getRelation("children");
        ParseQuery<ParseObject> query = relation.getQuery();
        query.whereEqualTo("firstName",firstName);
        query.whereEqualTo("lastName",lastName);
        query.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> objects, ParseException e) {
                if(e!=null){
                    System.out.println("entro al error");
                    e.printStackTrace();
                }else{
                    for(int i=0;i<objects.size();i++){
                        ParseObject object = objects.get(i);
                        String thefirstName = object.getString("firstName");
                        System.out.println("Este es el firstName que trae de la DB:" + thefirstName);
                        for(int j=0;j<times.length;j++){
                            System.out.println("---cada time cuando va a guardar:" + times[i]);
                            object.add("times",times[j]);
                        }
                        object.saveInBackground(new SaveCallback() {
                            @Override
                            public void done(ParseException e) {
                                if (e != null) {
                                    System.out.println("llega al error del guardar score");
                                } else {
                                    System.out.println("guardo score satisfactoriamente");
                                }
                            }
                        });
                    }
                }
            }
        });
    }
}
