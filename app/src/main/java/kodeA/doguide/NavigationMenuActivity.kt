package kodeA.doguide

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_navigation_menu.*
import kotlinx.android.synthetic.main.app_bar_navigation_menu.*

class NavigationMenuActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    lateinit var calender: calender
    lateinit var simul: Simul
    lateinit var training: Training
    lateinit var home: Home
    lateinit var setting: Setting

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation_menu)

        setSupportActionBar(toolBar)
        val actionBar = supportActionBar
        actionBar?.title = "DoGuide"


        val drawerToggle:ActionBarDrawerToggle = object : ActionBarDrawerToggle (
            this , drawerLayout, toolBar, (R.string.open), (R.string.close))
        {

        }
        drawerToggle.isDrawerIndicatorEnabled = true
        drawerLayout.addDrawerListener(drawerToggle)
        drawerToggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)


        home = Home()
        supportFragmentManager.beginTransaction().replace(R.id.frame_layout, home).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit()



    }

    override fun onNavigationItemSelected(menuItem: MenuItem): Boolean {

        when(menuItem.itemId){
            R.id.nav_home -> {



                home = Home()
                supportFragmentManager.beginTransaction().replace(R.id.frame_layout, home).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit()
            }
            R.id.nav_info_animal -> {
                startActivity( Intent(this, infoAnimalActivity::class.java))
            }
            R.id.nav_calender-> {
                calender = calender()
                supportFragmentManager.beginTransaction().replace(R.id.frame_layout, calender).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit()
            }
            R.id.nav_simulator -> {
                startActivity( Intent(this, Simulator::class.java))
            }
            R.id.nav_training -> {
               training  = Training()
                supportFragmentManager.beginTransaction().replace(R.id.frame_layout, training).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit()
            }
            R.id.nav_setting -> {
                setting  = Setting()
                supportFragmentManager.beginTransaction().replace(R.id.frame_layout, setting).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit()
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