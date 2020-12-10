package kodeA.doguide.Anketa

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.view.View
import android.widget.*
import kodeA.doguide.NavigationMenuActivity
import kodeA.doguide.R

import kotlinx.android.synthetic.main.activity_simulator.*
import kotlinx.android.synthetic.main.activity_start_anketa_main_info.*


class StartAnketaMainInfoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start_anketa_main_info)


        var nickname = findViewById<EditText>(R.id.answer_1)
        var Nickname = nickname.text.toString()

       // var sharedPrefs = getSharedPreferences("kodeA.doguide", MODE_PRIVATE)



       // Nickname = sharedPrefs.getString("Nickname", Nickname).toString()


        var listBreed = arrayOf("Не выбрано","Хаски", "Корги", "Бигль", "Французский бульдог", "Немецкий спаниель", "Немецкая овчарка", "Такса", "Доберман", "Лабрадор", "Колли")
        var arrayAdapterBreed =
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
        var SpinnerBreed = findViewById<View>(R.id.spinner_breed) as Spinner
        var Breed = SpinnerBreed.selectedItem.toString()

       // Breed = sharedPrefs.getString("Breed", Breed).toString()



        var listAge = arrayOf("Не выбрано","Щенок (до 1 года)", "Молодая собака (от 1 до 3 лет)", "Взрослая собака (от 3 до 8 лет)", "Старая собака (от 8 до 10-12 лет)")
        var arrayAdapterAge =
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
        var SpinnerAge = findViewById<View>(R.id.spinner_age) as Spinner
        var Age = SpinnerAge.selectedItem.toString();

       // Age= sharedPrefs.getString("Age", Age).toString()


        var listTime = arrayOf("Не выбрано", "Только начала с нами жить (1-4 месяца)", "Около полугода (4-8 месяцев)", "Примерно год (8-12 месяцев)", "Больше года (1 год и далее)")
        var arrayAdapterTime =
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
        var SpinnerLive = findViewById<View>(R.id.spinner_time) as Spinner
        var Live = SpinnerLive.selectedItem.toString()

        //Live = sharedPrefs.getString("Live", Live).toString()


      /*  Age = sharedPrefs.getString("Age", Age).toString()
        Live = sharedPrefs.getString("Live", Live).toString()
        Breed = sharedPrefs.getString("Breed", Breed).toString()
        Nickname = sharedPrefs.getString("Nickname", Nickname).toString()

        Nickname = Nickname

        val breed = findViewById<TextView>(R.id.answer2)
        breed.text = Breed

        val age = findViewById<TextView>(R.id.answer3)
        age.text = Age

        val live = findViewById<TextView>(R.id.answer4)
        live.text = Live*/

        findViewById<Button>(R.id.click).setOnClickListener() {

            var nickname1 = findViewById<EditText>(R.id.answer_1)
            var nickname = nickname1.text.toString()

            var SpinnerBreed = findViewById<View>(R.id.spinner_breed) as Spinner
            var Breed = SpinnerBreed.selectedItem.toString()

            var SpinnerLive = findViewById<View>(R.id.spinner_time) as Spinner
            var Live = SpinnerLive.selectedItem.toString()

            var SpinnerAge = findViewById<View>(R.id.spinner_age) as Spinner
            var Age = SpinnerAge.selectedItem.toString();

            when {
                nickname1.text.toString().isNullOrEmpty() -> {
                    Toast.makeText(this, "Пожалуйста, введите кличку", Toast.LENGTH_SHORT).show()
                }
                Breed=="Не выбрано" -> {
                    Toast.makeText(this, "Пожалуйста, укажите породу", Toast.LENGTH_SHORT).show()
                }
                Age=="Не выбрано" -> {
                    Toast.makeText(this, "Пожалуйста, укажите возраст", Toast.LENGTH_SHORT).show()
                }
                Live=="Не выбрано" -> {
                    Toast.makeText(this, "Пожалуйста, укажите как давно с вами живет собака", Toast.LENGTH_SHORT).show()
                }
                else -> {

                    var sharedPrefs = getSharedPreferences("kodeA.doguide", Context.MODE_PRIVATE)

                    val editor = sharedPrefs.edit()
                    editor.apply{
                        putString("Age", Age)
                        putString("Live", Live)
                        putString("Breed", Breed)
                        putString("Nickname", nickname)
                    }.apply()

                    val intent = Intent(this, AnketaHealthActivity::class.java)
                    intent.putExtra("Age", Age)
                    intent.putExtra("Live", Live)
                    intent.putExtra("Breed", Breed)
                    intent.putExtra("Nickname", nickname)
                    startActivity(intent)

                }
            }
        }
    }
}