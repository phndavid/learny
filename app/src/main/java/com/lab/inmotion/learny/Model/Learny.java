package com.lab.inmotion.learny.Model;

/**
 * Created by InMotionLab on 20/10/2015.
 */
public class Learny {

    public static final int CATEGORIES = 6;

    private Especialista especialista;
    private Category[] categories;

    public Learny(String username, String password){
        especialista = new Especialista(username, password);
        categories = new Category[CATEGORIES];

    }

    public Especialista getEspecialista(){
        return especialista;
    }
    public Category[] getCategories(){
        return categories;
    }
    public void setEspecialista(Especialista especialista){
        this.especialista = especialista;
    }
    public Category findCategory(String nombre){
        Category category = null;
        for(int i=0;i<categories.length;i++){
            Category theCategory = categories[i];
            if(theCategory.getNombre().equals(nombre)){
                category = theCategory;
            }
        }
        return category;
    }
}
