package com.lab.inmotion.learny.Model;

import com.parse.ParseClassName;
import com.parse.ParseObject;

/**
 * Created by InMotionLab on 11/10/2015.
 */
@ParseClassName("Category")
public class Category extends ParseObject{

    public String getName(){
        return getString("name");
    }
    public Number getScore(){
        return getNumber("score");
    }
    public Number getTime(){
        return getNumber("time");
    }
}
