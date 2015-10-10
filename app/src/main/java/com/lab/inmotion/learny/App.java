package com.lab.inmotion.learny;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseInstallation;

/**
 * Created by N.David on 10/10/2015.
 */
public class App extends Application {

    @Override
    public void onCreate()
    {
        super.onCreate();
        Parse.initialize(this, "wXDXG6sGkprEE3sOV3aEhT1e5GEYkb6wl2g8IGY0", "kOn4wiJimLZvvVRHPAPQkQ5iHjxtLup12rjU7e8v");
        ParseInstallation.getCurrentInstallation().saveInBackground();
    }
}
