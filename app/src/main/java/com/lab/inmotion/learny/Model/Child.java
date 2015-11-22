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
    private String parentName;
    private String address;
    private String school;
    private String educationLevel;
    private String testPlace;
    private Date testDate;

    private double [] puntajes;
    private double [] tiempos;

    public Child(){
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

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public void setEducationLevel(String educationLevel) {
        this.educationLevel = educationLevel;
    }

    public void setTestPlace(String testPlace) {
        this.testPlace = testPlace;
    }

    public void setTestDate(Date testDate) {
        this.testDate = testDate;
    }

    public String getAddress() {
        return address;
    }

    public String getSchool() {
        return school;
    }

    public String getEducationLevel() {
        return educationLevel;
    }

    public String getTestPlace() {
        return testPlace;
    }

    public Date getTestDate() {
        return testDate;
    }
}

