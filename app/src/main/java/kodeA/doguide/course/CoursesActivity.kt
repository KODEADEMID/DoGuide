package kodeA.doguide.course

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kodeA.doguide.R
import kodeA.doguide.course.FreeCourses.FreeCourseMenu
import kodeA.doguide.course.PayCourses.PaidActivity

class CoursesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_courses)
        val intent = getIntent()
        var Breed = intent.getStringExtra("Breed")

        var sharedPrefs = getSharedPreferences("kodeA.doguide", Context.MODE_PRIVATE)
        Breed = sharedPrefs.getString("Breed", Breed)
        val editor = sharedPrefs.edit()
        editor.apply{
            putString("Breed", Breed)
        }.apply()


        findViewById<Button>(R.id.free).setOnClickListener() {
            val intent = Intent(this, FreeCourseMenu::class.java)
            intent.putExtra("Breed", Breed)
            startActivity(intent)
        }

        findViewById<Button>(R.id.paid).setOnClickListener() {
            val intent = Intent(this, PaidActivity::class.java)
            intent.putExtra("Breed", Breed)
            startActivity(intent)
        }
    }
}