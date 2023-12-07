package data

import com.google.gson.Gson

class Event(internal var when_year:Int,
            internal var when_month:Int,
            internal var when_day:Int,
            internal var when_hour:Int,
            internal var when_minute:Int,
            internal var when_second:Int,
            internal var type: String,
            internal var title: String,
            internal var content: String
) {
    // Essential Property:
    /*
    internal var when_year:Int
    internal var when_month:Int
    internal var when_day:Int
    internal var when_hour:Int
    internal var when_minute:Int
    internal var when_second:Int
    var type: String
    var title: String
    var content: String



    // Essential Function:
    constructor(year:Int, month:Int, day:Int, hour: Int, minute:Int, second: Int){
        when_year = year
        when_month = month
        when_day = day
        when_hour = hour
        when_minute = minute
        when_second = second
    }
     */


    fun GetWhen(): Array<Int> = arrayOf(when_year, when_month, when_day, when_hour, when_minute, when_second)
    fun SetWhen(year:Int, month:Int, day:Int, hour: Int, minute:Int, second: Int){
        when_year = year
        when_month = month
        when_day = day
        when_hour = hour
        when_minute = minute
        when_second = second
    }
    fun toText():String{
        return "${when_year}.${when_month}.${when_day}.${when_hour}.${when_minute}.${when_second}"
    }

    fun toJSON(): String {
        val gson = Gson()
        return gson.toJson(this)
    }
}
