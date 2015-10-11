package com.lab.inmotion.learny.Model;

import com.parse.ParseClassName;
import com.parse.ParseObject;

import java.util.Date;

/**
 * Created by InMotionLab on 10/10/2015.
 */
@ParseClassName("Child")
public class Child extends ParseObject {

    private String firstName;
    private String lastName;
    private Date birth;

    public String getLastName() {
        return lastName;
    }

    public Date getBirth() {
        return birth;
    }

    public String getFirstName() {
        return firstName;
    }
}

