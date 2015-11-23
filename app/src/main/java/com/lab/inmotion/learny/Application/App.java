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

import java.util.ArrayList;
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
                if(e!=null){
                    System.out.println("entro al error del query");
                    e.printStackTrace();
                }else{
                    System.out.println("al parecer hizo el query bien");
                    for(int i=0;i<objects.size();i++){
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
                        Child child = new Child();
                        child.setFirstName(firstName);
                        child.setLastName(lastName);
                        child.setBirth(birthDate);
                        child.setParentName(parentName);
                        child.setAddress(address);
                        child.setSchool(school);
                        child.setEducationLevel(educationLevel);
                        child.setTestPlace(testPlace);
                        child.setTestDate(testDate);

                        model.getEspecialista().addChildWithoutDB(child);

                    }
                }
            }
        });
    }
    public Learny getModel(){
        return model;
    }

}
