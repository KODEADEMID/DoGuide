package kodeA.doguide

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.activity_form.*


class FormActivity : AppCompatActivity() {

    val myDbManager = MyDBManager(this)


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
        val mySpinner = findViewById<View>(R.id.spinner) as Spinner
        val text = mySpinner.selectedItem.toString()

        findViewById<Button>(R.id.click).setOnClickListener() {
            if (nicknameED.text.toString().isNullOrEmpty()) {
                Toast.makeText(this, "Пожалуйста, введите кличку", Toast.LENGTH_LONG).show()
           } else {


               val intent = Intent(this@FormActivity, NavigationMenuActivity::class.java)
                startActivity(intent)
                myDbManager.openDB()
                myDbManager.insertToDB(answer_1.text.toString(), text)
           }


        }
    }


    override fun onDestroy() {
        super.onDestroy()
        myDbManager.closeDB()
    }
}
