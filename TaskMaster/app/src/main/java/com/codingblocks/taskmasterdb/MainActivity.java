package com.codingblocks.taskmasterdb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TaskDatabase taskDatabase = new TaskDatabase(this);
        Button btnInsert = findViewById(R.id.btnInsert);
      final TextView textView=findViewById(R.id.tv);

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Task task = new Task("Time","is",System.currentTimeMillis(),false);
                long a =taskDatabase.insertTask(task);
                textView.setText(""+a);
            }
        });

    }
}
