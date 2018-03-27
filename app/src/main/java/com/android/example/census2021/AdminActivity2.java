package com.android.example.census2021;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class AdminActivity2 extends AppCompatActivity {

    private ImageView Register,Enumerator,Database,Logout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin2);

        Register = (ImageView)findViewById(R.id.register);
        Enumerator = (ImageView)findViewById(R.id.enumerator);
        Database = (ImageView)findViewById(R.id.database);
        Logout = (ImageView)findViewById(R.id.logout);



        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(AdminActivity2.this,RegisterActivity.class);
                startActivity(i);
            }
        });

        Enumerator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(AdminActivity2.this,Enuminfo.class);
                startActivity(i);
            }
        });

        Logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(AdminActivity2.this,AdminActivity.class);
                startActivity(i);
                finish();
            }
        });

        Database.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(AdminActivity2.this,ViewDatabase.class);
                startActivity(i);
            }
        });


    }
}
