package com.steamedbunx.android.employeeworkinghourtracker.ui.landing

import androidx.lifecycle.*
import com.steamedbunx.android.employeeworkinghourtracker.util.Clock
import java.util.*

class LandingViewModel : ViewModel() {
    var currentTime = Date()

    val clock = Clock()
    private val _currentTimeString:MutableLiveData<String> = MutableLiveData<String>()
    val currentTimeString:LiveData<String>
        get() = _currentTimeString

    init{
        initClock()
        startTimer()
    }


    fun initClock(){
        clock.setListener(
            object:Clock.OnTickListener{
                override fun onTick(timeString: String) {
                    _currentTimeString.value = timeString
                }
            })
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun startTimer(){
        clock.reset()
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun stopTimer(){
        clock.stop()
    }



}
