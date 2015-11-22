package com.lab.inmotion.learny.Activities;

import android.app.Application;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.lab.inmotion.learny.Application.App;
import com.lab.inmotion.learny.Model.Category;
import com.lab.inmotion.learny.Model.Learny;
import com.lab.inmotion.learny.R;

public class FigureActivity extends AppCompatActivity {


    private int[] imgResourceIds = {R.mipmap.carro_xhdpi, R.mipmap.gato_xhdpi,R.mipmap.reloj_xhdpi,R.mipmap.espejo,R.mipmap.mesa_xhdpi};
    private int[] fontResourceIds = {R.mipmap.nivelunoamarillo_xhdpi, R.mipmap.nivelunoazul_xhdpi,R.mipmap.nivelunorosa_xhdpi,R.mipmap.nivelunoverde_xhdpi,R.mipmap.nivelunovioleta_xhdpi};
    private String [][] answers = {{"rin","rrin","riin","rinn","riinn"},{"bigote","bigotes","bigute","bigutes","bigutrs"},{"cuatro","IV","cutro","catro","cuato"},{"cacho","cuerno","cueno","cerno","cuernp"},{"pata","pierna","paata","patta","pataa"}};
    private int puntaje=0;
    private boolean firstTime =false;

    private  int count;
    private RelativeLayout relativeLayout;
    private ImageView imgFigure;
    private EditText textWord;
    private String word;
    private Learny model;

    public void  btn_a(View view){
        word = word+"a";
        textWord.setText(word);
    }
    public void  btn_b(View view){
        word = word+"b";
        textWord.setText(word);
    }
    public void  btn_c(View view){
        word = word+"c";
        textWord.setText(word);
    }
    public void  btn_d(View view){
        word = word+"d";
        textWord.setText(word);
    }
    public void  btn_e(View view){
        word = word+"e";
        textWord.setText(word);
    }
    public void  btn_f(View view){
        word = word+"f";
        textWord.setText(word);
    }
    public void  btn_g(View view){
        word = word+"g";
        textWord.setText(word);
    }
    public void  btn_h(View view){
        word = word+"h";
        textWord.setText(word);
    }
    public void  btn_i(View view){
        word = word+"i";
        textWord.setText(word);
    }
    public void  btn_j(View view){
        word = word+"j";
        textWord.setText(word);
    }
    public void  btn_k(View view){
        word = word+"k";
        textWord.setText(word);
    }
    public void  btn_l(View view){
        word = word+"l";
        textWord.setText(word);
    }
    public void  btn_m(View view){
        word = word+"m";
        textWord.setText(word);
    }
    public void  btn_n(View view){
        word = word+"n";
        textWord.setText(word);
    }
    public void  btn_o(View view){
        word = word+"o";
        textWord.setText(word);
    }
    public void  btn_p(View view){
        word = word+"p";
        textWord.setText(word);
    }
    public void  btn_q(View view){
        word = word+"q";
        textWord.setText(word);
    }
    public void  btn_r(View view){
        word = word+"r";
        textWord.setText(word);
    }
    public void  btn_s(View view){
        word = word+"s";
        textWord.setText(word);
    }
    public void  btn_t(View view){
        word = word+"t";
        textWord.setText(word);
    }
    public void  btn_u(View view){
        word = word+"u";
        textWord.setText(word);
    }
    public void  btn_v(View view){
        word = word+"v";
        textWord.setText(word);
    }
    public void  btn_w(View view){
        word = word+"w";
        textWord.setText(word);
    }
    public void  btn_x(View view){
        word = word+"x";
        textWord.setText(word);
    }
    public void  btn_y(View view){
        word = word+"y";
        textWord.setText(word);
    }
    public void  btn_z(View view){
        word = word+"z";
        textWord.setText(word);
    }
    public void btn_remove(View view){
        if (word.length() > 0) {
            word = word.substring(0, word.length()-1);
        }
        textWord.setText(word);
    }

    public boolean checkAnswer(String answer,int count){
        System.out.println("la respuesta: "+answer);
        boolean correct = false;
        String [] theAnswers = answers[count];
        for(int i=0;i<theAnswers.length;i++){
            System.out.println("entra al metodo, hace el for: " + theAnswers[i]);
            if(answer.equals(theAnswers[i])){
                System.out.println("ëntro al if checkanswer");
                model.performCorrectPlay();
                correct = true;
            }
        }
        return correct;
    }
    public void btn_next(View view){
        System.out.println("initialTime en btnNext: " + model.getCurrent().getCurrentTest().getInitialTime());
        long finalTime = SystemClock.elapsedRealtime();
        double dFinalTime = (double) finalTime;
        System.out.println("finalTime long: " + finalTime + " finalTime double: " + dFinalTime);
        model.getCurrent().getCurrentTest().setFinalTime(dFinalTime);
        model.getCurrent().getCurrentTest().measureTime();
        System.out.println("finalTime en btnNext: " + model.getCurrent().getCurrentTest().getFinalTime());
        System.out.println("tiempo que se demoro, debe ser mas o menos 20 segs: " + model.getCurrent().getCurrentTest().getTime());
        Intent intent = new Intent(this,FeedBackActivity.class);
        intent.putExtra("category", "incompleteFigure");
        intent.putExtra("count", model.getCurrent().getCurrentTest().getId());
        startActivity(intent);
        count++;
        int actual = model.getCurrent().getCurrentTest().getId();
        word="";
        textWord.setText(word);
        if(actual<4) {
            checkAnswer(textWord.getText().toString().trim(), actual);
            System.out.println("puntaje acumulado: " + model.getCurrent().getPuntaje());
            model.nextTest();
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_figure);
        System.out.println("se ejecuta el oncreate");
        relativeLayout = (RelativeLayout) findViewById(R.id.backgroundFigure);
        imgFigure = (ImageView) findViewById(R.id.imgFigure);
        textWord = (EditText) findViewById(R.id.textWord);
        firstTime = true;
        App app = (App) getApplication();
        model = app.getModel();
        word = "";
    }

    @Override
    protected void onResume() {
        super.onResume();
        long startTime = SystemClock.elapsedRealtime();
        double dStartTime = (double) startTime;
        System.out.println("tiempo en long: " + startTime + " tiempo en double: " + dStartTime);
        model.getCurrent().getCurrentTest().setInitialTime(dStartTime);
        System.out.println("se ejecuta el onresume y este es el count: " + count);
        int thecount= model.getCurrent().getCurrentTest().getId();
        if(thecount>0){
            switch (thecount){
                case 1:
                    relativeLayout.setBackgroundResource(fontResourceIds[1]);
                    imgFigure.setBackgroundResource(imgResourceIds[1]);

                    break;
                case 2:
                    relativeLayout.setBackgroundResource(fontResourceIds[2]);
                    imgFigure.setBackgroundResource(imgResourceIds[2]);

                    break;
                case 3:
                    relativeLayout.setBackgroundResource(fontResourceIds[3]);
                    imgFigure.setBackgroundResource(imgResourceIds[3]);

                    break;
                case 4:
                    relativeLayout.setBackgroundResource(fontResourceIds[4]);
                    imgFigure.setBackgroundResource(imgResourceIds[4]);
                    break;
                case 5:

                    break;
            }
        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        System.out.println("se ejecuta el onrestart");

    }

    @Override
    protected void onStop() {
        super.onStop();

    }
}
