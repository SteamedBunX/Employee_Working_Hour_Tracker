package com.steamedbunx.android.employeeworkinghourtracker.ui.addeditemployee

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.steamedbunx.android.employeeworkinghourtracker.R

class AddEditEmployeeFragment : Fragment() {

    companion object {
        fun newInstance() = AddEditEmployeeFragment()
    }

    private lateinit var viewModel: AddEditEmployeeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.add_edit_employee_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(AddEditEmployeeViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
