package kodeA.doguide.Anketa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import kodeA.doguide.R

class AnketaHealthActivity : AppCompatActivity() {


    lateinit var option: Spinner //Заболевания
    lateinit var option1: Spinner //Отношение к еде
    lateinit var option2: Spinner //Жила ли собака на улице когда-нибудь?
    lateinit var option3: Spinner //Подвергалась ли собака избиениям и издевательствам?
    //Всего 4 вопроса: первый без индекса, второй во всех относящихся к нему переменных в названии с индексом 1, третий с 2, четвертый с 3
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_anketa_health)

        option = findViewById(R.id.sp_option) as Spinner
        option1 = findViewById(R.id.sp_option1) as Spinner
        option2 = findViewById(R.id.sp_option2) as Spinner
        option3 = findViewById(R.id.sp_option3) as Spinner


        val options= arrayOf("Не выбрано","Заболевания кожи (аллергический дерматит, пиодермия, атопия и т.д.)",
            "Вирусные заболевания (бешенство, парвовирус, грипп, собачья чума и т.д.)",
            "Ортопедические заболевания (повреждения лап, связок, мышц или костей)",
            "Болезни сердца" ,
            "Опухоли или рак",
            "Желудочно-кишечные заболевания",
            "Болезни органов слуха или зрения" ,
            "Психологические травмы","Ничего из вышеперечисленного" )

        val options1= arrayOf("Не выбрано", "Может есть все","Есть аллергия на определенные продукты")

        val options2= arrayOf("Не выбрано", "Да","Нет")

        val options3= arrayOf("Не выбрано", "Да","Нет","Возможно (собака боится прикосновений, но точной информации нет)")

        option.adapter= ArrayAdapter<String> (this,android.R.layout.simple_list_item_activated_1,options)
        option1.adapter= ArrayAdapter<String> (this,android.R.layout.simple_list_item_activated_1,options1)
        option2.adapter= ArrayAdapter<String> (this,android.R.layout.simple_list_item_activated_1,options2)
        option3.adapter= ArrayAdapter<String> (this,android.R.layout.simple_list_item_activated_1,options3)

        findViewById<Button>(R.id.click).setOnClickListener() {
            val intent = Intent(this, MiddleAnketaCharacterActivity::class.java)
            startActivity(intent)
        }
    }
}

