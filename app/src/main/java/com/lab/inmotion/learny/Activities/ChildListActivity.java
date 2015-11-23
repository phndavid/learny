package com.lab.inmotion.learny.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.lab.inmotion.learny.Adapters.ChildListAdapter;
import com.lab.inmotion.learny.Application.App;
import com.lab.inmotion.learny.R;

public class ChildListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_childlist);
        App app = (App) getApplication();
        ChildListAdapter childListAdapter = new ChildListAdapter(this,app.getModel().getEspecialista().getChilldren());
        ListView listView = (ListView) findViewById(R.id.child_list);
        listView.setAdapter(childListAdapter);


    }

}
