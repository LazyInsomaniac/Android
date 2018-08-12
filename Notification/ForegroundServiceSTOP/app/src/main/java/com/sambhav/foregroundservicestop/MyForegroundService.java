package com.sambhav.foregroundservicestop;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.widget.Button;

/**
 * Created by harshitdwivedi on 21/07/18.
 */

public class MyForegroundService extends Service {


    @Override
    public void onCreate() {
        super.onCreate();
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (intent.hasExtra("STOP"))
        {
            stopSelf();    // Stopping if the Stop flag is true
        }
        Intent startService = new Intent(this,MyForegroundService.class);           //for stop

        startService.putExtra("STOP",true);
        PendingIntent pi = PendingIntent.getService(this, 12345,startService,PendingIntent.FLAG_ONE_SHOT);//for stop

        final Notification notification = new NotificationCompat.Builder(this, MainActivity.CHANNEL_ID)//for stop

                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("Hi I'm a notification")
                .setContentText("Welcome to Coding Blocks!")
                .addAction(R.mipmap.ic_launcher,"Stop",pi)//pi for stop title to give button title
                .build();

        startForeground(1234, notification);// promoting to foreground service
         return START_REDELIVER_INTENT;

    }


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
