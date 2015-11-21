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
public class Especialista extends ParseUser{

    private String id;
    private String username;
    private String password;
    private List<Child> children;

    public Especialista (){
        children = new ArrayList<Child>();
    }

    public void addChild(Child child){
        children.add(child);
        ParseUser.getCurrentUser().getRelation("children").add(child);
    }
    public void removeChild(Child child){
        children.remove(child);
        ParseUser.getCurrentUser().getRelation("children").remove(child);
    }
    public List<Child> getChilldren(){
        return children;
    }
    public String getUsername(){
        return username;
    }
    public String getPassword(){
        return password;
    }
    public void setUsername(String username){
        this.username = username;
    }
    public void setPassword (String password){
        this.password = password;
    }
}
