package com.steamedbunx.android.employeeworkinghourtracker.util

import android.os.Handler
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import java.util.*

class Clock() : LifecycleObserver{

    private val utils = TimerUtil.getInstance()

    // region constants
    val MAX_MIN:Byte = 60
    val MAX_HOUR:Byte = 24
    val MILSEC_IN_MINUTE = 60000L
    // endregion

    // region var
    var hour:Byte = 0
    var min:Byte = 0
    // endregion

    // region runnable
    val handler = Handler()
    private val runnable: Runnable = object : Runnable {
        override fun run() {
            tick()
            handler.postDelayed(this, 60000)
        }
    }
    // endregion

    var onTickListener: OnTickListener? = null

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun start(){
        val currentTime = Calendar.getInstance()
        currentTime.time = Date()
        hour = currentTime.get(Calendar.HOUR_OF_DAY).toByte()
        min = currentTime.get(Calendar.MINUTE).toByte()
        var milSecTillMinuteChange:Long =
            MILSEC_IN_MINUTE
            - currentTime.get(Calendar.SECOND)*1000
            - currentTime.get(Calendar.MILLISECOND)
        onTickListener?.onTick(utils.getTimerString(hour,min))
        handler.postDelayed(runnable, milSecTillMinuteChange)
        onTickListener?.onTick(utils.getTimerString(hour, min))
    }

    fun tick(){
        min++
        if(min >= MAX_MIN){
            min = 0
            hour++
            if(hour >= MAX_HOUR)
            {
                hour = 0
            }
        }

        onTickListener?.onTick(utils.getTimerString(hour, min))
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun stop(){
        handler.removeCallbacks(runnable)
    }

    interface OnTickListener {
        fun onTick(timeString: String)
    }

    fun setListener(listener:OnTickListener){
        onTickListener = listener
    }
}
