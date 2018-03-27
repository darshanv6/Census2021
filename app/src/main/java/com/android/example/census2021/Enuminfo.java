package com.android.example.census2021;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class Enuminfo extends AppCompatActivity {

    private DatabaseReference database;
    private ListView mEnumlist;
    private ListView mKeylist;
    private EditText EnumID;
    private Button Enter;
    private ArrayList<String> mEnumname = new ArrayList<>();
    private ArrayList<String> mKey = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enuminfo);

        database = FirebaseDatabase.getInstance().getReference().child("ENUMERATORS");
        mEnumlist = (ListView)findViewById(R.id.userlist);
        mKeylist = (ListView)findViewById(R.id.keys);
        EnumID = (EditText)findViewById(R.id.enumid);
        Enter = (Button)findViewById(R.id.enter);

        Enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(EnumID.getText().toString().trim().equals(""))
                {
                    Toast.makeText(Enuminfo.this,"Please enter Enum ID",Toast.LENGTH_SHORT).show();

                }
                else
                {

                final String enumid = EnumID.getText().toString().trim();

                final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Enuminfo.this,android.R.layout.simple_list_item_1,mEnumname);
                final ArrayAdapter<String> arrayAdapter1 = new ArrayAdapter<String>(Enuminfo.this,android.R.layout.simple_list_item_1,mKey);

                mEnumlist.setAdapter(arrayAdapter);
                mKeylist.setAdapter(arrayAdapter1);

                database.child(enumid).addChildEventListener(new ChildEventListener() {
                    @Override
                    public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                        String value = dataSnapshot.getValue(String.class);
                        String key = dataSnapshot.getKey();
                        Log.e(key,value);
                        mEnumname.add(value);
                        mKey.add(key);

                        arrayAdapter1.notifyDataSetChanged();
                        arrayAdapter.notifyDataSetChanged();

                    }

                    @Override
                    public void onChildChanged(DataSnapshot dataSnapshot, String s) {

                    }

                    @Override
                    public void onChildRemoved(DataSnapshot dataSnapshot) {

                    }

                    @Override
                    public void onChildMoved(DataSnapshot dataSnapshot, String s) {

                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });

                Enter.setEnabled(false);

            }
        }
        });

    }
}
