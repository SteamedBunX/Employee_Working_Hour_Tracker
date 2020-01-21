package com.steamedbunx.android.employeeworkinghourtracker.ui.pinpad

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.steamedbunx.android.employeeworkinghourtracker.R

class PinPadFragment : Fragment() {

    companion object {
        fun newInstance() = PinPadFragment()
    }

    private lateinit var viewModel: PinPadViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.pin_pad_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(PinPadViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
