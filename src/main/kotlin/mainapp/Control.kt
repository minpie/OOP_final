package mainapp

import utils.*
import data.Calendar
import java.io.File
import com.google.gson.*
import data.Event

class Control {
    lateinit var current_calendar:Calendar

    constructor(){
        current_calendar = Calendar()
    }
    constructor(fname:String){
        LoadCalendar(fname)
    }
    fun SaveCalendar(fname: String) {
        val gson = Gson()
        File(fname).writeText(gson.toJson(current_calendar))
        /*

        // 실제로 저장할 이벤트 리스트
        val eventsToSave = current_calendar.getEvents().map {
            val jsonEvent = JsonObject()
            jsonEvent.addProperty("when_year", it.when_year)
            jsonEvent.addProperty("when_month", it.when_month)
            jsonEvent.addProperty("when_day", it.when_day)
            jsonEvent.addProperty("when_hour", it.when_hour)
            jsonEvent.addProperty("when_minute", it.when_minute)
            jsonEvent.addProperty("when_second", it.when_second)
            jsonEvent.addProperty("type", it.type)
            jsonEvent.addProperty("title", it.title)
            jsonEvent.addProperty("content", it.content)
            jsonEvent
        }

        // 각 JSON 이벤트를 파일에 추가
        eventsToSave.forEach { event ->
            val jsonString = gson.toJson(event)
            File(fname).appendText("$jsonString\n")
        }

        println("캘린더가 성공적으로 저장되었습니다.")

         */

    }
    fun LoadCalendar(fname:String){
        if(!File(fname).exists()){
            return
        }
        val jsonString = File(fname).readText()
        current_calendar = Gson().fromJson(jsonString, Calendar::class.java)




        /*
        print("날짜를 입력하세요 (yyyy/mm/dd) : ")
        val userInput = readLine()?.trim()

        if (!userInput.isNullOrBlank()) {
            val (year, month, day) = userInput.split("/").takeIf { it.size == 3 } ?: run {
                println("잘못된 입력입니다.")
                return
            }

            val events = jsonString.split("\n")

            println("\n")
            println("$userInput 의 이벤트 정보")
            print("-------------------------------------------------------- \n\n")

            val matchingEvents = events.filterIndexed { index, eventData ->
                if (index % 2 == 0) {
                    val eventInfo = parseEventInfo(eventData)

                    val eventYear = eventInfo.date.substringBefore("/").toIntOrNull()
                    val eventMonth = eventInfo.date.substringAfter("/").substringBefore("/").toIntOrNull()
                    val eventDay = eventInfo.date.substringAfterLast("/").toIntOrNull()

                    val isMatchingDate = year.toInt() == eventYear && month.toInt() == eventMonth && day.toInt() == eventDay


                    if (isMatchingDate) {

                        // 필터링된 데이터가 원본 데이터의 N번째 일때, N번째 데이터 출력
                        val currentEventData = events[index]
                        val currentEventInfo = parseEventInfo(currentEventData)
                        println("[이벤트 시작 날짜] : ${currentEventInfo.date}")
                        println("[이벤트 종료 날짜] : ${currentEventInfo.date}")
                        println("[이벤트 제목] : ${currentEventInfo.title}")
                        println("[이벤트 내용] : ${currentEventInfo.content} \n")

                        // N+1 번째 데이터 출력
                        if (index + 1 < events.size) {
                            val nextEventData = events[index + 1]
                            val nextEventInfo = parseEventInfo(nextEventData)
                            println("[이벤트 시작 날짜] : ${nextEventInfo.date}")
                            println("[이벤트 종료 날짜] : ${nextEventInfo.date}")
                            println("[이벤트 제목] : ${nextEventInfo.title}")
                            println("[이벤트 내용] : ${nextEventInfo.content}")
                            print("-------------------------------------------------------- \n")
                        } else {
                            println("다음 데이터가 없습니다.")
                        }
                    }
                    isMatchingDate
                } else {
                    false
                }
            }
        }
        */
    }
    fun CheckEvent(){

    }
    fun AddEvent(year:Int, month:Int, day:Int, hour: Int, minute:Int, second: Int, type:String, title:String, content:String) {
        current_calendar.AddEvent(year, month, day, hour, minute, second, type, title, content)

        /*
        println("이벤트를 추가합니다.")
        val startEvent = createEventFromUserInput("시작")
        println("시작 이벤트: $startEvent")
        val endEvent = createEventFromUserInput("종료")
        println("종료 이벤트: $endEvent")


        current_calendar.AddEvent(
            startEvent.when_year, startEvent.when_month, startEvent.when_day,
            startEvent.when_hour, startEvent.when_minute, startEvent.when_second,
            startEvent.type, startEvent.title, startEvent.content
        )

        current_calendar.AddEvent(
            endEvent.when_year, endEvent.when_month, endEvent.when_day,
            endEvent.when_hour, endEvent.when_minute, endEvent.when_second,
            endEvent.type, endEvent.title, endEvent.content
        )

        println("이벤트가 추가되었습니다.")

        // 이벤트 정보를 JSON 형식으로 파일에 저장
        val gson = Gson()
        val startJsonString = gson.toJson(startEvent)
        val endJsonString = gson.toJson(endEvent)
        File("event.txt").appendText("$startJsonString\n$endJsonString\n")
        println("이벤트가 성공적으로 저장되었습니다.")

         */
    }
    fun EditEvent(){

    }
    fun DeleteEvent(){

    }
    fun ShowCalenderMonth(year:Int, month:Int):String{
        return current_calendar.PutCalendar(year, month)
    }
}