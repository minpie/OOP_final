package data

class Event {
    // Essential Property:
    private var when_year:Int
    private var when_month:Int
    private var when_day:Int
    private var when_hour:Int
    private var when_minute:Int
    private var when_second:Int

    // Essential Function:
    constructor(year:Int, month:Int, day:Int, hour: Int, minute:Int, second: Int){
        when_year = year
        when_month = month
        when_day = day
        when_hour = hour
        when_minute = minute
        when_second = second
    }
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
}