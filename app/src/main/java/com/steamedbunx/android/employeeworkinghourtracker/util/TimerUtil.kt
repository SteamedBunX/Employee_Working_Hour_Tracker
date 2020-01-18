package com.steamedbunx.android.employeeworkinghourtracker.util


// formated hh:mm
class TimerUtil private constructor(){

    companion object {
        private val instance = TimerUtil()

        fun getInstance(): TimerUtil {
            return instance
        }
    }

    fun getTimerString(hour: Byte, min: Byte): String {
        val result = StringBuilder()
        if (hour >= 10) {
            result.append(hour).append(":")
        } else {
            result.append("0${hour}:")
        }
        if (min >= 10) {
            result.append(min)
        } else {
            result.append("0${min}")
        }
        return result.toString()
    }
}