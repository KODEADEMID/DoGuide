package kodeA.doguide

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.activity_form.*

class FormActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)

        var nicknameED = findViewById<EditText>(R.id.answer_1)



        val listBreed = arrayOf("Хаски", "Корги", "Бигль")
        val arrayAdapter =
            ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, listBreed)

        spinner.adapter = arrayAdapter

        spinner.onItemSelectedListener = object :

            AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                //Toast.makeText(this@FormActivity, listBreed[position], Toast.LENGTH_LONG).show()
                //spinnerResult.text = listBreed[position]
            }
        }


        findViewById<Button>(R.id.save).setOnClickListener {
            if (nicknameED.text.toString().isNullOrEmpty()) {
                Toast.makeText(this, "Пожалуйста, введите кличку", Toast.LENGTH_LONG).show()
            } else {
                val intent = Intent(this@FormActivity, NavigationMenuActivity::class.java)
                startActivity(intent)

            }


        }
    }
}