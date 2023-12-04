package data

class Event {
    // Essential Property:
    private var when_hour:Int
    private var when_minute:Int
    private var when_second:Int

    // Essential Function:
    constructor(hour: Int, minute:Int, second: Int){
        when_hour = hour
        when_minute = minute
        when_second = second
    }
    fun GetWhen(): Array<Int> = arrayOf(when_hour, when_minute, when_second)
    fun SetWhen(hour: Int, minute: Int, second: Int){
        when_hour = hour
        when_minute = minute
        when_second = second
    }
    fun toText():String{
        return "${when_hour}.${when_minute}.${when_second}"
    }
}