package com.lab.inmotion.learny.Activities;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import com.lab.inmotion.learny.Application.App;
import com.lab.inmotion.learny.Carousel.CoverFlowCarousel;
import com.lab.inmotion.learny.Model.Category;
import com.lab.inmotion.learny.R;

public class CategoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        CoverFlowCarousel carousel = (CoverFlowCarousel)findViewById(R.id.carousel);
        final MyAdapter adapter = new MyAdapter();
        carousel.setAdapter(adapter);
        carousel.setSelection(adapter.getCount()/2); //adapter.getCount()-1
        //carousel.setSlowDownCoefficient(1);
        carousel.setSpacing(0.5f);
    }

    @Override
    protected void onResume() {
        super.onResume();

    }
    public void setEnableById(){

    }

    private class MyAdapter extends BaseAdapter {
        private int[] mResourceIds = {R.mipmap.safeuno_xhdpi, R.mipmap.safedos_xhdpi, R.mipmap.safetres_xhdpi, R.mipmap.safecuatro_xhdpi,
                R.mipmap.safecinco,R.mipmap.safeseis_xhdpi};
        private int[] mResourceIdsBlack = {R.mipmap.negrouno_xhdpi,R.mipmap.negrodos_xhdpi,R.mipmap.negrotres_xhdpi,R.mipmap.negrocuatro_xhdpi,R.mipmap.negrocinco_xhdpi};
        private int[] mResourceIdsColor = {R.mipmap.coloruno_xhdpi,R.mipmap.colordos_xhdpi,R.mipmap.colortres_xhdpi,R.mipmap.colorcuatro_xhdpi,R.mipmap.colorcinco_xhdpi};

        private int mCount = mResourceIds.length;

        @Override
        public int getCount() {
            return mCount;
        }

        @Override
        public Object getItem(int position) {
            return mResourceIds[position % mResourceIds.length];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            MyFrame v;
            if (convertView == null) {
                v = new MyFrame(CategoryActivity.this);
            } else {
                v = (MyFrame)convertView;
            }

            App app = (App) getApplication();
            Category category = app.getModel().getCurrent();
            Category selectedCategory = app.getModel().getCategories()[position];
            final int theId = selectedCategory.getId();
            final int id = category.getId();
            if(position!=id){
                v.setImageResource(mResourceIds[position % mResourceIds.length]);
            }
            if(selectedCategory.isCompleted()){
                v.setImageResource(mResourceIdsBlack[position % mResourceIdsBlack.length]);
            }
            if(position==id){
                v.setImageResource(mResourceIdsColor[position % mResourceIdsColor.length]);
            }
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(position == 0 && (position==id)){
                        Intent theIntent = new Intent(v.getContext(), FigureActivity.class);
                        startActivity(theIntent);
                        finish();
                    }else if(position == 1 && (position==id)){
                        Intent theIntent = new Intent(v.getContext(), SequenceActivity.class);
                        startActivity(theIntent);
                        finish();
                    }else if(position == 2 && (position==id)){
                        Intent theIntent = new Intent(v.getContext(), CubeActivity.class);
                        startActivity(theIntent);
                        finish();
                    }else if(position == 3 && (position==id)){
                        Intent theIntent = new Intent(v.getContext(), ObjectActivity.class);
                        startActivity(theIntent);
                        finish();
                    }else if(position == 4 && (position==id)){
                        Intent theIntent = new Intent(v.getContext(), KeyActivity.class);
                        startActivity(theIntent);
                        finish();
                    }else if (position == 5 && (position==id)){
                        Intent theIntent = new Intent(v.getContext(), ArduinoActivity.class);
                        startActivity(theIntent);
                        finish();
                    }else if(position!=id){
                        Toast toast = Toast.makeText(getApplicationContext(),"Ya has completado este nivel o aun no has llegado a él!",Toast.LENGTH_LONG);
                        toast.show();
                    }
                }
            });


            return v;
        }

        public void addView(){
            mCount++;
            notifyDataSetChanged();
        }
    }

    public static class MyFrame extends FrameLayout {
        private ImageView mImageView;

        public void setImageResource(int resId){
            mImageView.setImageResource(resId);
        }

        public MyFrame(Context context) {
            super(context);

            mImageView = new ImageView(context);
            //mImageView.setScaleType(ImageView.ScaleType.FIT_XY);
            addView(mImageView);
            setSelected(false);
        }

        @Override
        public void setSelected(boolean selected) {
            super.setSelected(selected);

            if(selected) {
                mImageView.setAlpha(1.0f);
            } else {
                mImageView.setAlpha(0.5f);
            }
        }
    }

}
