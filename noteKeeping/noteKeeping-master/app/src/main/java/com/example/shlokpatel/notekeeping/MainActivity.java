package com.example.shlokpatel.notekeeping;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    ArrayList<field> arrayList=new ArrayList<>();
    EditText editText;
    Button button;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    MyAdapter myAdapter;
    String text;
    String currentDateTimeString;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recyclerview);
        myAdapter=new MyAdapter(arrayList,this);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setLayoutManager(layoutManager);
        editText=findViewById(R.id.edittext);
        button=findViewById(R.id.btn);
        recyclerView.setAdapter(myAdapter);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text=editText.getText().toString();
                currentDateTimeString = DateFormat.getDateTimeInstance().format(new Date()).toString();
                if(text.matches("")){
                    Toast.makeText(getBaseContext(),"Renter Some Meaningful Text",Toast.LENGTH_SHORT).show();
                    return;
                }
                arrayList.add(new field(text,currentDateTimeString,0));
                editText.setText("");

                myAdapter.notifyDataSetChanged();
            }
        });


    }
}
