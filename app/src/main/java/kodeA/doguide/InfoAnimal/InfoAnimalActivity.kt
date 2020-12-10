package kodeA.doguide.InfoAnimal

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.preference.PreferenceManager
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kodeA.doguide.Anketa.MiddleAnketaCharacterActivity
import kodeA.doguide.Anketa.StartAnketaMainInfoActivity
import kodeA.doguide.R


class InfoAnimalActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info_animal)


        val intent = intent
        var Age = intent.getStringExtra("Age")
        var Live = intent.getStringExtra("Live")
        var Nickname= intent.getStringExtra("Nickname")
        var Breed = intent.getStringExtra("Breed")
        var Zabol = intent.getStringExtra("Zabol")
        var Food = intent.getStringExtra("Food")
        var Street = intent.getStringExtra("Street")
        var Nasil = intent.getStringExtra("Nasil")
        var Agress = intent.getStringExtra("Agress")
        var Storona = intent.getStringExtra("Storona")
        var SluchAgress = intent.getStringExtra("SluchAgress")
        var Game = intent.getStringExtra("Game")
        var Lubop = intent.getStringExtra("Lubop")
        var SpeakDog = intent.getStringExtra("SpeakDog")
        var SpeakPeople = intent.getStringExtra("SpeakPeople")
        var DopInfo = intent.getStringExtra("DopInfo")

        var sharedPrefs = getSharedPreferences("kodeA.doguide", Context.MODE_PRIVATE)

        Age = sharedPrefs.getString("Age", Age)
        Live = sharedPrefs.getString("Live", Live)
        Breed = sharedPrefs.getString("Breed", Breed)
        Nickname = sharedPrefs.getString("Nickname", Nickname)
        Zabol= sharedPrefs.getString("Zabol", Zabol)
        Food = sharedPrefs.getString("Food", Food)
        Street = sharedPrefs.getString("Street", Street)
        Nasil = sharedPrefs.getString("Nasil", Nasil)
        Agress = sharedPrefs.getString("Agress", Agress)
        Storona = sharedPrefs.getString("Storona", Storona)
        SluchAgress = sharedPrefs.getString("SluchAgress", SluchAgress)
        Game = sharedPrefs.getString("Game", Game)
        Lubop = sharedPrefs.getString("Lubop", Lubop)
        SpeakDog = sharedPrefs.getString("SpeakDog", SpeakDog)
        SpeakPeople = sharedPrefs.getString("SpeakPeople", SpeakPeople)
        DopInfo= sharedPrefs.getString("DopInfo",  DopInfo)


        val nickname = findViewById<TextView>(R.id.answer1)
            nickname.text = Nickname

            val breed = findViewById<TextView>(R.id.answer2)
            breed.text = Breed

            val age = findViewById<TextView>(R.id.answer3)
            age.text = Age

            val live = findViewById<TextView>(R.id.answer4)
            live.text = Live

            val zabol = findViewById<TextView>(R.id.answer5)
            zabol.text = Zabol

            val food = findViewById<TextView>(R.id.answer6)
            food.text = Food

            val street = findViewById<TextView>(R.id.answer7)
            street.text = Street

            val nasil = findViewById<TextView>(R.id.answer8)
            nasil.text = Nasil

            val agress = findViewById<TextView>(R.id.answer9)
            agress.text = Agress

            val storona = findViewById<TextView>(R.id.answer10)
            storona.text = Storona

            val sluch = findViewById<TextView>(R.id.answer11)
            sluch.text = SluchAgress

            val game = findViewById<TextView>(R.id.answer12)
            game.text = Game

            val lubop = findViewById<TextView>(R.id.answer13)
            lubop.text = Lubop

            val speakDog = findViewById<TextView>(R.id.answer14)
            speakDog.text = SpeakDog

            val speakPeople = findViewById<TextView>(R.id.answer15)
            speakPeople.text = SpeakPeople

            val dopInfo = findViewById<TextView>(R.id.answer16)
            dopInfo.text = DopInfo



        val editor = sharedPrefs.edit()
        editor.apply{
            putString("Age", Age)
            putString("Live", Live)
            putString("Breed", Breed)
            putString("Nickname", Nickname)
            putString("Zabol", Zabol)
            putString("Food", Food)
            putString("Street", Street)
            putString("Nasil", Nasil)
            putString("Agress", Agress)
            putString("Storona", Storona)
            putString("SluchAgress", SluchAgress)
            putString("Game", Game)
            putString("Lubop", Lubop)
            putString("SpeakDog", SpeakDog)
            putString("SpeakPeople", SpeakPeople)
            putString("DopInfo",  DopInfo)
        }.apply()


        findViewById<Button>(R.id.click_change).setOnClickListener() {
            val intent = Intent(this, StartAnketaMainInfoActivity::class.java)
            startActivity(intent)


        }


        }




    }
