package mainapp

import data.Calendar

class Control {
    lateinit var current_calendar:Calendar

    constructor(){
        current_calendar = Calendar()
    }
    constructor(fname:String){
        LoadCalendar(fname)
    }
    fun SaveCalendar(fname:String){

    }
    fun LoadCalendar(fname:String){

    }
    fun CheckEvent(){

    }
    fun AddEvent(){

    }
    fun EditEvent(){

    }
    fun DeleteEvent(){

    }
    fun ShowCalenderMonth(year:Int, month:Int):String{
        return current_calendar.PutCalendar(year, month)
    }
}