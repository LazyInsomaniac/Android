package com.abc.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Student> studentArrayList = new ArrayList<>();

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        studentArrayList.add(new Student("Harshit", "Android", "123", "Delhi"));
        studentArrayList.add(new Student("Naman", "Android", "456", "New Delhi"));
        studentArrayList.add(new Student("Ashutosh", "Web", "789", "Dwarka"));
        studentArrayList.add(new Student("Shlok", "Web", "101112", "Pitampura"));
        studentArrayList.add(new Student("Omisha", "C++", "131415", "Dwarka"));
        studentArrayList.add(new Student("Harshit", "Android", "123", "Delhi"));
        studentArrayList.add(new Student("Naman", "Android", "456", "New Delhi"));
        studentArrayList.add(new Student("Ashutosh", "Web", "789", "Dwarka"));
        studentArrayList.add(new Student("Shlok", "Web", "101112", "Pitampura"));
        studentArrayList.add(new Student("Omisha", "C++", "131415", "Dwarka"));

        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        MyStudentAdapter myStudentAdapter = new MyStudentAdapter()
        recyclerView.setAdapter(MyStudentAdapter);



    }
}
