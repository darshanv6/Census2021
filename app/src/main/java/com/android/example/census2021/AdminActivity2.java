package com.android.example.census2021;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AdminActivity2 extends AppCompatActivity {

    private Button Register;
    private Button Signout;
    private Button Access;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin2);

        Register = (Button)findViewById(R.id.register);
        Signout = (Button)findViewById(R.id.signout);
        Access = (Button)findViewById(R.id.database);

        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(AdminActivity2.this,RegisterActivity.class);
                startActivity(i);
            }
        });

        Signout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(AdminActivity2.this,AdminActivity.class);
                startActivity(i);
            }
        });

        Access.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(AdminActivity2.this,ViewDatabase.class);
                startActivity(i);
            }
        });


    }
}
