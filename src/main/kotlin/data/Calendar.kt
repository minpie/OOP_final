package data

import java.util.Calendar

class Calendar {
    private var events:Collection<Event>

    constructor(){
        events = emptyList()
    }

    fun AddEvent(){

    }
    fun EditEvent(){

    }
    fun DeleteEvent(){

    }
    fun FindEvent(year:Int, month:Int, day:Int):ArrayList<Event>{
        var rtn: ArrayList<Event> = arrayListOf()
        for (evnt in events){
            val check_query = arrayOf(year, month, day)
            val dates = evnt.GetWhen()
            val check_target = arrayOf(dates[0], dates[1], dates[2])
            if(check_query.equals(check_target)){
                rtn.add(evnt)
            }
        }
        return rtn
    }
    fun FindEvent(year:Int, month:Int, day:Int, hour: Int, minute:Int, second: Int):Event?{
        var rtn: Event? = null
        for (evnt in events){
            val check_query = arrayOf(year, month, day, hour, minute, second)
            if(check_query.equals(evnt)){
                rtn = evnt
                break
            }
        }
        return rtn
    }

    fun PutCalendar(year:Int, month:Int):String{
        // Variable:
        var result:String = ""

        // 초기 연산:
        val firstDayOfWeek = 0 // 첫 날의 요일을 구함 (1: 일요일, 2: 월요일, ..., 7: 토요일) /TEST
        val lastDayOfMonth = 0 // 해당 월의 마지막 날짜를 구함 /TEST


        // 표 헤더 출력
        result += "일\t\t월\t\t화\t\t수\t\t목\t\t금\t\t토"

        // 첫 번째 주의 날짜까지의 빈 칸 출력
        for(i in 1 until firstDayOfWeek)
            result += "\t\t" // 각 날짜를 두 칸으로 늘림
        // 날짜 & 이벤트 개수 출력하기:
        for(day in 1..lastDayOfMonth){
            // 날짜 출력 (빈 날짜에는 빈 칸 출력)
            val eventCount = FindEvent(year, month, day).size // 해당 날짜의 이벤트 수 /TEST
            result += "${day}${if (eventCount > 0) "\t(${eventCount})" else "\t"}\t"
            // 줄바꿈 처리 (7일마다)
            if ((firstDayOfWeek + day - 1) % 7 == 0) {
                result += "\n"
            }
        }

        return result
    }

}