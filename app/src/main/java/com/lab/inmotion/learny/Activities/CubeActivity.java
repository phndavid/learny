package com.lab.inmotion.learny.Activities;

import android.content.ClipData;
import android.content.ClipDescription;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.lab.inmotion.learny.Application.App;
import com.lab.inmotion.learny.Model.Learny;
import com.lab.inmotion.learny.R;

public class CubeActivity extends AppCompatActivity {

    private int[] imgResourceIds = {R.mipmap.figurauno,R.mipmap.figurados,R.mipmap.figuratres,
                                    R.mipmap.figuracuatro,R.mipmap.figuracinco
                                    ,R.mipmap.pquno,R.mipmap.pqdos,R.mipmap.pqtres,
                                    R.mipmap.pqcuatro,R.mipmap.pqcinco,R.mipmap.pqseis};

    private ImageView imgOne;
    private ImageView imgTwo;
    private ImageView imgThree;
    private ImageView imgFouer;
    private ImageView imgMuestra;

    private int count;
    private Learny model;

    public void init(){
        setContentView(R.layout.activity_cube);

        imgMuestra = (ImageView) findViewById(R.id.figuraMuestra);
        imgOne = (ImageView) findViewById(R.id.cubeOne);
        imgTwo = (ImageView) findViewById(R.id.cubeTwo);
        imgThree = (ImageView) findViewById(R.id.cubeThree);
        imgFouer = (ImageView) findViewById(R.id.cubeFour);

        findViewById(R.id.cubeOne).setOnTouchListener(new imgTouchListener());
        findViewById(R.id.cubeTwo).setOnTouchListener(new imgTouchListener());
        findViewById(R.id.cubeThree).setOnTouchListener(new imgTouchListener());
        findViewById(R.id.cubeFour).setOnTouchListener(new imgTouchListener());
        findViewById(R.id.right_img).setOnDragListener(new ContainerDragListener());
        findViewById(R.id.right_imgCuatro).setOnDragListener(new ContainerDragListener());
        findViewById(R.id.right_imgDos).setOnDragListener(new ContainerDragListener());
        findViewById(R.id.right_imgTres).setOnDragListener(new ContainerDragListener());
        findViewById(R.id.left_img).setOnDragListener(new ContainerDragListener());}

    public void btnContinueCube(View view){
        Intent intent = new Intent(this,FeedBackActivity.class);
        intent.putExtra("category","organizalos");
        intent.putExtra("count", model.getCurrent().getCurrentTest().getId());
        startActivity(intent);
        count++;
        getPositionCount();
        int actual = model.getCurrent().getCurrentTest().getId();
        if(actual<4) {
            System.out.println("puntaje acumulado: " + model.getCurrent().getPuntaje());
            model.nextTest();
        }

    }
    public  void getPositionCount(){
        int[] locations1 = new int[2];
        imgOne.getLocationOnScreen(locations1);
        int x1 = locations1[0];
        int y1 = locations1[1];
        int[] locations2 = new int[2];
        imgTwo.getLocationOnScreen(locations2);
        int x2 = locations2[0];
        int y2 = locations2[1];
        int[] locations3 = new int[2];
        imgThree.getLocationOnScreen(locations3);
        int x3 = locations3[0];
        int y3 = locations3[1];
        int[] locations4 = new int[2];
        imgFouer.getLocationOnScreen(locations4);
        int x4 = locations4[0];
        int y4 = locations4[1];

        String msg = "IMG1 X:"+x1+" Y:"+y1+" - IMG2 X:"+x2+" Y:"+y2+" - IMG3 X:"+x3+" Y:"+y3+" - IMG4 X:"+x4+" Y:"+y4;
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
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
    protected void onResume() {
        super.onResume();
        System.out.println("OnResume Counter Sequence: " + count);
        int thecount = model.getCurrent().getCurrentTest().getId();
        if(thecount>0) {
            switch (thecount){
                case 1:
                    imgMuestra.setBackgroundResource(imgResourceIds[1]);
                    break;
                case 2:
                    imgMuestra.setBackgroundResource(imgResourceIds[2]);
                    imgOne.setBackgroundResource(imgResourceIds[6]);
                    imgTwo.setBackgroundResource(imgResourceIds[7]);
                    imgThree.setBackgroundResource(imgResourceIds[11]);
                    imgFouer.setBackgroundResource(imgResourceIds[6]);
                    break;
                case 3:
                    imgMuestra.setBackgroundResource(imgResourceIds[3]);
                    imgOne.setBackgroundResource(imgResourceIds[9]);
                    imgTwo.setBackgroundResource(imgResourceIds[10]);
                    imgFouer.setBackgroundResource(imgResourceIds[6]);
                    imgThree.setBackgroundResource(imgResourceIds[8]);
                    break;
                case 4:
                    imgMuestra.setBackgroundResource(imgResourceIds[4]);
                    imgOne.setBackgroundResource(imgResourceIds[6]);
                    imgTwo.setBackgroundResource(imgResourceIds[7]);
                    imgFouer.setBackgroundResource(imgResourceIds[6]);
                    imgThree.setBackgroundResource(imgResourceIds[8]);
                    break;
                case 5:

                    break;
            }
        }
    }

    protected void onRestart() {
        super.onRestart();
        System.out.println("se ejecuta el onrestart");

    }
}
