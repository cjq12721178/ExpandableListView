package com.example.kat.expandablelistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        simpleExpandableListAdapter = new SimpleExpandableListAdapter(this);
        ExpandableListView expandableListView = (ExpandableListView)findViewById(R.id.elv_test);
        expandableListView.setAdapter(simpleExpandableListAdapter);
        //expandableListView.setGroupIndicator(null);
    }

    private SimpleExpandableListAdapter simpleExpandableListAdapter;
}
