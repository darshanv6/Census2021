package com.android.example.census2021;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class FirstActivity extends AppCompatActivity {

    private Button Admin;
    private Button Enumerator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        Enumerator = (Button)findViewById(R.id.EnButton);
        Admin = (Button)findViewById(R.id.AdButton);

        Enumerator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                enumcall();
            }
        });

        Admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                admcall();
            }
        });
    }

    private void enumcall()
    {
            Intent intent = new Intent(FirstActivity.this, EnumActivity.class);
            startActivity(intent);
    }


    private void admcall()
    {
        Intent intent = new Intent(FirstActivity.this, AdminActivity.class);
        startActivity(intent);
    }
}
