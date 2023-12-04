package utils
fun IsLeapYear(year:Int):Boolean{
    if(year % 400 == 0)
        return true
    else if((year % 4 == 0) && (year % 100 != 0))
        return true
    return false
}



fun GetLastDayOfMonth(year:Int, month:Int): Int{
    val result:Int  =
    when(month){
        1, 3, 5, 7, 8, 10, 12 -> 31
        4, 6, 9, 11 -> 30
        2 ->{
            if(IsLeapYear(year)){
                29
            }else{
                28
            }
        }
        else -> 0
    }
    return result
}

fun GetPassedDays(year:Int, month:Int, day:Int):Int{
    var days:Int = 0
    for(mnt in 1 until month){
        days += GetLastDayOfMonth(year, mnt)
    }
    days += day
    return days
}

fun GetWeekNum(year:Int, month:Int, day:Int):Int{
    var days:Int = 0
    for(y in 1 until year){
        for(m in 1 until 13){
            days += GetLastDayOfMonth(y, m)
        }
    }
    days += GetPassedDays(year, month, day)
    return ((days % 7) +1)% 7
}

fun GetNumToWeekStr(num:Int):String{
    val rtn:String = when(num){
        0 -> "SUN"
        1 -> "MON" // 월요일
        2 -> "TUE"
        3 -> "WED"
        4 -> "THU"
        5 -> "FRI"
        6 -> "SAT"

        else -> "ERR"
    }
    return rtn
}