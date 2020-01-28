package com.steamedbunx.android.employeeworkinghourtracker

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.steamedbunx.android.employeeworkinghourtracker.databinding.MainActivityBinding
import com.steamedbunx.android.employeeworkinghourtracker.ui.pinpad.PinPadActivity
import kotlinx.android.synthetic.main.main_activity.*


class MainActivity : AppCompatActivity() {

    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding =
            DataBindingUtil.setContentView<MainActivityBinding>(this, R.layout.main_activity)
        navController = this.findNavController(R.id.navHostFragment)
        NavigationUI.setupWithNavController(botNavBar, navController)
        navController.addOnDestinationChangedListener(destinationChangeListener)


    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp()
    }

    val destinationChangeListener = object : NavController.OnDestinationChangedListener {
        override fun onDestinationChanged(
            controller: NavController,
            destination: NavDestination,
            arguments: Bundle?
        ) {
            if (destination.label == "pin_pad_fragment") {
                botNavBar.visibility = View.GONE
            } else {
                botNavBar.visibility = View.VISIBLE
            }
        }
    }

    fun lunchPinPadForResult(requestCode: Int) {
        val intent = Intent(this, PinPadActivity::class.java)
        intent.putExtra(REQUEST_CODE, requestCode)
        startActivityForResult(intent, requestCode)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (resultCode == Activity.RESULT_OK) {
            when (requestCode) {
                CHECK_IN -> 1
                CHECK_OUT -> 1
                MANAGE_EMPLOYEE -> 1
            }
        }

        super.onActivityResult(requestCode, resultCode, data)
    }
}
