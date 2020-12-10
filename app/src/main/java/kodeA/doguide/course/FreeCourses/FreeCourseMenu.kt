package kodeA.doguide.course.FreeCourses

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import kodeA.doguide.R

class FreeCourseMenu : AppCompatActivity() {
    lateinit var but: Button
    lateinit var but2: Button
    lateinit var but3: Button
    lateinit var but4: Button
    lateinit var dogname: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cours1)

        val intent = getIntent()
        var Breed = intent.getStringExtra("Breed")


        var sharedPrefs = getSharedPreferences("kodeA.doguide", Context.MODE_PRIVATE)
        Breed = sharedPrefs.getString("Breed", Breed)
        val editor = sharedPrefs.edit()
        editor.apply{
            putString("Breed", Breed)
        }.apply()



        dogname=Breed.toString()
        but = findViewById(R.id.button) as Button
        but2 = findViewById(R.id.button2) as Button
        but3 = findViewById(R.id.button3) as Button
        but4 = findViewById(R.id.button4) as Button
        if (dogname=="Доберман"){
            but.text="Команды: \"Место!\" и \"Ко мне!\""
            but2.text="Команды: \"Фу!\" и \"Рядом!\""
            but3.text="Команды: \"Сидеть!\" и \"Лежать!\""
            but4.setVisibility(View.GONE)
        }
        if (dogname=="Корги"){
            but.text="Воспитание базовых навыков"
            but2.text="Прилежное поведение на прогулке"
            but3.text="Команды: \"Ко мне!\", \"Рядом!\", \"Голос!\" и  \"Сидеть!\""
            but4.text="Команды: \"Место!\", \"Лежать!\" и \"Нельзя!\""
        }
        if (dogname=="Французский бульдог"){
            but.text="Общая информация"
            but2.text="Приучение к туалету, ошейнику и поводку"
            but3.text="Команды: \"Ко мне!\", \"Стоять!\" и \"Сидеть!\""
            but4.text="Команды: \"Лежать!\", \"Рядом!\" и \"Нельзя!\""
        }
        findViewById<Button>(R.id.button).setOnClickListener() {
            val intent = Intent(this, Free1Activity::class.java)
            intent.putExtra("Breed", Breed)
            startActivity(intent)
        }
        findViewById<Button>(R.id.button2).setOnClickListener() {
            val intent = Intent(this, Free2Activity::class.java)
            intent.putExtra("Breed", Breed)
            startActivity(intent)
        }
        findViewById<Button>(R.id.button3).setOnClickListener() {
            val intent = Intent(this, Free3Activity::class.java)
            intent.putExtra("Breed", Breed)
            startActivity(intent)
        }
        findViewById<Button>(R.id.button4).setOnClickListener() {
            val intent = Intent(this, Free4Activity::class.java)
            intent.putExtra("Breed", Breed)
            startActivity(intent)
        }
    }
}