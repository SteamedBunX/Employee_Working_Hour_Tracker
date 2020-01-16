package com.steamedbunx.android.employeeworkinghourtracker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.steamedbunx.android.employeeworkinghourtracker.ui.landing.LandingFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, LandingFragment.newInstance())
                .commitNow()
        }
    }

}
