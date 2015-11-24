package com.lab.inmotion.learny.Activities;

import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.lab.inmotion.learny.Application.App;
import com.lab.inmotion.learny.Model.Learny;
import com.lab.inmotion.learny.R;

public class CubeActivity extends AppCompatActivity {

    private int[] imgResourceIds = {R.mipmap.pquno,R.mipmap.pqdos,R.mipmap.pqtres,
            R.mipmap.pqcuatro,R.mipmap.pqcinco,R.mipmap.pqseis};

    private int[] fontResourceIds = {R.mipmap.figurauno,R.mipmap.figurados,R.mipmap.figuratres,
            R.mipmap.figuracuatro,R.mipmap.figuracinco};

    private int[] resourceIds = {R.mipmap.pqdos,R.mipmap.pqdos,R.mipmap.pquno, R.mipmap.pquno,
            R.mipmap.pquno,R.mipmap.pqdos,R.mipmap.pqdos,R.mipmap.pquno,
            R.mipmap.pqdos,R.mipmap.pqtres,R.mipmap.pqdos,R.mipmap.pqseis,
            R.mipmap.pqcinco,R.mipmap.pqseis,R.mipmap.pquno,R.mipmap.pquno,
            R.mipmap.pqseis,R.mipmap.pqcinco,R.mipmap.pqtres,R.mipmap.pqcuatro,
    };

    private ImageView imgCubeOne;
    private ImageView imgCubeTwo;
    private ImageView imgCubeThree;
    private ImageView imgCubeFour;
    private ImageView imgMuestra;

    public LinearLayout linearOne;
    public LinearLayout linearTwo;
    public LinearLayout linearThree;
    public LinearLayout linearFour;

    private Learny model;

    public void checkAnswer(int count){
        ImageView img1 = (ImageView) linearOne.getChildAt(0);
        ImageView img2 = (ImageView) linearTwo.getChildAt(0);
        ImageView img3 = (ImageView) linearThree.getChildAt(0);
        ImageView img4 = (ImageView) linearFour.getChildAt(0);
        if(img1 != null && img2 != null && img3 != null && img4 != null) {
            if (img1.getBackground().getConstantState() == getResources().getDrawable(resourceIds[count*4]).getConstantState()) {
                if (img2.getBackground().getConstantState() == getResources().getDrawable(resourceIds[count*4+1]).getConstantState())
                    if (img3.getBackground().getConstantState() == getResources().getDrawable(resourceIds[count*4+2]).getConstantState())
                        if (img4.getBackground().getConstantState() == getResources().getDrawable(resourceIds[count*4+3]).getConstantState()){
                            Toast.makeText(this, "Figura correcta!", Toast.LENGTH_LONG).show();
                            App app = (App) getApplication();
                            app.getModel().performCorrectPlay();
                        }
            }
        }
    }
    public void btnContinueCube(View view){
        long finalTime = SystemClock.elapsedRealtime();
        double dFinalTime = (double) finalTime;
        System.out.println("finalTime long: " + finalTime + " finalTime double: " + dFinalTime);
        model.getCurrent().getCurrentTest().setFinalTime(dFinalTime);
        model.getCurrent().getCurrentTest().measureTime();
        Intent intent = new Intent(this,FeedBackActivity.class);
        intent.putExtra("category","organizalos");
        intent.putExtra("count", model.getCurrent().getCurrentTest().getId());
        startActivity(intent);
        finish();
        int actual = model.getCurrent().getCurrentTest().getId();
        if(actual<4) {
            System.out.println("puntaje acumulado: " + model.getCurrent().getPuntaje());
            checkAnswer(actual);
            model.nextTest();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cube);
        imgMuestra = (ImageView) findViewById(R.id.img_figureCube);
        imgCubeOne = (ImageView) findViewById(R.id.cubeOne);
        imgCubeTwo = (ImageView) findViewById(R.id.cubeTwo);
        imgCubeThree = (ImageView) findViewById(R.id.cubeThree);
        imgCubeFour = (ImageView) findViewById(R.id.cubeFour);
        findViewById(R.id.cubeOne).setOnTouchListener(new imgTouchListener());
        findViewById(R.id.cubeTwo).setOnTouchListener(new imgTouchListener());
        findViewById(R.id.cubeThree).setOnTouchListener(new imgTouchListener());
        findViewById(R.id.cubeFour).setOnTouchListener(new imgTouchListener());
        findViewById(R.id.right_img).setOnDragListener(new ContainerDragListener());
        findViewById(R.id.right_imgDos).setOnDragListener(new ContainerDragListener());
        findViewById(R.id.right_imgTres).setOnDragListener(new ContainerDragListener());
        findViewById(R.id.right_imgCuatro).setOnDragListener(new ContainerDragListener());
        findViewById(R.id.left_img).setOnDragListener(new ContainerDragListener());
        linearOne = (LinearLayout) findViewById(R.id.right_img);
        linearTwo = (LinearLayout) findViewById(R.id.right_imgDos);
        linearThree = (LinearLayout) findViewById(R.id.right_imgTres);
        linearFour = (LinearLayout) findViewById(R.id.right_imgCuatro);
        App app = (App) getApplication();
        model = app.getModel();
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
   protected void onResume() {
        super.onResume();
        long startTime = SystemClock.elapsedRealtime();
        double dStartTime = (double) startTime;
        model.getCurrent().getCurrentTest().setInitialTime(dStartTime);
        int thecount = model.getCurrent().getCurrentTest().getId();

        if(thecount>0) {
            switch (thecount){
                case 1:
                    imgMuestra.setBackgroundResource(fontResourceIds[1]);
                    break;
                case 2:
                    imgMuestra.setBackgroundResource(fontResourceIds[2]);

                    imgCubeOne.setBackgroundResource(imgResourceIds[2]);
                    imgCubeTwo.setBackgroundResource(imgResourceIds[5]);
                    imgCubeThree.setBackgroundResource(imgResourceIds[1]);
                    imgCubeFour.setBackgroundResource(imgResourceIds[1]);
                    break;
                case 3:
                    imgMuestra.setBackgroundResource(fontResourceIds[3]);

                    imgCubeOne.setBackgroundResource(imgResourceIds[0]);
                    imgCubeTwo.setBackgroundResource(imgResourceIds[4]);
                    imgCubeFour.setBackgroundResource(imgResourceIds[0]);
                    imgCubeThree.setBackgroundResource(imgResourceIds[5]);
                    break;
                case 4:
                    imgMuestra.setBackgroundResource(fontResourceIds[4]);

                    imgCubeOne.setBackgroundResource(imgResourceIds[3]);
                    imgCubeTwo.setBackgroundResource(imgResourceIds[4]);
                    imgCubeFour.setBackgroundResource(imgResourceIds[2]);
                    imgCubeThree.setBackgroundResource(imgResourceIds[5]);
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
