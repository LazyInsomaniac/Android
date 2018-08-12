package com.example.sambhav.firebasechat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Task>taskArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_row);

        Button btn=findViewById(R.id.
        );

        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        final DatabaseReference rootref   = firebaseDatabase.getReference();
        final DatabaseReference childref  =  firebaseDatabase.getReference();

        final EditText etmess = findViewById(R.id.et);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String message = etmess.getText().toString();
                Task task = new Task(System.currentTimeMillis(),message);
                childref.push().setValue(task);

            }
            });

    }
}
