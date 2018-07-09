package com.example.sambhav.broadcastreceiverdynamic;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class DynamicBroadCast extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        Log.e("TAG", "onReceive: was Called" );
        Toast.makeText(context,"onReceive was Called",Toast.LENGTH_SHORT).show();
    }
}
