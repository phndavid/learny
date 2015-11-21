package com.lab.inmotion.learny.Application;

import android.app.Application;

import com.lab.inmotion.learny.Model.Category;
import com.lab.inmotion.learny.Model.Child;
import com.lab.inmotion.learny.Model.Especialista;
import com.lab.inmotion.learny.Model.Learny;
import com.lab.inmotion.learny.Model.Test;
import com.parse.Parse;
import com.parse.ParseInstallation;
import com.parse.ParseObject;

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
    }
    public Learny getModel(){
        return model;
    }

}
