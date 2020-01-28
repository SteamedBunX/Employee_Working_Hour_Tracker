package com.steamedbunx.android.employeeworkinghourtracker.ui.pinpad

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.steamedbunx.android.employeeworkinghourtracker.CHECK_IN
import com.steamedbunx.android.employeeworkinghourtracker.CHECK_OUT
import com.steamedbunx.android.employeeworkinghourtracker.MANAGE_EMPLOYEE

class PinPadViewModel : ViewModel() {
    private val _currentPinDigit = MutableLiveData<Int>(0)
    val currentPinDigit:LiveData<Int>
        get() = _currentPinDigit

    private val _requestComplete = MutableLiveData<Boolean>(false)
    val requestComplete:LiveData<Boolean>
        get() = _requestComplete

    private val _requestCancelled = MutableLiveData<Boolean>(false)
    val requestCancelled
        get() = _requestCancelled

    var requestMode = 0
    var currentPin = arrayListOf<Char>()

    fun setMode(requestCode:Int){
        requestMode = requestCode
    }

    fun submit(){
        when(requestMode){
            CHECK_IN->1
            CHECK_OUT->1
            MANAGE_EMPLOYEE->
                if(String(currentPin.toCharArray()) == "1124"){
                    _requestComplete.value = true
                }
        }
    }

    fun deleteOrCancel(){
        val lastIndex = currentPin.count() - 1
        if(lastIndex > -1){
            currentPin.removeAt(lastIndex)
            _currentPinDigit.value = currentPin.count()
        }else{
            _requestCancelled.value = true
        }
    }

    fun add(newDigit:Char){
        if(currentPin.count() < 8){
            currentPin.add(newDigit)
            _currentPinDigit.value = currentPin.count()
        }
    }
}
