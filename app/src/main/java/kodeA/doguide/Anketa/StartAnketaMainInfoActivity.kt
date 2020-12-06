package kodeA.doguide.Anketa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.view.View
import android.widget.*
import kodeA.doguide.NavigationMenuActivity
import kodeA.doguide.R
import kotlinx.android.synthetic.main.activity_form.*
import kotlinx.android.synthetic.main.activity_form.spinner
import kotlinx.android.synthetic.main.activity_simulator.*
import kotlinx.android.synthetic.main.activity_start_anketa_main_info.*

class StartAnketaMainInfoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start_anketa_main_info)






        val listBreed = arrayOf("Не выбрано","Хаски", "Корги", "Бигль", "Французский бульдог", "Немецкий спаниель", "Немецкая овчарка", "Такса", "Доберман", "Лабрадор", "Колли")
        val arrayAdapterBreed =
            ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, listBreed)

        spinner_breed.adapter = arrayAdapterBreed
        spinner_breed.onItemSelectedListener = object :

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



        val listAge = arrayOf("Не выбрано","Щенок (до 1 года)", "Молодая собака (от 1 до 3 лет)", "Взрослая собака (от 3 до 8 лет)", "Старая собака (от 8 до 10-12 лет)")
        val arrayAdapterAge =
            ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, listAge)

        spinner_age.adapter = arrayAdapterAge
        spinner_age.onItemSelectedListener = object :

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


        val listTime = arrayOf("Не выбрано", "Только начала с нами жить (1-4 месяца)", "Около полугода (4-8 месяцев)", "Примерно год (8-12 месяцев)", "Больше года (1 год и далее)")
        val arrayAdapterTime =
            ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, listTime)

        spinner_time.adapter = arrayAdapterTime
        spinner_time.onItemSelectedListener = object :

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


        val sharedPrefs = getSharedPreferences("kodeA.doguide", MODE_PRIVATE)


        var SpinnerAge = findViewById<View>(R.id.spinner_age) as Spinner
        var Age = SpinnerAge.selectedItem.toString();
        var SpinnerLive = findViewById<View>(R.id.spinner_time) as Spinner
        var Live = SpinnerLive.selectedItem.toString()
        var SpinnerBreed = findViewById<View>(R.id.spinner_breed) as Spinner
        var breed = SpinnerBreed.selectedItem.toString()


        var nickname = findViewById<EditText>(R.id.answer_1)
        var Nickname = nickname.text.toString()

        Nickname = sharedPrefs.getString("Nickname", Nickname).toString()
        breed = sharedPrefs.getString("Breed", breed).toString()
        Live = sharedPrefs.getString("Live", Live).toString()
        Age= sharedPrefs.getString("Age", Age).toString()



        findViewById<Button>(R.id.click).setOnClickListener() {

            var nickname = findViewById<EditText>(R.id.answer_1)

            var SpinnerBreed = findViewById<View>(R.id.spinner_breed) as Spinner
            var breed = SpinnerBreed.selectedItem.toString()

            var SpinnerLive = findViewById<View>(R.id.spinner_time) as Spinner
            var Live = SpinnerLive.selectedItem.toString()

            var SpinnerAge = findViewById<View>(R.id.spinner_age) as Spinner
            var Age = SpinnerAge.selectedItem.toString();

            when {
                nickname.text.toString().isNullOrEmpty() -> {
                    Toast.makeText(this, "Пожалуйста, введите кличку", Toast.LENGTH_SHORT).show()
                }
                breed=="Не выбрано" -> {
                    Toast.makeText(this, "Пожалуйста, укажите породу", Toast.LENGTH_SHORT).show()
                }
                Age=="Не выбрано" -> {
                    Toast.makeText(this, "Пожалуйста, укажите возраст", Toast.LENGTH_SHORT).show()
                }
                Live=="Не выбрано" -> {
                    Toast.makeText(this, "Пожалуйста, укажите как давно с вами живет собака", Toast.LENGTH_SHORT).show()
                }
                else -> {

                    val editor = getSharedPreferences("kodeA.doguide", MODE_PRIVATE).edit()
                    editor.putString("Age", Age)
                    editor.commit()

                    val editor1 = getSharedPreferences("kodeA.doguide", MODE_PRIVATE).edit()
                    editor1.putString("Live", Live)
                    editor1.commit()

                    val editor2 = getSharedPreferences("kodeA.doguide", MODE_PRIVATE).edit()
                    editor2.putString("Breed", breed)
                    editor2.commit()

                    val editor3 = getSharedPreferences("kodeA.doguide", MODE_PRIVATE).edit()
                    editor3.putString("Nickname", Nickname)
                    editor3.commit()

                    val intent = Intent(this, AnketaHealthActivity::class.java)
                    startActivity(intent)

                }
            }


        }


    }
}