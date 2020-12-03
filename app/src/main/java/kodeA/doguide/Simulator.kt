package kodeA.doguide
import android.app.*
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import android.widget.ToggleButton
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_simulator.*
import java.text.SimpleDateFormat
import java.util.*


//import java.util.*


class Simulator : AppCompatActivity() {


    private val timeNow = SimpleDateFormat("HH:mm:ss")
    private val dateNow = SimpleDateFormat("dd")




    // lateinit var notificationManager: NotificationManager
    // lateinit var notificationChannel : NotificationChannel
    // lateinit var builder: Notification.Builder
    // private val channelId = "kodeA.doguide"
    // private val description = "Test Notification"




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simulator)


        val toggle: ToggleButton = findViewById(R.id.btn_tgl)

        val sharedPrefs = getSharedPreferences("kodeA.doguide", MODE_PRIVATE)
        toggle.isChecked = sharedPrefs.getBoolean("NameOfThingToSave", true)

        result_health.text = sharedPrefs.getString("Health", result_health.text.toString())
        result_mood.text = sharedPrefs.getString("Enjoy", result_mood.text.toString())
        result_want_to_walk.text = sharedPrefs.getString(
            "Walk",
            result_want_to_walk.text.toString()
        )
        result_disease.text = sharedPrefs.getString("Disease", result_disease.text.toString())

        findViewById<Button>(R.id.btn_tgl).setOnClickListener {
            if (toggle.isChecked() == true) {
                val editor = getSharedPreferences("kodeA.doguide", MODE_PRIVATE).edit()
                editor.putBoolean("NameOfThingToSave", true)
                editor.commit()
               val refreshActivity = intent
               finish()
               startActivity(refreshActivity)
            } else {
                val editor = getSharedPreferences("kodeA.doguide", MODE_PRIVATE).edit()
                editor.putBoolean("NameOfThingToSave", false)
                editor.commit()

                val refreshActivity = intent
                finish()
                startActivity(refreshActivity)
                /* val intent = Intent(this, Simulator::class.java)
                startActivity(intent)*/

            }

        }


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
        createNotificationChannel()
        val button = findViewById<Button>(R.id.btn_view)

        button.setOnClickListener { v: View? ->
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
        }




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

        // val timer = object: CountDownTimer(20000, 1000) {
        //     override fun onTick(millisUntilFinished: Long) {
        //         text_view.setText("seconds remaining: " + millisUntilFinished / 1000);

        //     }

        //     override fun onFinish() {
        //         var count_3 = Integer.parseInt(result_mood.text.toString()) - 25
        //         result_mood.text=count_3.toString()
        //         val editor = getSharedPreferences("kodeA.doguide", MODE_PRIVATE).edit()
        //         editor.putString("Enjoy", result_mood.text.toString())
        //         editor.commit()
        //         text_view.text=""

        //     }
        // }
        // timer.start()


        if (!toggle.isChecked()) { //

            //
            if (timeNow.format(Date()) == "10:45:00" || timeNow.format(Date()) == "15:00:00" || timeNow.format(
                    Date()
                ) == "22:00:00"
            ) {


                var count_2 = Integer.parseInt(result_want_to_walk.text.toString()) - 25
                result_want_to_walk.text = count_2.toString()


                val editor2 = getSharedPreferences("kodeA.doguide", MODE_PRIVATE).edit()
                editor2.putString("Walk", result_want_to_walk.text.toString())
                editor2.commit()

            }


            //ВЫЧИТАНИЕ
            if (timeNow.format(Date()) == "13:00:00" && (dateNow.format(Date()) == "06" || dateNow.format(
                    Date()
                ) == "11" || dateNow.format(Date()) == "16" || dateNow.format(Date()) == "21" || dateNow.format(
                    Date()
                ) == "26" || dateNow.format(Date()) == "01")
            ) {
                var count_1 = Integer.parseInt(result_disease.text.toString()) - 25
                result_disease.text = count_1.toString()

                val editor = getSharedPreferences("kodeA.doguide", MODE_PRIVATE).edit()
                editor.putString("Disease", result_disease.text.toString())
                editor.commit()
            }

            //СЫТОСТЬ

            findViewById<Button>(R.id.btn_feed).setOnClickListener {
                if (Integer.parseInt(result_health.text.toString()) >= 100) {
                    Toast.makeText(this, "Питомец сытый", Toast.LENGTH_SHORT).show()
                } else {
                    var count = Integer.parseInt(result_health.text.toString()) + 25
                    result_health.text = count.toString()
                    val editor = getSharedPreferences("kodeA.doguide", MODE_PRIVATE).edit()
                    editor.putString("Health", result_health.text.toString())
                    editor.commit()
                }
            }

            //БОЛЕЗНЬ

            findViewById<Button>(R.id.btn_doctor).setOnClickListener {
                if (Integer.parseInt(result_disease.text.toString()) >= 100) {
                    Toast.makeText(this, "Максимальный иммунитет", Toast.LENGTH_SHORT).show()
                } else {
                    var count = Integer.parseInt(result_disease.text.toString()) + 25
                    result_disease.text = count.toString()
                    val editor = getSharedPreferences("kodeA.doguide", MODE_PRIVATE).edit()
                    editor.putString("Disease", result_disease.text.toString())
                    editor.commit()
                }
            }

            //ПРОГУЛКА

            findViewById<Button>(R.id.btn_walk).setOnClickListener {
                if (Integer.parseInt(result_want_to_walk.text.toString()) >= 100) {
                    Toast.makeText(this, "Гулять не хочет", Toast.LENGTH_SHORT).show()
                } else {
                    var count = Integer.parseInt(result_want_to_walk.text.toString()) + 25
                    result_want_to_walk.text = count.toString()
                    val editor = getSharedPreferences("kodeA.doguide", MODE_PRIVATE).edit()
                    editor.putString("Walk", result_want_to_walk.text.toString())
                    editor.commit()
                    //var healthNow = result_health.text.toString()
                }
            }

            //НАСТРОЕНИЕ

            findViewById<Button>(R.id.btn_enjoy).setOnClickListener {


                if (Integer.parseInt(result_mood.text.toString()) >= 100) {
                    Toast.makeText(this, "Настроение есть!", Toast.LENGTH_SHORT).show()
                } else {

                    var count = Integer.parseInt(result_mood.text.toString()) + 25
                    result_mood.text = count.toString()

                    val editor = getSharedPreferences("kodeA.doguide", MODE_PRIVATE).edit()
                    editor.putString("Enjoy", result_mood.text.toString())
                    editor.commit()

                    //var healthNow = result_health.text.toString()
                }

            }


            //СМЕРТЬ

            if (Integer.parseInt(result_health.text.toString()) == 0 || Integer.parseInt(result_mood.text.toString()) == 0 ||
                Integer.parseInt(result_disease.text.toString()) == 0 || Integer.parseInt(
                    result_want_to_walk.text.toString()
                ) == 0
            ) {
                val editor = getSharedPreferences("kodeA.doguide", MODE_PRIVATE).edit()
                editor.putBoolean("NameOfThingToSave", false)
                editor.commit()

            }
        }

        fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
            super.onSaveInstanceState(outState, outPersistentState)


        }

        fun onRestoreInstanceState(savedInstanceState: Bundle) {

            super.onRestoreInstanceState(savedInstanceState)
        }


    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name: CharSequence = "LemubitReminderChannel"
            val description = "Channel for Lemubit Reminder"
            val importance: Int =NotificationManager.IMPORTANCE_DEFAULT

            var channel = NotificationChannel("notifyLemubit", name, importance)
            channel.setDescription(description)
            val notificationManager = getSystemService(NotificationManager::class.java)
            notificationManager.createNotificationChannel(channel)
        }
    }
}









