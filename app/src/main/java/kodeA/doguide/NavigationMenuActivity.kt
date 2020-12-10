package kodeA.doguide

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.navigation.NavigationView
import kodeA.doguide.InfoAnimal.InfoAnimalActivity
import kodeA.doguide.UhodInfo.MenuForInform
import kodeA.doguide.course.CoursesActivity
import kotlinx.android.synthetic.main.activity_navigation_menu.*
import kotlinx.android.synthetic.main.app_bar_navigation_menu.*
import kotlinx.android.synthetic.main.header.*
import java.util.*

class NavigationMenuActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    lateinit var training: Training
    lateinit var home: Home
    lateinit var setting: Setting



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation_menu)


        setSupportActionBar(toolBar)
        val actionBar = supportActionBar
        actionBar?.title = "Главная"


        /*val intent = getIntent()
        var Nickname= intent.getStringExtra("Nickname")
        var Breed = intent.getStringExtra("Breed")*/
        //nickname.text = "Nicname"
        //breed.text = "Breed"


        val drawerToggle:ActionBarDrawerToggle = object : ActionBarDrawerToggle(
            this, drawerLayout, toolBar, (R.string.open), (R.string.close)
        )
        {

        }
        drawerToggle.isDrawerIndicatorEnabled = true
        drawerLayout.addDrawerListener(drawerToggle)
        drawerToggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)

        /*val header = nav_view.getHeaderView(0)
        val intent = getIntent()
        var Nickname= intent.getStringExtra("Nickname")
        var Breed = intent.getStringExtra("Breed")
        nickname.setText(Nickname)
        breed.setText(Breed)*/


        home = Home()
        supportFragmentManager.beginTransaction().replace(R.id.frame_layout, home).setTransition(
            FragmentTransaction.TRANSIT_FRAGMENT_OPEN
        ).commit()



    }



    override fun onNavigationItemSelected(menuItem: MenuItem): Boolean {
        val intent = getIntent()
        var Age = intent.getStringExtra("Age")
        var Live = intent.getStringExtra("Live")
        var Nickname= intent.getStringExtra("Nickname")
        var Breed = intent.getStringExtra("Breed")
        var Zabol = intent.getStringExtra("Zabol")
        var Food = intent.getStringExtra("Food")
        var Street = intent.getStringExtra("Street")
        var Nasil = intent.getStringExtra("Nasil")
        var Agress = intent.getStringExtra("Agress")
        var Storona = intent.getStringExtra("Storona")
        var SluchAgress = intent.getStringExtra("SluchAgress")
        var Game = intent.getStringExtra("Game")
        var Lubop = intent.getStringExtra("Lubop")
        var SpeakDog = intent.getStringExtra("SpeakDog")
        var SpeakPeople = intent.getStringExtra("SpeakPeople")
        var DopInfo = intent.getStringExtra("DopInfo")

        when(menuItem.itemId){
            R.id.nav_home -> {

                home = Home()
                supportFragmentManager.beginTransaction().replace(R.id.frame_layout, home)
                    .setTransition(
                        FragmentTransaction.TRANSIT_FRAGMENT_OPEN
                    ).commit()
            }
            R.id.nav_info_animal -> {
                //startActivity( Intent(this, StartAnketaMainInfoActivity::class.java))
                val intent = Intent(this, InfoAnimalActivity::class.java)
                intent.putExtra("Zabol", Zabol)
                intent.putExtra("Food", Food)
                intent.putExtra("Street", Street)
                intent.putExtra("Nasil", Nasil)
                intent.putExtra("Age", Age)
                intent.putExtra("Live", Live)
                intent.putExtra("Breed", Breed)
                intent.putExtra("Nickname", Nickname)
                intent.putExtra("Agress", Agress)
                intent.putExtra("Storona", Storona)
                intent.putExtra("SluchAgress", SluchAgress)
                intent.putExtra("Game", Game)
                intent.putExtra("Lubop", Lubop)
                intent.putExtra("SpeakDog", SpeakDog)
                intent.putExtra("SpeakPeople", SpeakPeople)
                intent.putExtra("DopInfo", DopInfo)
                startActivity(intent)
            }
            R.id.nav_dop_info -> {

                val intent = Intent(this, MenuForInform::class.java)
                intent.putExtra("Breed", Breed)
                startActivity(intent)
                //calender = calender()
                //supportFragmentManager.beginTransaction().replace(R.id.frame_layout, calender).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit()
            }
            R.id.nav_calend -> {
                startActivity(Intent(this, calendarActivity::class.java))

            }
            R.id.nav_simulator -> {
                startActivity(Intent(this, Simulator::class.java))
            }
            R.id.nav_training -> {
                val intent = Intent(this, CoursesActivity::class.java)
                intent.putExtra("Breed", Breed)
                startActivity(intent)

            }
            R.id.nav_setting -> {
                setting = Setting()
                supportFragmentManager.beginTransaction().replace(R.id.frame_layout, setting)
                    .setTransition(
                        FragmentTransaction.TRANSIT_FRAGMENT_OPEN
                    ).commit()
            }

        }
        drawerLayout.closeDrawer(GravityCompat.START)
        return true

    }

    fun OnBackPressed(){
        if(drawerLayout.isDrawerOpen(GravityCompat.START))
        {
            drawerLayout.closeDrawer(GravityCompat.START)
        }else {
            super.onBackPressed()
        }
    }
}