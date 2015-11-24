package com.lab.inmotion.learny.Activities;

import android.content.ClipData;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.lab.inmotion.learny.Application.App;
import com.lab.inmotion.learny.Model.Learny;
import com.lab.inmotion.learny.R;

public class SequenceActivity extends AppCompatActivity {

    private int[] imgResourceIds = {R.mipmap.plantatres,R.mipmap.plantauno,R.mipmap.plantados,R.mipmap.mediados,R.mipmap.mediatres,R.mipmap.mediauno,
            R.mipmap.vacatres,R.mipmap.vacauno,R.mipmap.vacados,R.mipmap.paletauno,R.mipmap.paletados,R.mipmap.paletatres,
            R.mipmap.banotres,R.mipmap.banodos,R.mipmap.banouno};

    private int[] resourceIds = {R.mipmap.plantauno,R.mipmap.plantados,R.mipmap.plantatres,R.mipmap.mediauno,R.mipmap.mediados,R.mipmap.mediatres,
            R.mipmap.vacauno,R.mipmap.vacados,R.mipmap.vacatres,R.mipmap.paletauno,R.mipmap.paletados,R.mipmap.paletatres,
            R.mipmap.banouno,R.mipmap.banodos,R.mipmap.banotres};

    private int[] fontResourceIds = {R.mipmap.fondouno,R.mipmap.fondodos,R.mipmap.fondotres,R.mipmap.fondocuatro,R.mipmap.fondocinco};

    private ImageView imgOne;
    private ImageView imgTwo;
    private ImageView imgThree;

    private RelativeLayout relativeLayout;
    private LinearLayout linearOne;
    private LinearLayout linearTwo;
    private LinearLayout linearThree;

    private Learny model;

    public void checkAnswer(int count){
        ImageView img1 = (ImageView) linearOne.getChildAt(0);
        ImageView img2 = (ImageView) linearTwo.getChildAt(0);
        ImageView img3 = (ImageView) linearThree.getChildAt(0);
        if(img1 != null && img2 != null && img3 != null) {
            if (img1.getBackground().getConstantState() == getResources().getDrawable(resourceIds[count * 3]).getConstantState()) {
                if (img2.getBackground().getConstantState() == getResources().getDrawable(resourceIds[count * 3 + 1]).getConstantState())
                    if (img3.getBackground().getConstantState() == getResources().getDrawable(resourceIds[count * 3 + 2]).getConstantState()) {
                        Toast.makeText(this, "Secuencia correcta!", Toast.LENGTH_LONG).show();
                        //aqui gano
                        App app = (App) getApplication();
                        app.getModel().performCorrectPlay();
                    }
            }
        }
    }
    public void btnContinue(View view){
        long finalTime = SystemClock.elapsedRealtime();
        double dFinalTime = (double) finalTime;
        System.out.println("finalTime long: " + finalTime + " finalTime double: " + dFinalTime);
        model.getCurrent().getCurrentTest().setFinalTime(dFinalTime);
        model.getCurrent().getCurrentTest().measureTime();
        Intent intent = new Intent(this,FeedBackActivity.class);
        intent.putExtra("category", "vidaCotidiana");
        intent.putExtra("count", model.getCurrent().getCurrentTest().getId());
        startActivity(intent);
        finish();
        int actual = model.getCurrent().getCurrentTest().getId();
        if(actual < 4) {
            checkAnswer(actual);
            System.out.println("puntaje acumulado: " + model.getCurrent().getPuntaje());
            model.nextTest();
        }

    }

