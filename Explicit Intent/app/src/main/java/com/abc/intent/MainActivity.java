package com.abc.intent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import static java.lang.System.exit;

public class MainActivity extends AppCompatActivity {
    EditText ettext;
    Button   Button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView tvresult =findViewById(R.id.tvresult);
       ettext=(EditText)findViewById(R.id.ettext);
       Button=(Button)findViewById(R.id.Button);


       Button.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view)
           {
              String Name=ettext.getText().toString();
               Intent i = new Intent(  MainActivity.this,Secondactivity.class);
               Toast.makeText(getBaseContext(), "Saved Successfully",Toast.LENGTH_SHORT).show();
               i.putExtra("KEY",Name);   //send intent
               i.putExtra("KEY2",5);
               startActivity(i);
               finish();                   //terminating app
               //OR
               exit(0);            // terminating app
           }
       });

        ettext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {

            }


        });


    }
}
