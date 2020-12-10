package kodeA.doguide

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import kodeA.doguide.Anketa.StartAnketaMainInfoActivity

class SplashScreenActivity : AppCompatActivity() {
    private val SPLASH_TIME: Long = 2500
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        //var flag = "0"


        val preferences = getSharedPreferences("PREFERENCE", MODE_PRIVATE)
        val firstTime = preferences.getString("FirstTimeInstall", "No")





        if (firstTime=="No") {

            Handler().postDelayed({
                startActivity(Intent(this, StartAnketaMainInfoActivity::class.java))
                finish()
            }, SPLASH_TIME)

            val edit = preferences.edit()
            edit.putString("FirstTimeInstall", "Yes")
            edit.apply()


        }




        if (firstTime=="Yes") {

        Handler().postDelayed({
                startActivity(Intent(this, NavigationMenuActivity::class.java))
                finish()
            }, SPLASH_TIME)}


       // val data = intent.extras!!.getString("FirstTimeInstall")



    }
}