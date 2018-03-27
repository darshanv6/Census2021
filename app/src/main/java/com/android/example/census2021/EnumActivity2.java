package com.android.example.census2021;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class EnumActivity2 extends AppCompatActivity {

    private Button Entry,Map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enum2);

        Entry = (Button)findViewById(R.id.button);

        Entry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(EnumActivity2.this,CensusActivity.class);
                startActivity(i);
                finish();
            }
        });

        Map = (Button) findViewById(R.id.map_button);

        Map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(EnumActivity2.this,MapsActivity.class);
                startActivity(i);
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(EnumActivity2.this,HelpActivity.class);
                startActivity(i);
            }
        });


    }
}
