package com.abc.noteui;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Note>notesArrayList = new ArrayList<>();
   Button addBtn;
   EditText noteEt;
   RecyclerView rec;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addBtn= findViewById(R.id.addBtn);
        noteEt=findViewById(R.id.noteEt);

    }
}
