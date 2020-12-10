package kodeA.doguide.UhodInfo

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kodeA.doguide.R

class MenuForInform : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_for_inform)

        val intent = getIntent()
        var Breed = intent.getStringExtra("Breed")

        var sharedPrefs = getSharedPreferences("kodeA.doguide", Context.MODE_PRIVATE)
        Breed = sharedPrefs.getString("Breed", Breed)

        val editor = sharedPrefs.edit()
        editor.apply{
            putString("Breed", Breed)
        }.apply()

        findViewById<Button>(R.id.info).setOnClickListener() {
            val intent = Intent(this, Info::class.java)
            intent.putExtra("Breed", Breed)
            startActivity(intent)
        }

        findViewById<Button>(R.id.pluse).setOnClickListener() {
            val intent = Intent(this, Plus::class.java)
            intent.putExtra("Breed", Breed)
            startActivity(intent)
        }

        findViewById<Button>(R.id.minuse).setOnClickListener() {
            val intent = Intent(this, Minus::class.java)
            intent.putExtra("Breed", Breed)
            startActivity(intent)
        }
    }
}