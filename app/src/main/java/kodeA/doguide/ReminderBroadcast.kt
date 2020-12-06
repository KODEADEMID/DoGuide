package kodeA.doguide

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

class ReminderBroadcast : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        val builder = NotificationCompat.Builder(context, "notifyLemubit")
            .setSmallIcon(R.mipmap.ic_launcher)
            .setContentTitle("Remind Lemubit Academy")
            .setContentText("Hey students, ...")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
        val notificationManager = NotificationManagerCompat.from(context)
        notificationManager.notify(200, builder.build())
    }
}




// lateinit var notificationManager: NotificationManager
// lateinit var notificationChannel : NotificationChannel
// lateinit var builder: Notification.Builder
// private val channelId = "kodeA.doguide"
// private val description = "Test Notification"


/* val intent = Intent(this, ReminderBroadcast::class.java)
 val pendingIntent = PendingIntent.getBroadcast(this, 0, intent, 0)
 val alarmManager = getSystemService(ALARM_SERVICE) as AlarmManager
 val timeAtButtonClick = System.currentTimeMillis()

 val calendar = Calendar.getInstance()
 calendar.timeInMillis = System.currentTimeMillis()
 calendar.add(Calendar.SECOND, 10)
 val time = calendar.timeInMillis

 manager.setRepeating(
     AlarmManager.RTC_WAKEUP, time,
     AlarmManager.INTERVAL_HOUR, pendingIntent
 )
*/
//createNotificationChannel()
//val button = findViewById<Button>(R.id.btn_view)

/* button.setOnClickListener { v: View? ->
     Toast.makeText(this, "Reminder Set!", Toast.LENGTH_SHORT).show()
     val intent = Intent(this, ReminderBroadcast::class.java)
     val pendingIntent = PendingIntent.getBroadcast(this, 0, intent, 0)
     val alarmManager = getSystemService(ALARM_SERVICE) as AlarmManager
     val timeAtButtonClick = System.currentTimeMillis()
     var tenSecondsInMillis = (1000 * 10).toLong()
     alarmManager[AlarmManager.RTC_WAKEUP, timeAtButtonClick + tenSecondsInMillis] =
         pendingIntent
    /* if(){
         var count_2 = Integer.parseInt(result_health.text.toString()) - 25
         result_health.text = count_2.toString()
         val editor2 = getSharedPreferences("kodeA.doguide", MODE_PRIVATE).edit()
         editor2.putString("Health", result_health.text.toString())
         editor2.commit()

     }*/
 }*/



/*val timer = object: CountDownTimer(20000, 1000) {
     override fun onTick(millisUntilFinished: Long) {

        // text_view.setText("seconds remaining: " + millisUntilFinished / 1000)
     }
     override fun onFinish() {
         var count_3 = Integer.parseInt(result_mood.text.toString()) - 25
         result_mood.text=count_3.toString()
         val editor = getSharedPreferences("kodeA.doguide", MODE_PRIVATE).edit()
         editor.putString("Enjoy", result_mood.text.toString())
         editor.commit()

         //text_view.text=""

     }
 }*/
// findViewById<Button>(R.id.btn_enjoy).setOnClickListener {

//           timer.start()
//    }


//notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
/*
                    val intent = Intent(this, Simulator::class.java)
                    val pendingIntent = PendingIntent.getActivity(
                        this,
                        0,
                        intent,
                        PendingIntent.FLAG_UPDATE_CURRENT


                   /* val contView = RemoteViews(packageName, R.layout.notification_layout)
                    contView.setTextViewText(R.id.tv_title, "Code Android")
                    contView.setTextViewText(R.id.tv_content, "Text notification")*/

                    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                        notificationChannel =
                            NotificationChannel(
                                channelId,
                                description,
                                NotificationManager.IMPORTANCE_HIGH
                            )
                        notificationChannel.enableLights(true)
                        notificationChannel.lightColor=Color.GREEN
                        notificationChannel.enableVibration(false)
                        notificationManager.createNotificationChannel(notificationChannel)

                        builder = Notification.Builder(this, channelId).setContent(contView).setSmallIcon(
                            R.drawable.ic_launcher_round
                        ).setLargeIcon(
                            BitmapFactory.decodeResource(this.resources, R.drawable.ic_launcher)
                        ).setContentIntent(pendingIntent)
                    }else{
                        builder = Notification.Builder(this).setContent(contView).setSmallIcon(R.drawable.ic_launcher_round).setLargeIcon(
                            BitmapFactory.decodeResource(this.resources, R.drawable.ic_launcher)
                        ).setContentIntent(pendingIntent)
                    }
                    notificationManager.notify(1234, builder.build())

                }*/





/* if (!toggle.isChecked()) {

     findViewById<Button>(R.id.btn_enjoy).setOnClickListener {
         if (Integer.parseInt(result_mood.text.toString()) >= 100) {
             Toast.makeText(this, "Питомец сытый", Toast.LENGTH_SHORT).show()
         } else {
             var count = Integer.parseInt(result_mood.text.toString()) + 25
             result_mood.text = count.toString()
             val editor = getSharedPreferences("kodeA.doguide", MODE_PRIVATE).edit()
             editor.putString("Enjoy", result_mood.text.toString())
             editor.commit()
             //var healthNow = result_health.text.toString()


         }
     }

 }*/

