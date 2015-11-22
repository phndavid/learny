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
import com.lab.inmotion.learny.R;

public class FeedBackActivity extends AppCompatActivity {

    private int[] backgroundsOne = {R.mipmap.retrouno_xhdpi,R.mipmap.retrodos_xhdpi,R.mipmap.retrotres_xhdpi,R.mipmap.retrocuatro_xhdpi,R.mipmap.retrocinco};
    private int[] backgroundsTwo = {R.mipmap.dosretrouno_xhdpi,R.mipmap.dosretrodos,R.mipmap.dosretrotres,R.mipmap.dosretrocuatro,R.mipmap.dosretrocinco};


    private RelativeLayout relativeLayout;
    private int globalCount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed_back);
        relativeLayout = (RelativeLayout) findViewById(R.id.relafeedback);

        Bundle bundle = getIntent().getExtras();
        String levelOne = bundle.getString("category");
        String leveTwo = bundle.getString("sequence");

        int count = bundle.getInt("count");
        globalCount = count;
        System.out.println(count + " count que llega al feedback");
        if(levelOne != null)
            relativeLayout.setBackgroundResource(backgroundsOne[count]);
        else if(leveTwo != null)
            relativeLayout.setBackgroundResource(backgroundsTwo[count]);

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
            }else if(app.getModel().getCurrent().getNombre().equals("vidaCotidiana")) {
                Intent theIntent = new Intent(this, SequenceActivity.class);
                int next = globalCount + 1;
                System.out.println(next + " este es el next");
                theIntent.putExtra("count", next);
                startActivity(theIntent);
                finish();
            }
        }else{
            app.getModel().nextCategory();
            Intent theIntent = new Intent(this,CategoryActivity.class);
            startActivity(theIntent);
            finish();
        }
    }
}
