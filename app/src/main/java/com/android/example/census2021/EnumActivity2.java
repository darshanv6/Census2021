package com.android.example.census2021;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class EnumActivity2 extends AppCompatActivity {

    private Button Entry;

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
            }
        });

    }
}
