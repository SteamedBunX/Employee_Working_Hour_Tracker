package com.steamedbunx.android.employeeworkinghourtracker.ui.confirmation

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.steamedbunx.android.employeeworkinghourtracker.R

class ConfirmationFragment : Fragment() {

    companion object {
        fun newInstance() = ConfirmationFragment()
    }

    private lateinit var viewModel: ConfirmationViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.confirmation_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ConfirmationViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
