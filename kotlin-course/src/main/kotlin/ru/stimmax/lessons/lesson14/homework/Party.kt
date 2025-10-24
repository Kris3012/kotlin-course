package ru.stimmax.lessons.lesson14.homework

//1. Событие: вечеринка. Создайте класс Party, который описывает вечеринку.
// У него должны быть свойства location (String) и attendees (Int). Добавьте метод details(), который выводит информацию о месте проведения и количестве гостей.

class Party(var location:String, var attendees:Int) {

    fun details(){
        println("$location, $attendees")
    }

}

fun main(){
    val party = Party("Some details", 20)
    party.details()
}