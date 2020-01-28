package com.steamedbunx.android.employeeworkinghourtracker.ui.pinpad

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.steamedbunx.android.employeeworkinghourtracker.R

class PinPadActivity : AppCompatActivity() {

    private lateinit var viewModel: PinPadViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pin_pad_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, PinPadFragment.newInstance())
                .commitNow()
        }
    }

}
