package com.example.sambhav.pokeapi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText editText=findViewById(R.id.editText);
        recyclerView = findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));



        Button button=findViewById(R.id.btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String find=editText.getText().toString();
                String url="https://pokeapi.co/api/v2/pokemon/"+find;
                final OkHttpClient client=new OkHttpClient();
                final Request request=new Request.Builder()
                        .url(url)
                        .build();
                client.newCall(request).enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        final String jsonBody=response.body().string();
                        Log.e("TAG","onresponse: "+jsonBody);
                        Gson gson=new Gson();
                        Result result=gson.fromJson(jsonBody,Result.class);
                        Log.e("TAG", "onResponse: "+result );

                        final ArrayList<item> arrayList=result.getItems();
                        Log.e("TAG", "onResponse: arraylist="+arrayList );
                        MainActivity.this.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                MyAdapter myAdapter=new MyAdapter(arrayList,getBaseContext());
                                recyclerView.setAdapter(myAdapter);

                            }
                        });
                    }
                });
            }
        });
    }
}
