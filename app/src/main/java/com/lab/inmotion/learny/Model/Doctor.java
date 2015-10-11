package com.lab.inmotion.learny.Model;

import com.parse.ParseClassName;
import com.parse.ParseObject;
import com.parse.ParseUser;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by InMotionLab on 10/10/2015.
 */
@ParseClassName("_User")
public class Doctor extends ParseUser{

    private String id;
    private String username;
    private String password;
    private List<Child> children = new ArrayList<Child>();

    public void addChild(Child child){
        children.add(child);
        ParseUser.getCurrentUser().getRelation("children").add(child);
    }
    public void removeChild(Child child){
        children.remove(child);
        ParseUser.getCurrentUser().getRelation("children").remove(child);
    }



}
