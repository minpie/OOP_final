package mainapp

import utils.*
import data.Event
import java.util.*
import java.io.File
import com.google.gson.*


var isRunning = true


fun main() {
    var sess1: Control = Control()

    while (isRunning) {
        // 메뉴 출력
        print("메뉴 번호를 선택하세요 (1: 종료, 2: 달력조회, 3: 이벤트 추가, 4: 이벤트 조회): ")
        // 사용자 입력 받기
        val choice = readLine()?.trim()?.toIntOrNull() ?: continue
        // 메뉴 처리
        when (choice) {
            1 -> {
                println("프로그램을 종료합니다.")
                isRunning = false
            }

            2 -> {
                // 달력 조회
                print("년도를 입력하세요: ")
                val year = readLine()?.trim()?.toInt() ?: return

                print("월을 입력하세요: ")
                val month = readLine()?.trim()?.toInt() ?: return
                print(sess1.ShowCalenderMonth(year, month))
            }

            3 -> {
                println("이벤트를 추가합니다.")
                val startEvent = createEventFromUserInput("시작")
                val endEvent = createEventFromUserInput("종료")

                sess1.current_calendar.AddEvent(
                    startEvent.when_year, startEvent.when_month, startEvent.when_day,
                    startEvent.when_hour, startEvent.when_minute, startEvent.when_second,
                    startEvent.type, startEvent.title, startEvent.content
                )

                sess1.current_calendar.AddEvent(
                    endEvent.when_year, endEvent.when_month, endEvent.when_day,
                    endEvent.when_hour, endEvent.when_minute, endEvent.when_second,
                    endEvent.type, endEvent.title, endEvent.content
                )

                println("이벤트가 추가되었습니다.")
                sess1.SaveCalendar("event.txt")
            }

            4 -> {
                val filePath = "event.txt"

                val jsonString = File(filePath).readText()

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
            }
        }
    }
}


data class EventInfo(val date: String, val time: String, val title: String, val content: String)

fun parseEventInfo(eventString: String): EventInfo {
    val eventData = eventString.split(",")
    val eventDate = "${eventData.getOrNull(0)?.substringAfter(":")?.trim('"')}/${eventData.getOrNull(1)?.substringAfter(":")?.trim('"')}/${eventData.getOrNull(2)?.substringAfter(":")?.trim('"')}"

    // 시간 부분을 12:0:0에서 12:00:00으로 포맷팅
    val eventTimeList = (3 until 6).map { eventData.getOrNull(it)?.substringAfter(":")?.trim('"')?.padStart(2, '0') ?: "00" }
    val eventTime = eventTimeList.joinToString(":")

    val eventTitle = eventData.getOrNull(7)?.substringAfter(":")?.trim('"') ?: ""
    val eventContent = eventData.getOrNull(8)?.substringAfter(":")?.substringBeforeLast("\"")?.trim('"') ?: ""

    return EventInfo(eventDate, eventTime, eventTitle, eventContent)
}