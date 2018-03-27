package com.android.example.census2021;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class EnumActivity extends AppCompatActivity {

    private EditText Username;
    private EditText Password;
    private Button Login;
    private FirebaseAuth firebaseAuth;
    private String s = "@gmail.com";
    private int counter = 5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enum);

        Username = (EditText)findViewById(R.id.name);
        Password = (EditText)findViewById(R.id.password);
        Login = (Button)findViewById(R.id.btnlogin);
        firebaseAuth = FirebaseAuth.getInstance();

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                (firebaseAuth.signInWithEmailAndPassword(Username.getText().toString().concat(s),Password.getText().toString()))
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful()){
                                    Toast.makeText(EnumActivity.this,"Login Successful",Toast.LENGTH_SHORT).show();
                                    Intent i = new Intent(EnumActivity.this,EnumActivity2.class);
                                    startActivity(i);
                                }else{
                                    counter--;
                                    if(counter == 0){
                                        Login.setEnabled(false);
                                    }
                                    Log.e("ERROR",task.getException().getMessage());
                                    Toast.makeText(EnumActivity.this,task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });

    }
}
