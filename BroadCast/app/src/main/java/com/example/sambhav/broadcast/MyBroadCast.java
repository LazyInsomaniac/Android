package com.example.sambhav.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyBroadCast extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        if (intent.getAction().equals(Intent.ACTION_POWER_CONNECTED))
            Toast.makeText(context,"Power connected",Toast.LENGTH_SHORT).show();
        if(intent.getAction().equals(Intent.ACTION_POWER_DISCONNECTED))
            Toast.makeText(context,"Power Disconnected",Toast.LENGTH_SHORT).show();
        context.startActivity(new Intent(context,MainActivity.class));
    }
}
