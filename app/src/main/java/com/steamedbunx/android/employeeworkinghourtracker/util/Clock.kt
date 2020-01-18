package com.steamedbunx.android.employeeworkinghourtracker.util

import android.os.Handler
import java.util.*

class Clock{

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

    fun reset(){
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
        hour++
        if(min >= MAX_MIN){
            min = 0
        }
        if(hour >= MAX_HOUR)
        {
            hour = 0
        }
        onTickListener?.onTick(utils.getTimerString(hour, min))
    }

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
