package kodeA.doguide.Anketa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.google.android.material.internal.NavigationMenu
import kodeA.doguide.NavigationMenuActivity
import kodeA.doguide.R
import kotlinx.android.synthetic.main.activity_end_anketa_character.*
import kotlinx.android.synthetic.main.activity_middle_anketa_character.*

class EndAnketaCharacterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_end_anketa_character)

        val sharedPrefs = getSharedPreferences("kodeA", MODE_PRIVATE)



        val listLubop = arrayOf("Не выбрано", "Да", "Нет", "Затрудняюсь ответить")
        val arrayAdapterLubop =
            ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, listLubop)

        spinner_lubop.adapter = arrayAdapterLubop
        spinner_lubop.onItemSelectedListener = object :

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



        val listSpeakDog = arrayOf("Не выбрано","Да", "Нет", "Зависит от поведения и внешнего облика (больше, меньше, такого же размера) другой собаки")
        val arrayAdapterSpeakDog =
            ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, listSpeakDog)

        spinner_speak_dog.adapter = arrayAdapterSpeakDog
        spinner_speak_dog.onItemSelectedListener = object :

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



        val listSpeakPeople = arrayOf("Не выбрано", "Да", "Нет", "Зависит от того, какой человек и с каким настроем подходит к моей собаке")
        val arrayAdapterSpeakPeople=
            ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, listSpeakPeople)

        spinner_speak_people.adapter = arrayAdapterSpeakPeople
        spinner_speak_people.onItemSelectedListener = object :

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



        val listDopInfo = arrayOf( "Не выбрано", "Нет", "Да. Слушается меня", "Да.Слушается другого члена семьи", "Да.Слушается всех членов семьи", "Да.Слушается другого человека (не из семьи")
        val arrayAdapterDopInfo =
            ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, listDopInfo)

        spinner_dop_info.adapter = arrayAdapterDopInfo
        spinner_dop_info.onItemSelectedListener = object :

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

        var SpinnerLubop = findViewById<View>(R.id.spinner_lubop) as Spinner
        var Lubop = SpinnerLubop.selectedItem.toString();

        var SpinnerSpeakDog = findViewById<View>(R.id.spinner_speak_dog) as Spinner
        var SpeakDog = SpinnerSpeakDog.selectedItem.toString();

        var SpinnerSpeakPeople = findViewById<View>(R.id.spinner_speak_people) as Spinner
        var SpeakPeople = SpinnerSpeakPeople.selectedItem.toString();

        var SpinnerDopInfo = findViewById<View>(R.id.spinner_dop_info) as Spinner
        var DopInfo = SpinnerDopInfo.selectedItem.toString()

        Lubop = sharedPrefs.getString("Lubop", Lubop).toString()
        SpeakDog = sharedPrefs.getString("SpeakDog", SpeakDog).toString()
        SpeakPeople = sharedPrefs.getString("SpeakPeople", SpeakPeople).toString()
        DopInfo= sharedPrefs.getString("DopInfo",  DopInfo).toString()


        findViewById<Button>(R.id.click).setOnClickListener() {
            var SpinnerLubop = findViewById<View>(R.id.spinner_lubop) as Spinner
            var Lubop = SpinnerLubop.selectedItem.toString();

            var SpinnerSpeakDog = findViewById<View>(R.id.spinner_speak_dog) as Spinner
            var SpeakDog = SpinnerSpeakDog.selectedItem.toString();

            var SpinnerSpeakPeople = findViewById<View>(R.id.spinner_speak_people) as Spinner
            var SpeakPeople = SpinnerSpeakPeople.selectedItem.toString();

            var SpinnerDopInfo = findViewById<View>(R.id.spinner_dop_info) as Spinner
            var DopInfo = SpinnerDopInfo.selectedItem.toString()

            when {
                Lubop=="Не выбрано" -> {
                    Toast.makeText(this, "Пожалуйста, ответьте на впорос: Ваша собака любопытна?", Toast.LENGTH_SHORT).show()
                }
                SpeakDog=="Не выбрано" -> {
                    Toast.makeText(this, "Пожалуйста, ответьте на впорос: Общительна ли ваша собака относительно других собак?", Toast.LENGTH_SHORT).show()
                }
                SpeakPeople=="Не выбрано" -> {
                    Toast.makeText(this, "Пожалуйста, ответьте на впорос: Общительна ли ваша собака относительно других людей?", Toast.LENGTH_SHORT).show()
                }
                DopInfo=="Не выбрано" -> {
                    Toast.makeText(this, "Пожалуйста, ответьте на впорос: Можно ли назвать вашу собаку послушной? Если 'Да', то кого она слушается?", Toast.LENGTH_SHORT).show()
                }
                else -> {

                    val editor = getSharedPreferences("kodeA", MODE_PRIVATE).edit()
                    editor.putString("Lubop", Lubop)
                    editor.commit()

                    val editor1 = getSharedPreferences("kodeA", MODE_PRIVATE).edit()
                    editor1.putString("SpeakDog", SpeakDog)
                    editor1.commit()

                    val editor2 = getSharedPreferences("kodeA", MODE_PRIVATE).edit()
                    editor2.putString("SpeakPeople", SpeakPeople)
                    editor2.commit()

                    val editor3 = getSharedPreferences("kodeA", MODE_PRIVATE).edit()
                    editor3.putString("DopInfo",  DopInfo)
                    editor3.commit()

                    val intent = Intent(this, NavigationMenuActivity::class.java)
                    startActivity(intent)



                }
            }


        }


    }
}