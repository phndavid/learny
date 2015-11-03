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

    public Category(String nombre, int cantidadTests){
        this.nombre = nombre;
        this.tests = new Test[cantidadTests];
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
}
