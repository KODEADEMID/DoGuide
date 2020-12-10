package kodeA.doguide.course.PayCourses

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kodeA.doguide.R

class PaidActivity : AppCompatActivity() {
    lateinit var but: Button
    lateinit var but2: Button

    lateinit var dogname: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_paid)


        val intent = getIntent()
        var Breed = intent.getStringExtra("Breed")

        var sharedPrefs = getSharedPreferences("kodeA.doguide", Context.MODE_PRIVATE)
        Breed = sharedPrefs.getString("Breed", Breed)
        val editor = sharedPrefs.edit()
        editor.apply{
            putString("Breed", Breed)
        }.apply()



        dogname = Breed.toString()
        but = findViewById(R.id.button) as Button
        but2 = findViewById(R.id.button2) as Button


        if (dogname == "Доберман") {
            but.text = "Команды: \"Голос!\" и \"Стоять!\""
            but2.text = "Ошибки, мешающие процессу дрессировки и советы"
            //  but.setVisibility(View.GONE)
        }

        if (dogname == "Корги") {
            but.text = "Разбор популярных ошибок, отучение от кусания и воя, команда:\"Фу!\""
            but2.setVisibility(View.GONE)
        }


        if (dogname == "Французский бульдог") {
            but.text = "Кликер-дрессировка, команды: \"Тихо!\" и \"На месте!\""
            but2.text = "Социализация собаки в доме, машине, парке"
            //  but.setVisibility(View.GONE)
        }

        findViewById<Button>(R.id.button).setOnClickListener() {
            val intent = Intent(this, Paid1Activity::class.java)
            intent.putExtra("Breed", Breed)
            startActivity(intent)
        }

        findViewById<Button>(R.id.button2).setOnClickListener() {
            val intent = Intent(this, Paid2Activity::class.java)
            intent.putExtra("Breed", Breed)
            startActivity(intent)
        }
    }

}
