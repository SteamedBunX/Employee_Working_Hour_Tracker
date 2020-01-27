package com.steamedbunx.android.employeeworkinghourtracker

import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.transition.Visibility
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.steamedbunx.android.employeeworkinghourtracker.databinding.MainActivityBinding
import com.steamedbunx.android.employeeworkinghourtracker.ui.landing.LandingFragment
import com.steamedbunx.android.employeeworkinghourtracker.ui.manageemployee.ManageEmployeeFragment
import kotlinx.android.synthetic.main.main_activity.*


class MainActivity : AppCompatActivity() {

    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding =
            DataBindingUtil.setContentView<MainActivityBinding>(this, R.layout.main_activity)
        navController = this.findNavController(R.id.navHostFragment)
        NavigationUI.setupWithNavController(botNavBar,navController)
        navController.addOnDestinationChangedListener(destinationChangeListener)


    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp()
    }

    val destinationChangeListener = object:NavController.OnDestinationChangedListener{
        override fun onDestinationChanged(
            controller: NavController,
            destination: NavDestination,
            arguments: Bundle?
        ) {
            if(destination.label == "pin_pad_fragment")
            {
                botNavBar.visibility = View.GONE
            }else{
                botNavBar.visibility = View.VISIBLE
            }
        }
    }


}
