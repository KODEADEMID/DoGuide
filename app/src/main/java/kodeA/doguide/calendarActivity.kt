package kodeA.doguide

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CalendarView
import android.widget.Toast
import kodeA.doguide.ToDoList.ToDoActivity
import kodeA.doguide.UhodInfo.MenuForInform

class calendarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calendar)

        var calend = findViewById<CalendarView>(R.id.calendarView)
        calend.setOnDateChangeListener { calend: CalendarView, i: Int, i2: Int, i3: Int ->

        }

        findViewById<Button>(R.id.btn_to_planner).setOnClickListener{
            val intent = Intent(this, ToDoActivity::class.java)
            startActivity(intent)
        }
    }
}