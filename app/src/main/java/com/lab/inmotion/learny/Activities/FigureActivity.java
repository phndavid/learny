package com.lab.inmotion.learny.Activities;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.lab.inmotion.learny.R;

public class FigureActivity extends AppCompatActivity {

    private int[] imgResourceIds = {R.mipmap.carro_xhdpi, R.mipmap.gato_xhdpi,R.mipmap.reloj_xhdpi,R.mipmap.espejo,R.mipmap.mesa_xhdpi};
    private int[] fontResourceIds = {R.mipmap.nivelunoamarillo_xhdpi, R.mipmap.nivelunoazul_xhdpi,R.mipmap.nivelunorosa_xhdpi,R.mipmap.nivelunoverde_xhdpi,R.mipmap.nivelunovioleta_xhdpi};
    private  int count;
    private RelativeLayout relativeLayout;
    private ImageView imgFigure;
    private EditText textWord;
    private String word;
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

    public void btn_next(View view){
        count++;
        switch (count){
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
                Intent theIntent = new Intent(this,CategoryActivity.class);
                startActivity(theIntent);
                finish();
                break;
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_figure);
        relativeLayout = (RelativeLayout) findViewById(R.id.backgroundFigure);
        imgFigure = (ImageView) findViewById(R.id.imgFigure);
        textWord = (EditText) findViewById(R.id.textWord);
        word = "";
    }

}
