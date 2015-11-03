package com.lab.inmotion.learny.Model;

import com.parse.ParseClassName;
import com.parse.ParseObject;

import java.util.Date;

/**
 * Created by InMotionLab on 10/10/2015.
 */
@ParseClassName("Child")
public class Child extends ParseObject {

    public static final int CATEGORIAS = 5;

    private String firstName;
    private String lastName;
    private Date birth;
    private double [] puntajes;
    private double [] tiempos;

    public Child(String firstName, String lastName, Date birth){
        this.firstName = firstName;
        this.lastName = lastName;
        this.birth = birth;
        this.puntajes = new double[CATEGORIAS];
        this.tiempos = new double[CATEGORIAS];

    }

    public String getLastName() {
        return lastName;
    }

    public Date getBirth() {
        return birth;
    }

    public String getFirstName() {
        return firstName;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    public void setBirth(Date birth){
        this.birth = birth;
    }
}

