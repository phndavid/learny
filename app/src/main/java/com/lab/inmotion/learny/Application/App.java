package com.lab.inmotion.learny.Application;

import android.app.Application;

import com.lab.inmotion.learny.Model.Learny;
import com.parse.Parse;
import com.parse.ParseInstallation;

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
        Parse.initialize(this, "wXDXG6sGkprEE3sOV3aEhT1e5GEYkb6wl2g8IGY0", "kOn4wiJimLZvvVRHPAPQkQ5iHjxtLup12rjU7e8v");
        ParseInstallation.getCurrentInstallation().saveInBackground();
    }

    public void inicializeModel(String username, String password){
        model = new Learny(username,password);
    }

}
