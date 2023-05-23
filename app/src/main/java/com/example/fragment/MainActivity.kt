package com.example.fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.fragment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    //Drawer layput untuk menu di kiri/ menu slider
//    private lateinit var drawerLayout:DrawerLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        val binding  = DataBindingUtil.setContentView<ActivityMainBinding>(this,R.layout.activity_main)

//        drawerLayout = binding.drawerLayout


        //Menambah tombol back diatas sebelah kiri
        val navCtrl = this.findNavController(R.id.navhost_fragment)
        NavigationUI.setupActionBarWithNavController(this,navCtrl,
//            drawerLayout//
        )
//        NavigationUI.setupWithNavController(binding.navView,navCtrl)

        NavigationUI.setupWithNavController(binding.bottomNav,navCtrl)
    }

    //Lanjutan untuk menambah tombol back diatas
    override fun onSupportNavigateUp(): Boolean {
        val navCtrl = this.findNavController(R.id.navhost_fragment)
//        return NavigationUI.navigateUp(navCtrl,drawerLayout)
        return navCtrl.navigateUp()
    }
}