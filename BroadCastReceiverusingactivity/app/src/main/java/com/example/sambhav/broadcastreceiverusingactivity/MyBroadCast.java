package com.example.sambhav.broadcastreceiverusingactivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyBroadCast extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
         Toast.makeText(context,"Power Connected",Toast.LENGTH_SHORT).show();

         Intent i = new Intent(context,MainActivity.class);

         i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);// if starting activity from and non-activity context
                                                   // Then set this flag

        switch (intent.getAction())
        {
            case Intent.ACTION_POWER_CONNECTED:

                i.putExtra("Key","Connected");
                break;

            case Intent.ACTION_POWER_DISCONNECTED:

                    i.putExtra("Key","DisConnected");

                    break;
        }
        context.startActivity(i);
    }
}
