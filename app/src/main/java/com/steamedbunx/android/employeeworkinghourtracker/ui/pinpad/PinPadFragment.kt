package com.steamedbunx.android.employeeworkinghourtracker.ui.pinpad

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.steamedbunx.android.employeeworkinghourtracker.R
import com.steamedbunx.android.employeeworkinghourtracker.REQUEST_CODE
import com.steamedbunx.android.employeeworkinghourtracker.databinding.PinPadFragmentBinding

class PinPadFragment : Fragment() {

    companion object {
        fun newInstance() =
            PinPadFragment()
    }

    private lateinit var viewModel: PinPadViewModel
    private lateinit var binding: PinPadFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.pin_pad_fragment, container, false
        )
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        activity?.intent?.extras?.getInt(REQUEST_CODE)
        viewModel = ViewModelProviders.of(this).get(PinPadViewModel::class.java)
        viewModel.setMode(activity?.intent?.extras?.getInt(REQUEST_CODE) ?: 0)
    }


}
