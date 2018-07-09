package com.abc.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
ArrayList<String> studentlist = new ArrayList<>();  //Arraylist declared of type string
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        studentlist.add("sambhav");
        studentlist.add("sambhav");
        studentlist.add("sambhav");
        studentlist.add("sambhav");
        studentlist.add("sambhav");
        studentlist.add("sambhav");
        studentlist.add("sambhav");
        studentlist.add("sambhav");
        studentlist.add("sambhav");
        studentlist.add("sambhav");
        studentlist.add("sambhav");
        studentlist.add("sambhav");   //DATA source

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,
                R.layout.list_item,
                R.id.sname,
                studentlist);
        ListView studentlist = findViewById(R.id.studentlis);
    studentlist.setAdapter(arrayAdapter);   // joining listview and adapter
    }
}
