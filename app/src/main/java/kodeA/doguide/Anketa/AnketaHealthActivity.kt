package kodeA.doguide.Anketa

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import kodeA.doguide.R
import kotlinx.android.synthetic.main.activity_anketa_health.*

class AnketaHealthActivity : AppCompatActivity() {


    lateinit var option: Spinner //Заболевания
    lateinit var option1: Spinner //Отношение к еде
    lateinit var option2: Spinner //Жила ли собака на улице когда-нибудь?
    lateinit var option3: Spinner //Подвергалась ли собака избиениям и издевательствам?
    //Всего 4 вопроса: первый без индекса, второй во всех относящихся к нему переменных в названии с индексом 1, третий с 2, четвертый с 3
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_anketa_health)

        val intent = getIntent()
        var Age = intent.getStringExtra("Age")
        var Live = intent.getStringExtra("Live")
        var Nickname= intent.getStringExtra("Nickname")
        var Breed = intent.getStringExtra("Breed")

      // val age = findViewById<TextView>(R.id.nic)
       //  age.text = Age

        val options= arrayOf(
            "Не выбрано", "Заболевания кожи",
            "Вирусные заболевания",
            "Ортопедические заболевания",
            "Болезни сердца",
            "Опухоли или рак",
            "Желудочно-кишечные заболевания",
            "Болезни органов слуха или зрения",
            "Психологические травмы", "Ничего из вышеперечисленного"
        )

        var arrayAdapterZabol = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_dropdown_item,
            options
        )

        sp_option.adapter = arrayAdapterZabol
        sp_option.onItemSelectedListener = object :

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

        val options1= arrayOf(
            "Не выбрано",
            "Может есть все",
            "Есть аллергия на определенные продукты"
        )
        var arrayAdapterFood = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_dropdown_item,
            options1
        )

        sp_option1.adapter = arrayAdapterFood
        sp_option1.onItemSelectedListener = object :

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

        val options2= arrayOf("Не выбрано", "Да", "Нет")
        var arrayAdapterStreet = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_dropdown_item,
            options2
        )

        sp_option2.adapter = arrayAdapterStreet
        sp_option2.onItemSelectedListener = object :

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

        val options3= arrayOf(
            "Не выбрано",
            "Да",
            "Нет",
            "Возможно"
        )
        var arrayAdapterNasil = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_dropdown_item,
            options3
        )

        sp_option3.adapter = arrayAdapterNasil
        sp_option3.onItemSelectedListener = object :

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

    /*    val sharedPrefs = getSharedPreferences("kodeA", MODE_PRIVATE)

        var SpinnerZabol = findViewById<View>(R.id.sp_option) as Spinner
        var Zabol = SpinnerZabol.selectedItem.toString()

        var SpinnerFood = findViewById<View>(R.id.sp_option1) as Spinner
        var Food = SpinnerFood.selectedItem.toString()

        var SpinnerSluchStreet = findViewById<View>(R.id.sp_option2) as Spinner
        var Street = SpinnerSluchStreet.selectedItem.toString()

        var SpinnerNasil = findViewById<View>(R.id.sp_option3) as Spinner
        var Nasil = SpinnerNasil.selectedItem.toString()

        Zabol = sharedPrefs.getString("Zabol", Zabol).toString()
        Food = sharedPrefs.getString("Food", Food).toString()
        Street = sharedPrefs.getString("Street", Street).toString()
        Nasil= sharedPrefs.getString("Nasil", Nasil).toString()*/


        findViewById<Button>(R.id.click).setOnClickListener() {


            var SpinnerZabol = findViewById<View>(R.id.sp_option) as Spinner
            var Zabol = SpinnerZabol.selectedItem.toString()

            var SpinnerFood = findViewById<View>(R.id.sp_option1) as Spinner
            var Food = SpinnerFood.selectedItem.toString()

            var SpinnerSluchStreet = findViewById<View>(R.id.sp_option2) as Spinner
            var Street = SpinnerSluchStreet.selectedItem.toString()

            var SpinnerNasil = findViewById<View>(R.id.sp_option3) as Spinner
            var Nasil = SpinnerNasil.selectedItem.toString()



            when {
                Zabol=="Не выбрано" -> {
                    Toast.makeText(this, "Пожалуйста, ответьте на вопрос №1", Toast.LENGTH_SHORT).show()
                }
                Food=="Не выбрано" -> {
                    Toast.makeText(this, "Пожалуйста, ответьте на вопрос №2", Toast.LENGTH_SHORT).show()
                }
                Street=="Не выбрано" -> {
                    Toast.makeText(this, "Пожалуйста, ответьте на вопрос №3", Toast.LENGTH_SHORT).show()
                }
                Nasil=="Не выбрано" -> {
                    Toast.makeText(this, "Пожалуйста, ответьте на вопрос №4", Toast.LENGTH_SHORT).show()
                }
                else -> {


                   /* val editor = getSharedPreferences("kodeA", MODE_PRIVATE).edit()
                    editor.putString("Zabol", Zabol)
                    editor.commit()

                    val editor1 = getSharedPreferences("kodeA", MODE_PRIVATE).edit()
                    editor1.putString("Food", Food)
                    editor1.commit()

                    val editor2 = getSharedPreferences("kodeA", MODE_PRIVATE).edit()
                    editor2.putString("Street", Street)
                    editor2.commit()

                    val editor3 = getSharedPreferences("kodeA", MODE_PRIVATE).edit()
                    editor3.putString("Nasil", Nasil)
                    editor3.commit()*/

                    val intent = Intent(this, MiddleAnketaCharacterActivity::class.java)
                    intent.putExtra("Zabol", Zabol)
                    intent.putExtra("Food", Food)
                    intent.putExtra("Street", Street)
                    intent.putExtra("Nasil", Nasil)
                    intent.putExtra("Age", Age)
                    intent.putExtra("Live", Live)
                    intent.putExtra("Breed", Breed)
                    intent.putExtra("Nickname", Nickname)
                    startActivity(intent)


                }
            }

        }
    }
}

