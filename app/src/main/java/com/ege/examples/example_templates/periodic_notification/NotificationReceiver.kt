package com.ege.examples.example_templates.periodic_notification

import android.Manifest
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.ege.examples.R

class NotificationReceiver : BroadcastReceiver() {

    private val CHANNEL_ID = "1"

    override fun onReceive(context: Context?, p1: Intent?) {

        if(context != null) {
            val builder = NotificationCompat.Builder(context, CHANNEL_ID)

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){

                val channel = NotificationChannel(CHANNEL_ID, "1", NotificationManager.IMPORTANCE_HIGH)
                val manager : NotificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

                manager.createNotificationChannel(channel)

                builder.setSmallIcon(R.drawable.small_icon)
                    .setContentTitle("Title")
                    .setContentText("Notification Text")
            }

            else{

                builder.setSmallIcon(R.drawable.small_icon)
                    .setContentTitle("Notification Title")
                    .setContentText("This is the notification text")
                    .setPriority(NotificationCompat.PRIORITY_DEFAULT)

            }

            val notificationManagerCompat = NotificationManagerCompat.from(context)


            if (ActivityCompat.checkSelfPermission(context, Manifest.permission.POST_NOTIFICATIONS) == PackageManager.PERMISSION_GRANTED)
                notificationManagerCompat.notify(1, builder.build())
        }



    }

}