package kodeA.doguide.Anketa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import kodeA.doguide.NavigationMenuActivity
import kodeA.doguide.R
import kotlinx.android.synthetic.main.activity_form.*
import kotlinx.android.synthetic.main.activity_form.spinner
import kotlinx.android.synthetic.main.activity_middle_anketa_character.*

class MiddleAnketaCharacterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_middle_anketa_character)

        val sharedPrefs = getSharedPreferences("kodeA.doguide", MODE_PRIVATE)


        val listAgress = arrayOf("Не выбрано","Да", "Нет")
        val arrayAdapterAgress =
            ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, listAgress)

        spinner_agress.adapter = arrayAdapterAgress
        spinner_agress.onItemSelectedListener = object :

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




        val listStorona = arrayOf("Не выбрано","Агрессия не проявляется", "К хозяевам и членам семьи", "К чужим людям, исключая хозяев и членов семьи", "К детям", "К животным", "К ветеринарам или кинологам", "Ко всем вышеперечисленным")
        val arrayAdapterStorona =
            ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, listStorona)

        spinner_storona.adapter = arrayAdapterStorona
        spinner_storona.onItemSelectedListener = object :

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

        val listSluch = arrayOf("Не выбрано","Абсолютно в любых ситуациях","Агрессия не проявляется", "Когда видит пьяных людей", "В случае того, когда видит потенциальную опасность для хозяина", "В случае того, если видит потенциальную опасность для себя", "Когда видит собаку меньше себя", "Когда видит собаку больше себя", "Когда видит другое животное (не собаку)", "Проявляет агрессию на прохожих", "Когда слышит громкие звуки, яркие цвета", "При попытке воспитательной деятельности или наказания (злой голос, отказ дать лакомство и т.д.)", "Когда к ней пытается подойти ребенок", "При посещении ветеринара или кинолога, при попытке лечения", "На конкретного человека (людей)", "На конкретный предмет")
        val arrayAdapterSluch =
            ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, listSluch)

        spinner_value.adapter = arrayAdapterSluch
        spinner_value.onItemSelectedListener = object :

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

        val listGame = arrayOf("Не выбрано","Абсолютно в любых ситуациях","Агрессия не проявляется", "Когда видит пьяных людей", "В случае того, когда видит потенциальную опасность для хозяина", "В случае того, если видит потенциальную опасность для себя", "Когда видит собаку меньше себя", "Когда видит собаку больше себя", "Когда видит другое животное (не собаку)", "Проявляет агрессию на прохожих", "Когда слышит громкие звуки, яркие цвета", "При попытке воспитательной деятельности или наказания (злой голос, отказ дать лакомство и т.д.)", "Когда к ней пытается подойти ребенок", "При посещении ветеринара или кинолога, при попытке лечения", "На конкретного человека (людей)", "На конкретный предмет")
        val arrayAdapterGame =
            ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, listGame)

        spinner_game.adapter = arrayAdapterGame
        spinner_game.onItemSelectedListener = object :

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


        var SpinnerAgress = findViewById<View>(R.id.spinner_agress) as Spinner
        var Agress = SpinnerAgress.selectedItem.toString()

        var SpinnerStorona = findViewById<View>(R.id.spinner_storona) as Spinner
        var Storona = SpinnerStorona.selectedItem.toString()

        var SpinnerSluchAgress = findViewById<View>(R.id.spinner_value) as Spinner
        var SluchAgress = SpinnerSluchAgress.selectedItem.toString()

        var SpinnerGame = findViewById<View>(R.id.spinner_game) as Spinner
        var Game = SpinnerGame.selectedItem.toString()

        Agress = sharedPrefs.getString("Agress", Agress).toString()
        Storona = sharedPrefs.getString("Storona", Storona).toString()
        SluchAgress = sharedPrefs.getString("SluchAgress", SluchAgress).toString()
        Game= sharedPrefs.getString("Game", Game).toString()

        findViewById<Button>(R.id.click).setOnClickListener() {

            var SpinnerAgress = findViewById<View>(R.id.spinner_agress) as Spinner
            var Agress = SpinnerAgress.selectedItem.toString()

            var SpinnerStorona = findViewById<View>(R.id.spinner_storona) as Spinner
            var Storona = SpinnerStorona.selectedItem.toString()

            var SpinnerSluchAgress = findViewById<View>(R.id.spinner_value) as Spinner
            var SluchAgress = SpinnerSluchAgress.selectedItem.toString()

            var SpinnerGame = findViewById<View>(R.id.spinner_game) as Spinner
            var Game = SpinnerGame.selectedItem.toString()




            when {
                Agress=="Не выбрано" -> {
                    Toast.makeText(this, "Пожалуйста, ответьте на вопрос №1", Toast.LENGTH_SHORT).show()
                }
                Storona=="Не выбрано" -> {
                    Toast.makeText(this, "Пожалуйста, ответьте на вопрос №2", Toast.LENGTH_SHORT).show()
                }
                SluchAgress=="Не выбрано" -> {
                    Toast.makeText(this, "Пожалуйста, ответьте на вопрос №3", Toast.LENGTH_SHORT).show()
                }
                Game=="Не выбрано" -> {
                    Toast.makeText(this, "Пожалуйста, ответьте на вопрос №4", Toast.LENGTH_SHORT).show()
                }
                else -> {


                    val editor = getSharedPreferences("kodeA.doguide", MODE_PRIVATE).edit()
                    editor.putString("Agress", Agress)
                    editor.commit()

                    val editor1 = getSharedPreferences("kodeA.doguide", MODE_PRIVATE).edit()
                    editor1.putString("Storona", Storona)
                    editor1.commit()

                    val editor2 = getSharedPreferences("kodeA.doguide", MODE_PRIVATE).edit()
                    editor2.putString("SluchAgress", SluchAgress)
                    editor2.commit()

                    val editor3 = getSharedPreferences("kodeA.doguide", MODE_PRIVATE).edit()
                    editor3.putString("Game", Game)
                    editor3.commit()

                    val intent = Intent(this,EndAnketaCharacterActivity::class.java)
                    startActivity(intent)

                }
            }

        }
    }
}