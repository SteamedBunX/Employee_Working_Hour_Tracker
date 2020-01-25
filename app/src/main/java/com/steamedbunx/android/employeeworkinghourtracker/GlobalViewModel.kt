package com.steamedbunx.android.employeeworkinghourtracker

import androidx.lifecycle.ViewModel

class GlobalViewModel : ViewModel() {
    var currentIntention:Intention = Intention.NON

    fun setDestination(destination: Intention){
        currentIntention = destination
    }
}

enum class Intention {
    NON, MANAGE_EMPLOYEE, CHECK_IN, CHECK_OUT
}