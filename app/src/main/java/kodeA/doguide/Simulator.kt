package kodeA.doguide
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.BitmapFactory
import android.graphics.Color
import android.os.*
import android.view.View
import android.widget.*
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.graphics.createBitmap
import kotlinx.android.synthetic.main.activity_simulator.*
import java.security.acl.NotOwnerException
import java.util.*
import kotlin.system.exitProcess


class Simulator : AppCompatActivity()  {

    private var mCountDownTimer: CountDownTimer? = null
    private var mTimerRunning = false
    private var mTimeLeftInMillis: Long = 0
    private var mEndTime: Long = 0
    private var mTextViewCountDown: TextView? = null


    private val channelId = "Message"
    private var notificationID =1


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simulator)


        val toggle: ToggleButton = findViewById(R.id.btn_tgl)
        mTextViewCountDown = findViewById(R.id.text_text)

        val sharedPrefs = getSharedPreferences("kodeA.doguide", MODE_PRIVATE)
        toggle.isChecked = sharedPrefs.getBoolean("NameOfThingToSave", true)

        result_health.text = sharedPrefs.getString("Health", result_health.text.toString())
        result_mood.text = sharedPrefs.getString("Enjoy", result_mood.text.toString())
        result_want_to_walk.text = sharedPrefs.getString(
            "Walk",
            result_want_to_walk.text.toString()
        )
        result_disease.text = sharedPrefs.getString("Disease", result_disease.text.toString())

       result_health.text = "100"
       val editor1 = getSharedPreferences("kodeA.doguide", MODE_PRIVATE).edit()
        editor1.putString("Health", result_health.text.toString())
        editor1.commit()
        result_want_to_walk.text = "100"
        val editor2 = getSharedPreferences("kodeA.doguide", MODE_PRIVATE).edit()
        editor2.putString("Health", result_want_to_walk.text.toString())
        editor2.commit()
        result_disease.text = "100"
        val editor3 = getSharedPreferences("kodeA.doguide", MODE_PRIVATE).edit()
        editor3.putString("Health", result_disease.text.toString())
        editor3.commit()
        result_mood.text = "100"
        val editor4 = getSharedPreferences("kodeA.doguide", MODE_PRIVATE).edit()
        editor4.putString("Health", result_mood.text.toString())
        editor4.commit()

        findViewById<Button>(R.id.btn_tgl).setOnClickListener {
            if (toggle.isChecked() == true) {
                val editor = getSharedPreferences("kodeA.doguide", MODE_PRIVATE).edit()
                editor.putBoolean("NameOfThingToSave", true)
                editor.commit()
                //intentOut()
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
            }
        }


        if (!toggle.isChecked()) {

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
            findViewById<Button>(R.id.btn_walk).setOnClickListener(View.OnClickListener {
                if (Integer.parseInt(result_want_to_walk.text.toString()) >= 100) {
                    Toast.makeText(this, "Гулять не хочет", Toast.LENGTH_SHORT).show()
                } else {
                    var count = Integer.parseInt(result_want_to_walk.text.toString()) + 25
                    result_want_to_walk.text = count.toString()
                    val editor = getSharedPreferences("kodeA.doguide", MODE_PRIVATE).edit()
                    editor.putString("Walk", result_want_to_walk.text.toString())
                    editor.commit()
                }
            })

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

                }

            }


            //ТАЙМЕР ПРОГУЛКИ
            if (!mTimerRunning) {
                startTimerWalk()
            }
            //ТАЙМЕР ЕДЫ
            if (!mTimerRunning) {
                startTimerFood()
            }
            //ТАЙМЕР НАСТРОЕНИЯ
            if (!mTimerRunning) {
                startTimerMood()
            }
            //ТАЙМЕР ЛЕЧЕНИЯ
            if (!mTimerRunning) {
                startTimerDoctor()
            }
        }
        else{
            findViewById<Button>(R.id.btn_enjoy).setOnClickListener {
            Toast.makeText(this, "Чтобы начать, включите симулятор", Toast.LENGTH_LONG).show()
            }
            findViewById<Button>(R.id.btn_walk).setOnClickListener {
                Toast.makeText(this, "Чтобы начать, включите симулятор", Toast.LENGTH_LONG).show()
            }
            findViewById<Button>(R.id.btn_feed).setOnClickListener{
                Toast.makeText(this, "Чтобы начать, включите симулятор", Toast.LENGTH_LONG).show()
            }
            findViewById<Button>(R.id.btn_doctor).setOnClickListener{
                Toast.makeText(this, "Чтобы начать, включите симулятор", Toast.LENGTH_LONG).show()
            }


        }


    }

    private fun startTimerWalk() {
        if(btn_tgl.isChecked()){
            mTimeLeftInMillis=0
            mTimerRunning = true
            return
        }
        mTimeLeftInMillis= 30000
        mEndTime = System.currentTimeMillis() + mTimeLeftInMillis
        mCountDownTimer = object : CountDownTimer(mTimeLeftInMillis, 1000) {
            override fun onTick(millisUntilFinished: Long) {

                if (result_health.text == "0" || result_mood.text == "0" ||
                    result_disease.text == "0" || result_want_to_walk.text== "0"
                ) {

                    //System.exit(0)

                    val editor = getSharedPreferences("kodeA.doguide", MODE_PRIVATE).edit()
                    editor.putBoolean("NameOfThingToSave", true)
                    editor.commit()
                    text_text.text = "Питомец скончался"
                    createNotificationChannel()
                    sendNotificationDeath()
                    mTimeLeftInMillis = 0
                    // mTimerRunning = true
                    onStop()
                  //  finish()
                    val refreshActivity = intent
                    finish()
                    startActivity(refreshActivity)
                    return

                }

                if(btn_tgl.isChecked()){
                    mTimeLeftInMillis=0
                    mTimerRunning = true
                    return
                }
                mTimeLeftInMillis = millisUntilFinished
                updateCountDownText()
            }

            override fun onFinish() {
                if(btn_tgl.isChecked()){
                    mTimeLeftInMillis=0
                    mTimerRunning = true
                    return
                }
                else{
                mTimerRunning = false
                var count_2 = Integer.parseInt(result_want_to_walk.text.toString()) - 25
                result_want_to_walk.text = count_2.toString()
                val editor2 = getSharedPreferences("kodeA.doguide", MODE_PRIVATE).edit()
                editor2.putString("Walk", result_want_to_walk.text.toString())
                editor2.commit()

                if (result_health.text == "0" || result_mood.text == "0" ||
                    result_disease.text == "0" || result_want_to_walk.text== "0"
                ) {

                  // System.exit(0)
                    val editor = getSharedPreferences("kodeA.doguide", MODE_PRIVATE).edit()
                    editor.putBoolean("NameOfThingToSave", true)
                    editor.commit()
                    text_text.text = "Питомец скончался"
                    createNotificationChannel()
                    sendNotificationDeath()
                    mTimeLeftInMillis = 0
                    mTimerRunning = true
                    //mCountDownTimer?.cancel()
                    onStop()
                   // finish()
                    val refreshActivity = intent
                    finish()
                    startActivity(refreshActivity)
                    return

                } else {

                    createNotificationChannel()
                    sendNotificationWalk()
                    mTimeLeftInMillis = 30000
                    updateCountDownText()
                    startTimerWalk()
                }
            }

            }
        }.start()

    }

    private fun intentOut() {
        val randomIntent = Intent(this, NavigationMenuActivity::class.java)
        startActivity(randomIntent)
    }

    private fun startTimerFood() {
        if(btn_tgl.isChecked()){
            mTimeLeftInMillis=0
            mTimerRunning = true
            return
        }

        mTimeLeftInMillis= 20000
        mEndTime = System.currentTimeMillis() + mTimeLeftInMillis
        mCountDownTimer = object : CountDownTimer(mTimeLeftInMillis, 1000) {
            override fun onTick(millisUntilFinished: Long) {


                if (result_health.text == "0" || result_mood.text == "0" ||
                    result_disease.text == "0" || result_want_to_walk.text== "0"
                ) {

                    //System.exit(0)

                    val editor = getSharedPreferences("kodeA.doguide", MODE_PRIVATE).edit()
                    editor.putBoolean("NameOfThingToSave", true)
                    editor.commit()
                    text_text.text = "Питомец скончался"
                    createNotificationChannel()
                    sendNotificationDeath()
                    mTimeLeftInMillis = 0
                    // mTimerRunning = true
                    onStop()
                    //finish()
                    val refreshActivity = intent
                    finish()
                    startActivity(refreshActivity)
                    return

                }
                if(btn_tgl.isChecked()){
                    mTimeLeftInMillis=0
                    mTimerRunning = true
                    return
                }
                mTimeLeftInMillis = millisUntilFinished
                updateCountDownText()
            }

            override fun onFinish() {

                if(btn_tgl.isChecked()){
                    mTimeLeftInMillis=0
                    mTimerRunning = true
                    return
                }
                else {
                    mTimerRunning = false
                    var count_2 = Integer.parseInt(result_health.text.toString()) - 25
                    result_health.text = count_2.toString()
                    val editor2 = getSharedPreferences("kodeA.doguide", MODE_PRIVATE).edit()
                    editor2.putString("Health", result_health.text.toString())
                    editor2.commit()


                    if (result_health.text == "0" || result_mood.text == "0" ||
                        result_disease.text == "0" || result_want_to_walk.text== "0"
                    ) {


                        //System.exit(0)
                        val editor = getSharedPreferences("kodeA.doguide", MODE_PRIVATE).edit()
                        editor.putBoolean("NameOfThingToSave", true)
                        editor.commit()
                        text_text.text = "Питомец скончался"
                        createNotificationChannel()
                        sendNotificationDeath()
                        mTimeLeftInMillis = 0
                        mTimerRunning = true
                        //mCountDownTimer?.cancel()
                        onStop()
                      //  finish()
                       val refreshActivity = intent
                        finish()
                        startActivity(refreshActivity)
                        return

                    } else {


                        createNotificationChannel()
                        sendNotificationFood()
                        mTimeLeftInMillis = 20000
                        updateCountDownText()
                        startTimerFood()
                    }

                }
            }

        }.start()


    }

    private fun startTimerDoctor() {
        if(btn_tgl.isChecked()){
            mTimeLeftInMillis=0
            mTimerRunning = true
            return
        }
        mTimeLeftInMillis= 50000
        mEndTime = System.currentTimeMillis() + mTimeLeftInMillis
        mCountDownTimer = object : CountDownTimer(mTimeLeftInMillis, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                if(btn_tgl.isChecked()){
                    mTimeLeftInMillis=0
                    mTimerRunning = true
                    return
                }
                mTimeLeftInMillis = millisUntilFinished
                updateCountDownText()
            }

            override fun onFinish() {
                if(btn_tgl.isChecked()) {

                    if (result_health.text == "0" || result_mood.text == "0" ||
                        result_disease.text == "0" || result_want_to_walk.text== "0"
                    ) {

                        //System.exit(0)

                        val editor = getSharedPreferences("kodeA.doguide", MODE_PRIVATE).edit()
                        editor.putBoolean("NameOfThingToSave", true)
                        editor.commit()
                        text_text.text = "Питомец скончался"
                        createNotificationChannel()
                        sendNotificationDeath()
                        mTimeLeftInMillis = 0
                        // mTimerRunning = true
                        onStop()
                        //finish()
                        val refreshActivity = intent
                        finish()
                        startActivity(refreshActivity)
                        return

                    }
                    mTimeLeftInMillis = 0
                    mTimerRunning = true
                    return
                }
                else
                {
                mTimerRunning = false
                var count = Integer.parseInt(result_disease.text.toString()) - 25
                result_disease.text = count.toString()
                val editor = getSharedPreferences("kodeA.doguide", MODE_PRIVATE).edit()
                editor.putString("Disease", result_disease.text.toString())
                editor.commit()



                if (
                    result_health.text == "0" || result_mood.text == "0" ||
                    result_disease.text == "0" || result_want_to_walk.text== "0"
                ) {

                    //System.exit(0)
                    val editor = getSharedPreferences("kodeA.doguide", MODE_PRIVATE).edit()
                    editor.putBoolean("NameOfThingToSave", true)
                    editor.commit()
                    text_text.text = "Питомец скончался"
                    createNotificationChannel()
                    sendNotificationDeath()
                    mTimeLeftInMillis = 0
                    mTimerRunning = true
                    //mCountDownTimer?.cancel()
                    onStop()
                   // finish()
                 val refreshActivity = intent
                    finish()
                    startActivity(refreshActivity)
                    return

                }
                else
                {
                    createNotificationChannel()
                    sendNotificationDoctor()
                    mTimeLeftInMillis = 50000
                    updateCountDownText()
                    startTimerDoctor()
                }
            }

            }
        }.start()

    }

    private fun startTimerMood() {

        if(btn_tgl.isChecked()){
            mTimeLeftInMillis=0
            mTimerRunning = true
            return
        }
        mTimeLeftInMillis= 40000
        mEndTime = System.currentTimeMillis() + mTimeLeftInMillis
        mCountDownTimer = object : CountDownTimer(mTimeLeftInMillis, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                if(btn_tgl.isChecked()){
                    if (result_health.text == "0" || result_mood.text == "0" ||
                        result_disease.text == "0" || result_want_to_walk.text== "0"
                    ) {

                        //System.exit(0)

                        val editor = getSharedPreferences("kodeA.doguide", MODE_PRIVATE).edit()
                        editor.putBoolean("NameOfThingToSave", true)
                        editor.commit()
                        text_text.text = "Питомец скончался"
                        createNotificationChannel()
                        sendNotificationDeath()
                        mTimeLeftInMillis = 0
                        // mTimerRunning = true
                        onStop()
                        //finish()
                        val refreshActivity = intent
                        finish()
                        startActivity(refreshActivity)
                        return

                    }
                    mTimeLeftInMillis=0
                    mTimerRunning = true
                    return
                }
                mTimeLeftInMillis = millisUntilFinished
                updateCountDownText()

            }

            override fun onFinish() {

                if(btn_tgl.isChecked()){
                    mTimeLeftInMillis=0
                    mTimerRunning = true
                    return
                }else {
                    mTimerRunning = false
                    var count = Integer.parseInt(result_mood.text.toString()) - 25
                    result_mood.text = count.toString()
                    val editor = getSharedPreferences("kodeA.doguide", MODE_PRIVATE).edit()
                    editor.putString("Enjoy", result_mood.text.toString())
                    editor.commit()
                    if (result_health.text == "0" || result_mood.text == "0" ||
                        result_disease.text == "0" || result_want_to_walk.text== "0"
                    ) {

                        //System.exit(0)

                        val editor = getSharedPreferences("kodeA.doguide", MODE_PRIVATE).edit()
                        editor.putBoolean("NameOfThingToSave", true)
                        editor.commit()
                        text_text.text = "Питомец скончался"
                        createNotificationChannel()
                        sendNotificationDeath()
                        mTimeLeftInMillis = 0
                       // mTimerRunning = true
                        onStop()
                       // finish()
                        val refreshActivity = intent
                        finish()
                        startActivity(refreshActivity)
                        return

                    } else {
                        createNotificationChannel()
                        sendNotificationMood()
                        mTimeLeftInMillis = 40000
                        updateCountDownText()
                        startTimerMood()
                    }
                }

            }
        }.start()

    }

 override fun onStop() {
        super.onStop()
        /*val prefs: SharedPreferences = getSharedPreferences("prefs", Context.MODE_PRIVATE)
        val editor = prefs.edit()
        editor.putLong("millisLeft", mTimeLeftInMillis)
        editor.putBoolean("timerRunning", mTimerRunning)
        editor.putLong("endTime", mEndTime)
        editor.apply()*/
        if (mCountDownTimer != null) {
            mCountDownTimer!!.cancel()
        }
    }
    private fun updateCountDownText() {
        val minutes = (mTimeLeftInMillis / 1000).toInt() / 60
        val seconds = (mTimeLeftInMillis / 1000).toInt() % 60
        val timeLeftFormatted = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds)
        mTextViewCountDown!!.text = timeLeftFormatted
    }

    override fun onStart() {
        super.onStart()
        val prefs = getSharedPreferences("prefs", MODE_PRIVATE)
        mTimeLeftInMillis = prefs.getLong("millisLeft", Companion.START_TIME_IN_MILLIS)
        mTimerRunning = prefs.getBoolean("timerRunning", false)

        if (mTimerRunning) {
            mEndTime = prefs.getLong("endTime", 0)
            mTimeLeftInMillis = mEndTime - System.currentTimeMillis()
            if (mTimeLeftInMillis < 0) {
                mTimeLeftInMillis = 0
                mTimerRunning = true
                updateCountDownText()


            }else {
                startTimerFood()
                startTimerMood()
                startTimerDoctor()
                startTimerWalk()
            }
        }
    }

    companion object {
        private const val START_TIME_IN_MILLIS: Long = 10000

    }

    private fun createNotificationChannel(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            val title = "Notification Title"
            val descriptionText = "Notification Description"
            val importance =NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(channelId, title, importance).apply {

                description=descriptionText
            }
            val notificationManager:NotificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }
    private fun sendNotificationFood(){



        val bitmap = BitmapFactory.decodeResource(applicationContext.resources, R.drawable.dog)
        val bitmapLargeIcon = BitmapFactory.decodeResource(applicationContext.resources, R.drawable.dog)


        val builder = NotificationCompat.Builder(this, channelId)
            .setSmallIcon(R.drawable.dog)
            .setContentTitle("Симулятор Питомца")
            .setContentText("Покорми меня")
            .setLargeIcon(bitmapLargeIcon)
            .setStyle(NotificationCompat.BigPictureStyle().bigPicture(bitmap))
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)

        with(NotificationManagerCompat.from(this))
        {
            notify(notificationID, builder.build())
        }
        notificationID+=1
    }


    private fun sendNotificationMood(){
        /*val intent =Intent(this, Simulator::class.java).apply {
            flags=Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }*/


        val bitmap = BitmapFactory.decodeResource(applicationContext.resources, R.drawable.dog)
        val bitmapLargeIcon = BitmapFactory.decodeResource(applicationContext.resources, R.drawable.dog)


        val builder = NotificationCompat.Builder(this, channelId)
            .setSmallIcon(R.drawable.dog)
            .setContentTitle("Симулятор Питомца")
            .setContentText("Мне грустно! Погладь меня")
            .setLargeIcon(bitmapLargeIcon)
            .setStyle(NotificationCompat.BigPictureStyle().bigPicture(bitmap))
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)

        with(NotificationManagerCompat.from(this))
        {
            notify(notificationID, builder.build())
        }
        notificationID+=1
    }

    private fun sendNotificationDoctor(){
        /*val intent =Intent(this, Simulator::class.java).apply {
            flags=Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }*/


        val bitmap = BitmapFactory.decodeResource(applicationContext.resources, R.drawable.dog)
        val bitmapLargeIcon = BitmapFactory.decodeResource(applicationContext.resources, R.drawable.dog)


        val builder = NotificationCompat.Builder(this, channelId)
            .setSmallIcon(R.drawable.dog)
            .setContentTitle("Симулятор Питомца")
            .setContentText("Мне что-то нехорошо. Возможно, я заболел")
            .setLargeIcon(bitmapLargeIcon)
            .setStyle(NotificationCompat.BigPictureStyle().bigPicture(bitmap))
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)

        with(NotificationManagerCompat.from(this))
        {
            notify(notificationID, builder.build())
        }
        notificationID+=1
    }

    private fun sendNotificationWalk(){
        /*val intent =Intent(this, Simulator::class.java).apply {
            flags=Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }*/


        val bitmap = BitmapFactory.decodeResource(applicationContext.resources, R.drawable.dog)
        val bitmapLargeIcon = BitmapFactory.decodeResource(applicationContext.resources, R.drawable.dog)


        val builder = NotificationCompat.Builder(this, channelId)
            .setSmallIcon(R.drawable.dog)
            .setContentTitle("Симулятор Питомца")
            .setContentText("Я хочу гулять!")
            .setLargeIcon(bitmapLargeIcon)
            .setStyle(NotificationCompat.BigPictureStyle().bigPicture(bitmap))
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)

        with(NotificationManagerCompat.from(this))
        {
            notify(notificationID, builder.build())
        }
        notificationID+=1
    }


    private fun sendNotificationDeath(){
        /*val intent =Intent(this, Simulator::class.java).apply {
            flags=Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }*/


        val bitmap = BitmapFactory.decodeResource(applicationContext.resources, R.drawable.dog)
        val bitmapLargeIcon = BitmapFactory.decodeResource(applicationContext.resources, R.drawable.dog)


        val builder = NotificationCompat.Builder(this, channelId)
            .setSmallIcon(R.drawable.dog)
            .setContentTitle("Симулятор Питомца")
            .setContentText("Из-за плохого ухода Ваш питомец погиб!")
            .setLargeIcon(bitmapLargeIcon)
            .setStyle(NotificationCompat.BigPictureStyle().bigPicture(bitmap))
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)

        with(NotificationManagerCompat.from(this))
        {
            notify(notificationID, builder.build())
        }
    }


}









