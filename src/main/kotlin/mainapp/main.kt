package mainapp


var isRunning = true


fun main(){
    while(isRunning){
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
            }
            3 -> {
            }
            4 -> {
            }
        }
    }
/*
            2 -> {
                // 달력 조회
                print("년도를 입력하세요: ")
                val year = readLine()?.trim()?.toInt() ?: return

                print("월을 입력하세요: ")
                val month = readLine()?.trim()?.toInt() ?: return

                // 이벤트 날짜 목록 생성 (임의의 날짜로 예시)
                val startDates = readStartDatesFromFile()

                printCalendar(year, month, startDates)
            }
            3 -> {
                // 이벤트 추가
                addEvent()
            }
            4 -> {
                // 이벤트 조회
                println("이벤트 조회를 시작합니다.")

                // 조회할 날짜 입력 받기
                print("조회할 날짜를 입력하세요 (yyyy/MM/dd): ")
                val queryDateString = readLine()?.trim() ?: continue
                val queryDate = parseDateString(queryDateString)

                // 이벤트 조회 및 출력
                searchAndPrintEvents(queryDate)
            }

            else -> {
                println("잘못된 메뉴 번호입니다. 다시 선택해주세요.")
            }
        }

        // 메뉴 처리 이후 줄바꿈을 포함한 메뉴 재출력
        println()
    }

 */
}