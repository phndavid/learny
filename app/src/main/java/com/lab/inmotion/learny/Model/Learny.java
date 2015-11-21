package com.lab.inmotion.learny.Model;

/**
 * Created by InMotionLab on 20/10/2015.
 */
public class Learny {

    public static final int CATEGORIES = 6;
    public static final String CATE1 = "incompleteFigure";
    public static final String CATE2 = "vidaCotidiana";
    public static final String CATE3 = "organizalos";
    public static final String CATE4 = "construyelos";
    public static final String CATE5 = "descifraClave";

    private Especialista especialista;
    private Category[] categories;
    private Category current;

    public Learny(String username, String password){
        especialista = new Especialista();
        especialista.setUsername(username);
        especialista.setPassword(password);
        categories = new Category[CATEGORIES];
        inicializeCategories();
        current = categories[0];
    }
    public Category getCurrent(){
        return current;
    }
    public void setCurren(Category current){
        this.current = current;
    }
    public void inicializeCategories(){

        categories[0] = new Category();
        categories[0].setNombre(CATE1);
        categories[0].setId(0);

        categories[1] = new Category();
        categories[1].setNombre(CATE2);
        categories[1].setId(1);

        categories[2] = new Category();
        categories[2].setNombre(CATE3);
        categories[2].setId(2);

        categories[3] = new Category();
        categories[3].setNombre(CATE4);
        categories[3].setId(3);

        categories[4] = new Category();
        categories[4].setNombre(CATE5);
        categories[4].setId(4);
    }
    public void nextTest(){
        int currentId = current.getCurrentTest().getId();
        int newCurrentId = currentId+1;
        current.setCurrentTest(current.getTests()[newCurrentId]);
    }
    public void nextCategory(){

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
