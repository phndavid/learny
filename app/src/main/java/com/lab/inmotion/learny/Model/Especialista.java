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
        final Child thechild = child;
        children.add(child);
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
                    System.out.println("currentUsername: " + username);
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
