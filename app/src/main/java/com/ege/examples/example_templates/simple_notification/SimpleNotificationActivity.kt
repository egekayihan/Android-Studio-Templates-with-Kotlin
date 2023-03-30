package com.ege.examples.example_templates.simple_notification

import android.Manifest
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.ege.examples.MainActivity
import com.ege.examples.R
import com.ege.examples.databinding.ActivitySimplenotificationBinding

class SimpleNotificationActivity : AppCompatActivity() {

    private val CHANNEL_ID = "1"

    lateinit var mainBinding : ActivitySimplenotificationBinding
    var counter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mainBinding = ActivitySimplenotificationBinding.inflate(layoutInflater)
        val view = mainBinding.root

        setContentView(view)

        mainBinding.buttonSendNotification!!.setOnClickListener {

            counter++
            mainBinding.buttonSendNotification!!.text = counter.toString()

            if(counter % 5 == 0)
                startNotification()


        }

    }

    fun startNotification(){

        val intent = Intent(applicationContext, MainActivity::class.java)

        //notification actions from notification bar
        val pendingIntent = if (Build.VERSION.SDK_INT >= 23)
            PendingIntent.getActivity(applicationContext, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE)

        else
            PendingIntent.getActivity(applicationContext, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT)


        //actionButton
        val actionIntent = Intent(applicationContext, Receiver::class.java)
        actionIntent.putExtra("toast", "This is a notification message")

        val actionPending = if (Build.VERSION.SDK_INT >= 23)
            PendingIntent.getBroadcast(applicationContext, 1, actionIntent, PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE)

        else
            PendingIntent.getBroadcast(applicationContext, 1, actionIntent, PendingIntent.FLAG_UPDATE_CURRENT)


        //dismissButton
        val dismissIntent = Intent(applicationContext, ReceiverDismiss::class.java)

        val dismissPending = if (Build.VERSION.SDK_INT >= 23)
            PendingIntent.getBroadcast(applicationContext, 2, dismissIntent, PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE)

        else
            PendingIntent.getBroadcast(applicationContext, 2, dismissIntent, PendingIntent.FLAG_UPDATE_CURRENT)



        //adding image to notification
        val icon : Bitmap = BitmapFactory.decodeResource(resources, R.drawable.cat)
        val text : String = resources.getString(R.string.big_text)


        val builder = NotificationCompat.Builder(this@SimpleNotificationActivity, CHANNEL_ID)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){

            val channel = NotificationChannel(CHANNEL_ID, "1", NotificationManager.IMPORTANCE_DEFAULT)
            val manager : NotificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

            manager.createNotificationChannel(channel)

            builder.setSmallIcon(R.drawable.small_icon)
                .setContentTitle("Title")
                .setContentText("Notification Text")
                .setContentIntent(pendingIntent)
                .setAutoCancel(true)
                .addAction(R.drawable.small_icon, "Toast Message", actionPending)
                .addAction(R.drawable.small_icon, "Dismiss", dismissPending)
                .setLargeIcon(icon)
            //.setStyle(NotificationCompat.BigPictureStyle().bigPicture(icon).bigLargeIcon(null))
            //.setStyle(NotificationCompat.BigTextStyle().bigText(text))
        }

        else{

            builder.setSmallIcon(R.drawable.small_icon)
                .setContentTitle("Notification Title")
                .setContentText("This is the notification text")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setContentIntent(pendingIntent)
                .setAutoCancel(true)
                .addAction(R.drawable.small_icon, "Toast Message", actionPending)
                .addAction(R.drawable.small_icon, "Dismiss", dismissPending)
                .setLargeIcon(icon)
            //.setStyle(NotificationCompat.BigPictureStyle().bigPicture(icon))
            //.setStyle(NotificationCompat.BigTextStyle().bigText(text))
        }

        val notificationManagerCompat = NotificationManagerCompat.from(this@SimpleNotificationActivity)


        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.POST_NOTIFICATIONS) == PackageManager.PERMISSION_GRANTED)
            notificationManagerCompat.notify(1, builder.build())



    }

}