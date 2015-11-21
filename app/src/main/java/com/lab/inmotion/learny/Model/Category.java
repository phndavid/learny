package com.lab.inmotion.learny.Model;

import com.parse.ParseClassName;
import com.parse.ParseObject;

/**
 * Created by InMotionLab on 11/10/2015.
 */
@ParseClassName("Category")
public class Category extends ParseObject{


    private String nombre;
    private double puntaje;
    private double tiempo;
    private Test[] tests;
    private Test currentTest;
    private int id;

    public Category(){
        this.tests = new Test[5];
        inicializeTests();
        currentTest = tests[0];
    }
    public void inicializeTests(){
        tests[0] = new Test();
        tests[0].setId(0);

        tests[1] = new Test();
        tests[1].setId(1);

        tests[2] = new Test();
        tests[2].setId(2);

        tests[3] = new Test();
        tests[3].setId(3);

        tests[4] = new Test();
        tests[4].setId(4);
    }
    public void editTest(int index, Test theTest){
        tests[index] = theTest;
    }
    public Test getCurrentTest(){
        return currentTest;
    }
    public void performCorrectPlay(){
        double theScore = currentTest.getScore();
        double newScore = theScore+1;
        currentTest.setScore(newScore);
        puntaje++;
    }
    public void setCurrentTest(Test currentTest){
        this.currentTest = currentTest;
    }
    public String getName(){
        return getString("name");
    }
    public Number getScore(){
        return getNumber("score");
    }
    public Number getTime(){
        return getNumber("time");
    }
    public String getNombre(){
        return nombre;
    }
    public double getPuntaje(){
        return puntaje;
    }
    public double getTiempo(){
        return tiempo;
    }
    public Test[] getTests(){
        return tests;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public void setPuntaje(double puntaje){
        this.puntaje = puntaje;
    }
    public void setTiempo (double tiempo){
        this.tiempo = tiempo;
    }
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
}
