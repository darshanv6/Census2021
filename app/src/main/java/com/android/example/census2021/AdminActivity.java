package com.android.example.census2021;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AdminActivity extends AppCompatActivity {

    private EditText Name;
    private EditText Password;
    private Button Login;
    private int counter = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        Name = (EditText)findViewById(R.id.etName);
        Password = (EditText)findViewById(R.id.etPassword);
        Login = (Button)findViewById(R.id.btnLogin);

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(Name.getText().toString(),Password.getText().toString());
            }
        });

    }

    private void validate(String userName, String userPassword){
        if( (userName.equals("Admin")) && userPassword.equals("1234") ){
            Intent intent = new Intent(AdminActivity.this, AdminActivity2.class);
            startActivity(intent);
        }
        else{
            counter--;
            if(counter == 0){
                Login.setEnabled(false);
            }
        }
    }

}
