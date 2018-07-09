package com.abc.listviewaction;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> slist = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        slist.add("sambhav");
        slist.add("sambhav");
        slist.add("sambhav");
        slist.add("sambhav");
        slist.add("sambhav");
        slist.add("sambhav");
        slist.add("sambhav");
        slist.add("sambhav");
        slist.add("sambhav");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,
                R.layout.list_view,
                R.id.sname,
                slist );

        final ListView slist = findViewById(R.id.list);

        slist.setAdapter(arrayAdapter);

        slist.setOnItemClickListener(new AdapterView.OnItemClickListener() //detecting clicks
        {

            @Override

            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)   // to detect click in listview use onitemclicklistener

            {
                Log.e("TAG" ,"onItemClick: " +i);
                String list = MainActivity.this.slist.get(i);
                Toast.makeText(getBaseContext(),list,Toast.LENGTH_SHORT).show();  //toast disp



            }
        });


    }
}
