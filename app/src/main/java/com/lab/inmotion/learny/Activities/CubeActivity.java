package com.lab.inmotion.learny.Activities;

import android.content.ClipData;
import android.content.ClipDescription;
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

import com.lab.inmotion.learny.R;

public class CubeActivity extends AppCompatActivity {

    private int[] imgResourceIds = {R.mipmap.plantauno,R.mipmap.plantados,R.mipmap.plantatres,R.mipmap.mediauno,R.mipmap.mediados,R.mipmap.mediatres,
            R.mipmap.vacauno,R.mipmap.vacados,R.mipmap.vacatres,R.mipmap.paletauno,R.mipmap.paletados,R.mipmap.paletatres,
            R.mipmap.banouno,R.mipmap.banodos,R.mipmap.banotres};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cube);

        findViewById(R.id.cubeOne).setOnTouchListener(new imgTouchListener());
        findViewById(R.id.cubeTwo).setOnTouchListener(new imgTouchListener());
        findViewById(R.id.cubeThree).setOnTouchListener(new imgTouchListener());
        findViewById(R.id.cubeFour).setOnTouchListener(new imgTouchListener());
        findViewById(R.id.cubeFive).setOnTouchListener(new imgTouchListener());
        findViewById(R.id.right_img).setOnDragListener(new ContainerDragListener());
        findViewById(R.id.left_img).setOnDragListener(new ContainerDragListener());
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
