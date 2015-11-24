package com.lab.inmotion.learny.Activities;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RelativeLayout;

import com.lab.inmotion.learny.Application.App;
import com.lab.inmotion.learny.Model.Category;
import com.lab.inmotion.learny.Model.Child;
import com.lab.inmotion.learny.R;

public class FeedBackActivity extends AppCompatActivity {

    private int[] backgroundsOne = {R.mipmap.retrouno_xhdpi,R.mipmap.retrodos_xhdpi,R.mipmap.retrotres_xhdpi,R.mipmap.retrocuatro_xhdpi,R.mipmap.retrocinco};
    private int[] backgroundsTwo = {R.mipmap.dosretrouno_xhdpi,R.mipmap.dosretrodos,R.mipmap.dosretrotres,R.mipmap.dosretrocuatro,R.mipmap.dosretrocinco};
    private int[] backgroundsThree = {R.mipmap.tresretrouno,R.mipmap.tresretrodos,R.mipmap.tresretotres,R.mipmap.tresretrocuatro,R.mipmap.tresretrocinco};
    private int[] backgroundsFour = {R.mipmap.cuatroretrouno,R.mipmap.cuatroretrodos,R.mipmap.cuatroretrotres,R.mipmap.cuatroretrocuatro,R.mipmap.cuatroretocinco};
    private int[] backgroundsFive = {R.mipmap.cincoretrouno,R.mipmap.cincoretrodos,R.mipmap.cincoretrotres,R.mipmap.cincoretrocuatro,R.mipmap.cincoretrocinco};
    private int[] backgroundsSix = {R.mipmap.seisretrouno,R.mipmap.seisretrodos,R.mipmap.seisretrotres,R.mipmap.seisretrocuatro,R.mipmap.seisretrocinco};

    private RelativeLayout relativeLayout;
    private int globalCount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed_back);
        relativeLayout = (RelativeLayout) findViewById(R.id.relafeedback);

        Bundle bundle = getIntent().getExtras();
        String level = bundle.getString("category");
        int count = bundle.getInt("count");
        globalCount = count;
        System.out.println(count + " count que llega al feedback");
        if(level.equals("incompleteFigure"))
            relativeLayout.setBackgroundResource(backgroundsOne[count]);
        if(level.equals("vidaCotidiana"))
            relativeLayout.setBackgroundResource(backgroundsTwo[count]);
        if(level.equals("organizalos"))
            relativeLayout.setBackgroundResource(backgroundsThree[count]);
        if(level.equals("construyelos"))
            relativeLayout.setBackgroundResource(backgroundsFour[count]);
        if(level.equals("descifraClave"))
            relativeLayout.setBackgroundResource(backgroundsFive[count]);
        if(level.equals("laberintos"))
            relativeLayout.setBackgroundResource(backgroundsSix[count]);
    }

    public void tap(View view){
        App app = (App) getApplication();
        System.out.println(globalCount + " global que debe ser persistente");
        if(globalCount<4){
            if(app.getModel().getCurrent().getNombre().equals("incompleteFigure")) {
                Intent theIntent = new Intent(this, FigureActivity.class);
                int next = globalCount + 1;
                System.out.println(next + " este es el next");
                theIntent.putExtra("count", next);
                startActivity(theIntent);
                finish();
            }
            if(app.getModel().getCurrent().getNombre().equals("vidaCotidiana")) {
                Intent theIntent = new Intent(this, SequenceActivity.class);
                int next = globalCount + 1;
                System.out.println(next + " este es el next");
                theIntent.putExtra("count", next);
                startActivity(theIntent);
                finish();
            }
            if(app.getModel().getCurrent().getNombre().equals("organizalos")) {
                Intent theIntent = new Intent(this, CubeActivity.class);
                int next = globalCount + 1;
                System.out.println(next + " este es el next");
                theIntent.putExtra("count", next);
                startActivity(theIntent);
                finish();
            }
            if(app.getModel().getCurrent().getNombre().equals("construyelos")) {
                Intent theIntent = new Intent(this, ObjectActivity.class);
                int next = globalCount + 1;
                System.out.println(next + " este es el next");
                theIntent.putExtra("count", next);
                startActivity(theIntent);
                finish();
            }
            if(app.getModel().getCurrent().getNombre().equals("descifraClave")) {
                Intent theIntent = new Intent(this, KeyActivity.class);
                int next = globalCount + 1;
                System.out.println(next + " este es el next");
                theIntent.putExtra("count", next);
                startActivity(theIntent);
                finish();
            }
            if(app.getModel().getCurrent().getNombre().equals("laberintos")) {
                Intent theIntent = new Intent(this, ArduinoActivity.class);
                int next = globalCount + 1;
                System.out.println(next + " este es el next");
                theIntent.putExtra("count", next);
                startActivity(theIntent);
                finish();
            }
        }else{
            app.getModel().getCurrent().measureTotalTime();
            app.getModel().getCurrent().setCompleted(true);
            System.out.println("Tiempo total categoria: " + app.getModel().getCurrent().getTiempo());
            Category category = app.getModel().getCurrent();
            System.out.println("----categoria actual:" + category.getNombre());
            System.out.println("---- especialista: " + app.getModel().getEspecialista().getUsername());
            System.out.println("---current child: " + app.getModel().getEspecialista().getCurrenChild().getFirstName());
            System.out.println("----Puntaje de categoria actual: " + category.getPuntaje());
            System.out.println("----Tiempo de categoria actual: " + category.getTiempo());
            System.out.println("---id del current category: " + category.getId());
            app.getModel().getEspecialista().getCurrenChild().registerScore(category.getPuntaje(), category.getId());
            app.getModel().getEspecialista().getCurrenChild().registerTime(category.getTiempo(), category.getId());
            if(app.getModel().getCurrent().getId()<4){
                app.getModel().nextCategory();
            }else{
                Child currentchild = app.getModel().getEspecialista().getCurrenChild();
                final double[] times = app.getModel().getEspecialista().getCurrenChild().getTiempos();
                System.out.println("los tiempos size: " + times[0] + " " + times[1] + " " + times[2]);
                final double[] scores = app.getModel().getEspecialista().getCurrenChild().getPuntajes();
                System.out.println("los tiempos size: " + scores[0] + " " + scores[1] + " " + scores[2]);
                app.registerScoreInDB(currentchild.getFirstName(),currentchild.getLastName(),scores);
                app.registerTimesInDB(currentchild.getFirstName(),currentchild.getLastName(),times);
            }
            Intent theIntent = new Intent(this,CategoryActivity.class);
            startActivity(theIntent);
            finish();
        }
    }

}
