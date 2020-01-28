package com.steamedbunx.android.employeeworkinghourtracker.ui.pinpad

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProviders
import com.steamedbunx.android.employeeworkinghourtracker.R

class PinPadActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pin_pad_activity)
        supportFragmentManager.beginTransaction()
            .replace(R.id.container_pinPadActivity, PinPadFragment.newInstance())
            .commitNow()
    }

}