    private class imgTouchListener implements View.OnTouchListener {
        public boolean onTouch(View view, MotionEvent motionEvent) {

    	    /*ACTION_DOWN -> A pressed gesture has started, the motion contains the initial position*/
            if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                ClipData data = ClipData.newPlainText("", "");
            /*Creates an image that the system displays during the drag and drop operation. This is called a "drag shadow".*/
                View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);
                view.startDrag(data, shadowBuilder, view, 0);
            /*while the img is moving, the view is invisible, if we comment this line, the view 'will move' when we drop it*/
                view.setVisibility(View.INVISIBLE);
                return true;
            } else {
                return false;
            }
        }
    }

    private class ContainerDragListener implements View.OnDragListener {
        //Drawable enterShape = getResources().getDrawable(R.drawable.shape_droptarget);
        //Drawable normalShape = getResources().getDrawable(R.drawable.shape);

        @Override
        public boolean onDrag(View v, DragEvent event) {
            int action = event.getAction();
            switch (event.getAction()) {
                case DragEvent.ACTION_DRAG_STARTED:
                    // do nothing
                    break;
                case DragEvent.ACTION_DRAG_ENTERED:
    	             /*change de background*/
                    // v.setBackground(enterShape);
                    break;
                case DragEvent.ACTION_DRAG_EXITED:
                    //v.setBackground(normalShape);
                    break;
                case DragEvent.ACTION_DROP:
                    // Dropped, reassign View to ViewGroup
                    View view = (View) event.getLocalState();
                    LinearLayout oldContainer = (LinearLayout) view.getParent();
                    oldContainer.removeView(view);
                    LinearLayout newContainer = (LinearLayout) v;
                    newContainer.addView(view);
                    view.setVisibility(View.VISIBLE);
                    break;
                case DragEvent.ACTION_DRAG_ENDED:
                    //v.setBackground(normalShape);
                default:
                    break;
            }
            return true;
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sequence);
        imgOne = (ImageView) findViewById(R.id.imgOne);
        imgTwo = (ImageView) findViewById(R.id.imgTwo);
        imgThree = (ImageView) findViewById(R.id.imgThree);
        findViewById(R.id.imgOne).setOnTouchListener(new imgTouchListener());
        findViewById(R.id.imgTwo).setOnTouchListener(new imgTouchListener());
        findViewById(R.id.imgThree).setOnTouchListener(new imgTouchListener());
        findViewById(R.id.linearOne).setOnDragListener(new ContainerDragListener());
        findViewById(R.id.linearTwo).setOnDragListener(new ContainerDragListener());
        findViewById(R.id.linearThree).setOnDragListener(new ContainerDragListener());
        findViewById(R.id.linearFigureOne).setOnDragListener(new ContainerDragListener());
        findViewById(R.id.linearFigureTwo).setOnDragListener(new ContainerDragListener());
        findViewById(R.id.linearFigureThree).setOnDragListener(new ContainerDragListener());
        relativeLayout = (RelativeLayout) findViewById(R.id.backgroudSequence);
        linearOne = (LinearLayout) findViewById(R.id.linearOne);
        linearTwo = (LinearLayout) findViewById(R.id.linearTwo);
        linearThree = (LinearLayout) findViewById(R.id.linearThree);
        App app = (App) getApplication();
        model = app.getModel();
    }
    @Override
     protected void onResume() {
        super.onResume();
        long startTime = SystemClock.elapsedRealtime();
        double dStartTime = (double) startTime;
        model.getCurrent().getCurrentTest().setInitialTime(dStartTime);
        int thecount= model.getCurrent().getCurrentTest().getId();
        if(thecount>0) {
            switch (thecount){
                case 1:
                    relativeLayout.setBackgroundResource(fontResourceIds[1]);
                    imgOne.setBackgroundResource(imgResourceIds[3]);
                    imgTwo.setBackgroundResource(imgResourceIds[4]);
                    imgThree.setBackgroundResource(imgResourceIds[5]);
                    break;
                case 2:
                    relativeLayout.setBackgroundResource(fontResourceIds[2]);
                    imgOne.setBackgroundResource(imgResourceIds[6]);
                    imgTwo.setBackgroundResource(imgResourceIds[7]);
                    imgThree.setBackgroundResource(imgResourceIds[8]);
                    break;
                case 3:
                    relativeLayout.setBackgroundResource(fontResourceIds[3]);
                    imgOne.setBackgroundResource(imgResourceIds[9]);
                    imgTwo.setBackgroundResource(imgResourceIds[10]);
                    imgThree.setBackgroundResource(imgResourceIds[11]);
                    break;
                case 4:
                    relativeLayout.setBackgroundResource(fontResourceIds[4]);
                    imgOne.setBackgroundResource(imgResourceIds[12]);
                    imgTwo.setBackgroundResource(imgResourceIds[13]);
                    imgThree.setBackgroundResource(imgResourceIds[14]);
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

}
