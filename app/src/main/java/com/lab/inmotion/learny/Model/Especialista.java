package com.lab.inmotion.learny.Model;

import com.parse.Parse;
import com.parse.ParseClassName;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseRelation;
import com.parse.ParseUser;
import com.parse.SaveCallback;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by InMotionLab on 10/10/2015.
 */
@ParseClassName("User")
public class Especialista extends ParseUser{

    private String id;
    private String username;
    private String password;
    private ArrayList<Child> children;

    public Especialista (){
        children = new ArrayList<Child>();
    }

    public void addChild(Child child){
        final Child thechild = child;
        children.add(child);


    }
    public void addChildWithoutDB(Child child){
        System.out.println("entro al without DB: ");
        children.add(child);
        System.out.println("salio al without DB: ");
    }
    public void removeChild(Child child){
        children.remove(child);
        ParseUser.getCurrentUser().getRelation("children").remove(child);
    }
    public ArrayList<Child> getChilldren(){
        return children;
    }
    public void setChildToCurrent(String firstName, String lastName){
        boolean finish = false;
        System.out.println("entra al metodo setchild to current");
        for(int i=0;i<children.size() && !finish;i++){
            if(children.get(i).getFirstName().equals(firstName) && children.get(i).getLastName().equals(lastName)){
                System.out.println("entra al setChildToCurrent");
                children.get(i).setCurrent(true);
                finish = true;
            }
        }

    }
    public Child getCurrenChild(){
        boolean found = false;
        for(int i=0;i<children.size() && !found;i++){
            if(children.get(i).isCurrent()){
                return children.get(i);
            }
        }
        return null;
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
