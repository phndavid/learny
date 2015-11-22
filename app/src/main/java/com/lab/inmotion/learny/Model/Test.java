package com.lab.inmotion.learny.Model;

import com.parse.ParseClassName;
import com.parse.ParseObject;

/**
 * Created by InMotionLab on 11/10/2015.
 */
@ParseClassName("Test")
public class Test extends ParseObject{

    private double score;
    private double time;
    private double initialTime;
    private double finalTime;
    private int id;

    public Test(){
        score = 0;
        time = 0;
    }
    public int getId(){
        return id;
    }
    public void measureTime(){
        time = (finalTime-initialTime)/1000;
    }
    public double getScore(){
        return score;
    }
    public double getTime(){
        return time;
    }
    public double getInitialTime(){
        return initialTime;
    }
    public double getFinalTime(){
        return finalTime;
    }
    public void setInitialTime(double initialTime){
        this.initialTime = initialTime;
    }
    public void setFinalTime(double finalTime){
        this.finalTime = finalTime;
    }
    public void setId(int id){
        this.id = id;
    }
    public void setScore(double score){
        this.score = score;
    }
    public void setTime(double time){
        this.time = time;
    }

}
