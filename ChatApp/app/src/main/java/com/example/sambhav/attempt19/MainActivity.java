package com.example.sambhav.attempt19;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.database.FirebaseListAdapter;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private static int SIGN_IN_REQ_CODE = 1;
    private TextView messageText;
    private TextView messageUser;
    private TextView messageTime;
    private EditText input;
    RelativeLayout activity_main;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        activity_main = findViewById(R.id.activity_main);

        FloatingActionButton fab = findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input = findViewById(R.id.input);
                FirebaseDatabase.getInstance().getReference().push().setValue(new ChatMessage(input.getText().toString(),
                        Objects.requireNonNull(FirebaseAuth.getInstance().getCurrentUser()).getEmail()));

                input.setText("");
            }
        });

        if (FirebaseAuth.getInstance().getCurrentUser() == null)
            startActivityForResult(AuthUI.getInstance().createSignInIntentBuilder().build(), SIGN_IN_REQ_CODE);
        else {
            Toast.makeText(getApplicationContext(), "Welcome" + Objects.requireNonNull(FirebaseAuth.getInstance().getCurrentUser()).getEmail(), Toast.LENGTH_SHORT).show();
        }

        displayChatMessage();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menu_sign_out) {
            FirebaseAuth.getInstance().signOut();
            AuthUI.getInstance().signOut(this).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    Toast.makeText(getApplicationContext(), " YOU HAVE SIGNED OUT", Toast.LENGTH_SHORT).show();
                    finish();

                }
            });
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == SIGN_IN_REQ_CODE) {
            if (resultCode == RESULT_OK) {
                Toast.makeText(getApplicationContext(), "SIGN IN SUCCESSFUL", Toast.LENGTH_SHORT).show();
                displayChatMessage();
            } else {
                Toast.makeText(getApplicationContext(), "SIGN IN FAILED TRY AGAIN", Toast.LENGTH_SHORT).show();
                finish();

            }
        }
    }

    private void displayChatMessage() {
        ListView listofMessage;
        listofMessage = findViewById(R.id.listofmessage);
        FirebaseListAdapter<ChatMessage> adapter = new FirebaseListAdapter<ChatMessage>(this, ChatMessage.class, R.layout.recy_item, FirebaseDatabase.getInstance().getReference()) {
            @Override
            protected void populateView(View v, ChatMessage model, int position) {
                //Getting Reference to view of Recy_item.xm

                messageText = v.findViewById(R.id.message_text);
                messageUser = v.findViewById(R.id.message_user);
                messageTime = v.findViewById(R.id.message_time);
                messageText.setText(model.getMessageText());
                messageUser.setText(model.getMessageUser());
                messageTime.setText(DateFormat.format("dd-MM-yyyy(HH:mm:ss)", model.getMessageTime()));
            }
        };
        listofMessage.setAdapter(adapter);
    }
}
