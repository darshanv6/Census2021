package com.android.example.census2021;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class RegisterActivity extends AppCompatActivity {

    private EditText Enumemail;
    private EditText EnumPassword;
    private EditText Name;
    private EditText Education;
    private EditText Phone;
    private EditText Address;
    private EditText EnumID;

    private FirebaseAuth firebaseAuth;
    private DatabaseReference database;

    private Button Register;

    RadioGroup mradio_sex;
    RadioButton SexButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        database = FirebaseDatabase.getInstance().getReference().child("ENUMERATORS");
        firebaseAuth = FirebaseAuth.getInstance();

        Enumemail = (EditText)findViewById(R.id.enumemail);
        EnumPassword = (EditText)findViewById(R.id.enumpassword);
        Name  = (EditText)findViewById(R.id.name);
        Education = (EditText)findViewById(R.id.education);
        Phone = (EditText)findViewById(R.id.phone);
        Address = (EditText)findViewById(R.id.address);
        EnumID = (EditText)findViewById(R.id.enumid);
        mradio_sex = findViewById(R.id.radio_sex);

        Register = (Button)findViewById(R.id.btnregister);


        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = Name.getText().toString().trim();
                String education = Education.getText().toString().trim();
                String phone = Phone.getText().toString().trim();
                String address = Address.getText().toString().trim();
                final String enumid = EnumID.getText().toString().trim();
                String enumemail = Enumemail.getText().toString().trim();
                String enumpassword = EnumPassword.getText().toString().trim();
                String sex = SexButton.getText().toString().trim();

                final HashMap<String, String> datamap = new HashMap<>();
                datamap.put("Name",name);
                datamap.put("Qualification",education);
                datamap.put("Phone",phone);
                datamap.put("Address",address);
                datamap.put("Sex",sex);
                datamap.put("Enum ID",enumid);
                datamap.put("Email",enumemail);
                datamap.put("Password",enumpassword);


                (firebaseAuth.createUserWithEmailAndPassword(Enumemail.getText().toString(),EnumPassword.getText().toString()))
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful()){
                                    database.child(enumid).setValue(datamap);
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

    public void sexButton(View view){
        int radiosex = mradio_sex.getCheckedRadioButtonId();
        SexButton = findViewById(radiosex);
    }
}
