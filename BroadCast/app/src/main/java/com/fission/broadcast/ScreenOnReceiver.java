package com.fission.broadcast;

import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.util.Log;
import android.widget.Toast;

public class ScreenOnReceiver extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {

        System.out.println("Received");
        Toast.makeText(context,"Received",Toast.LENGTH_LONG).show();
        Log.d("Created","Received the Message");
        int mId=1;
        NotificationManager mNotificationManager = (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
        NotificationCompat.Builder mBuilder = (NotificationCompat.Builder)new NotificationCompat.Builder(context)
                        .setSmallIcon(R.drawable.eight)
                        .setContentTitle("My notification")
                        .setContentText("Hello");

        mNotificationManager.notify(mId,mBuilder.build());
        mNotificationManager.cancel(0);
    }
}
