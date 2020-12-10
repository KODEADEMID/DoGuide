package kodeA.doguide.course.FreeCourses

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import kodeA.doguide.R

class Free4Activity : AppCompatActivity() {
    lateinit var textv: TextView
    lateinit var textv2: TextView
    lateinit var korgi: String
    lateinit var buldog: String
    lateinit var doberman: String
    lateinit var dogname: String
    lateinit var ph: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_free4)
        val intent = getIntent()
        var Breed = intent.getStringExtra("Breed")


        var sharedPrefs = getSharedPreferences("kodeA.doguide", Context.MODE_PRIVATE)
        Breed = sharedPrefs.getString("Breed", Breed)
        val editor = sharedPrefs.edit()
        editor.apply{
            putString("Breed", Breed)
        }.apply()


        textv2 = findViewById(R.id.textView2) as TextView
        dogname=Breed.toString()

        ph=findViewById(R.id.imageView) as ImageView
        textv = findViewById(R.id.textView) as TextView

        korgi="Место\n" +
                "\n" +
                "Щенка укладывают на его лежанку и удерживают там, повторяя соответствующую команду. Спустя пару минут его поощряют лакомством и отпускают. Постепенно время пребывания вельш-корги на подстилке увеличивают, а чтобы у него не было желания покинуть свое место, ему оставляют игрушки.\n" +
                "\n" +
                "Лежать\n" +
                "\n" +
                "Сидящему щенку приказывают «Лежать!» и опускают перед его носом руку с лакомством, одновременно слегка нажимая на холку. Как только вельш-корги выполнит команду, его хвалят.\n" +
                "\n" +
                "Нельзя\n" +
                "\n" +
                "Это важная запрещающая команда, выполнение которой нужно довести до идеала. Когда щенок хочет схватить что-то с земли, его одергивают поводком и командуют «Нельзя!»."
        buldog="Команда “Лежать”. Держать руку с едой у носа животного и опускать руку до той точки, где должна оказаться голова в позиции лежа, другой рукой нажать на зад, пригнув к полу. Затем похвалить и отдать заслуженное угощение. После вакцинации бульдога рекомендуется выгуливать на улице, где можно продолжить обучение базовым командам.\n" +
                "\n" +
                "Команда “Рядом”. Ведя на прогулке своего питомца на коротком поводке, необходимо вести собаку рядом с собой, повторяя эту команду. Выполняется правильно, если собака идет рядом, не натягивая поводок и не тяня хозяина в стороны.\n" +
                "\n" +
                "Команда “Нельзя”. Питомец, находясь на длинном поводке, должен, услышав эту команду, отказаться от различных предпринимаемых им действий. В случае неповиновения можно одернуть его, потянув за поводок.\n" +
                "\n" +
                "Рассчитывая на выполнение команд с помощью кусочков еды важно помнить, что собака перед дрессировкой должна быть голодной, ведь сытая собака не будет заинтересована в выполнении команд за еду. Нужно помнить, что хвалить или давать угощение собаке нужно пока она выполняет команду, то есть сидит, стоит и т.д., а поощрять, например, сошедшую с места собаку — нарушать установленные правила."
        doberman=""

        if (dogname=="Французский бульдог"){
            textv2.setText("Команды: \"Лежать!\", \"Рядом!\" и \"Нельзя!\"")
            textv.setText(buldog)
            ph.setImageResource(R.drawable.dogbuldog)

        }

        if (dogname=="Доберман"){
            textv2.setText("")
            textv.setText(doberman)
            ph.setImageResource(R.drawable.dogdoberman)

        }

        if (dogname=="Корги"){
            textv2.setText("Команды: \"Место!\", \"Лежать!\" и \"Нельзя!\"")
            textv.setText(korgi)
            ph.setImageResource(R.drawable.dogkorgi)
        }


    }
}