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
    }
    fun LoadCalendar(fname:String){

    }
    fun CheckEvent(){

    }
    fun AddEvent() {
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
    }
    fun EditEvent(){

    }
    fun DeleteEvent(){

    }
    fun ShowCalenderMonth(year:Int, month:Int):String{
        return current_calendar.PutCalendar(year, month)
    }
}