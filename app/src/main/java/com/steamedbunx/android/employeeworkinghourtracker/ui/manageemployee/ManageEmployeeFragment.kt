package com.steamedbunx.android.employeeworkinghourtracker.ui.manageemployee

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.steamedbunx.android.employeeworkinghourtracker.R

class ManageEmployeeFragment : Fragment() {

    companion object {
        fun newInstance() = ManageEmployeeFragment()
    }

    private lateinit var viewModel: ManageEmployeeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.manage_employee_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ManageEmployeeViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
