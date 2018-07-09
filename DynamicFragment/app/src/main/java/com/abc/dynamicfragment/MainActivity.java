package com.abc.dynamicfragment;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn= findViewById(R.id.addfrag);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //    FragmentA = new FragmentA(); creating/calling fragment

                getSupportFragmentManager().beginTransaction() // Fragment Manager
                        .add(R.id.llayout,new FragmentA())
                        .replace(R.id.llayout,new FragmentA())
                        .commit();


            }
        });

    }
}
