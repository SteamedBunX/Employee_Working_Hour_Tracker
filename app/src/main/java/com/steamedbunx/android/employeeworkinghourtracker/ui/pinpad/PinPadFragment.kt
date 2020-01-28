package com.steamedbunx.android.employeeworkinghourtracker.ui.pinpad

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
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
        setupLiveDataObservers()
        setupOnClickListeners()
    }

    private fun setupLiveDataObservers() {
        viewModel.requestCancelled.observe(this, Observer {
            cancelRequest()
        })
        viewModel.requestComplete.observe(this, Observer{
            completeRequest()
        })
        viewModel.currentPinDigit.observe(this, Observer {
            if(it == 0){
                binding.buttonPadDeleteCancel.text = "CANCEL"
                binding.textViewPasswordDisplay.text = ""
            }else{
                binding.buttonPadDeleteCancel.text = "DELETE"
                binding.textViewPasswordDisplay.text = "*".repeat(it)
            }
        })
    }

    private fun setupOnClickListeners(){
        binding.buttonPad0.setOnClickListener {
            viewModel.add('0')
        }
        binding.buttonPad1.setOnClickListener {
            viewModel.add('1')
        }
        binding.buttonPad2.setOnClickListener {
            viewModel.add('2')
        }
        binding.buttonPad3.setOnClickListener {
            viewModel.add('3')
        }
        binding.buttonPad4.setOnClickListener {
            viewModel.add('4')
        }
        binding.buttonPad5.setOnClickListener {
            viewModel.add('5')
        }
        binding.buttonPad6.setOnClickListener {
            viewModel.add('6')
        }
        binding.buttonPad7.setOnClickListener {
            viewModel.add('7')
        }
        binding.buttonPad8.setOnClickListener {
            viewModel.add('8')
        }
        binding.buttonPad9.setOnClickListener {
            viewModel.add('9')
        }
        binding.buttonPadDeleteCancel.setOnClickListener {
            viewModel.deleteOrCancel()
        }
        binding.buttonPadEnter.setOnClickListener {
            viewModel.submit()
        }
    }

    fun cancelRequest(){
        activity?.finish()
    }

    fun completeRequest(){

    }

}
