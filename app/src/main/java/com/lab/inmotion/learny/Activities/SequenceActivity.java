package com.lab.inmotion.learny.Activities;

import android.content.ClipData;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.lab.inmotion.learny.R;

public class SequenceActivity extends AppCompatActivity {

    private int[] imgResourceIds = {R.mipmap.plantauno,R.mipmap.plantados,R.mipmap.plantatres,R.mipmap.mediauno,R.mipmap.mediados,R.mipmap.mediatres,
            R.mipmap.vacauno,R.mipmap.vacados,R.mipmap.vacatres,R.mipmap.paletauno,R.mipmap.plantados,R.mipmap.plantatres,
            R.mipmap.banouno,R.mipmap.banotres};
    private int[] fontResourceIds = {R.mipmap.fondouno,R.mipmap.fondodos,R.mipmap.fondotres,R.mipmap.fondocuatro,R.mipmap.fondocinco};

    private ImageView imgOne;
    private ImageView imgTwo;
    private ImageView imgThree;
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


    }
    public void btnContinue(View view){
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

        String msg = "IMG1 X:"+x1+" Y:"+y1+" - IMG2 X:"+x2+" Y:"+y2+" - IMG3 X:"+x3+" Y:"+y3;
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
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

}
