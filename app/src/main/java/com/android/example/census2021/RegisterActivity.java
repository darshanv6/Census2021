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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity {

    private EditText Username;
    private EditText Password;
    private FirebaseAuth firebaseAuth;
    private DatabaseReference database;

    private Button Register;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Username = (EditText)findViewById(R.id.username);
        Password = (EditText)findViewById(R.id.password);
        Register = (Button)findViewById(R.id.btnregister);

        database = FirebaseDatabase.getInstance().getReference();
        firebaseAuth = FirebaseAuth.getInstance();


        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                (firebaseAuth.createUserWithEmailAndPassword(Username.getText().toString(),Password.getText().toString()))
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful()){
                                    Toast.makeText(RegisterActivity.this,"Registration Succesfull",Toast.LENGTH_SHORT).show();
                                    Intent i = new Intent(RegisterActivity.this,AdminActivity2.class);
                                    startActivity(i);
                                }
                                else{
                                    Log.e("ERROR",task.getException().getMessage());
                                    Toast.makeText(RegisterActivity.this,task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });


    }
}
