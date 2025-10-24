package ru.stimmax.lessons.lesson14.homework
//6. Цель задания: Создать систему управления складским пространством с использованием классов "Стеллаж" и "Полка стеллажа".
//Класс Shelf (Полка Стеллажа)

//Характеристики:
//Вместимость полки (capacity): максимальная сумма букв всех названий предметов, которые могут быть размещены на полке.
//Список предметов (items): хранит названия предметов на полке.

//Методы:
//Добавление Предмета (addItem):
//Принимает название предмета.
//Проверяет, поместится ли предмет на полку, учитывая длину его названия и текущее заполнение полки.
//Возвращает true и добавляет предмет, если есть место. В противном случае возвращает false.

//Удаление Предмета (removeItem):
//Принимает название предмета.
//Удаляет предмет, если он найден на полке.
//Возвращает true, если предмет был удален, и false, если такой предмет не найден.

//Проверка Вместимости (canAccommodate):
//Принимает название предмета.
//Определяет, вместится ли предмет на полку.
//Возвращает true, если предмет вместится, и false, если места недостаточно.

//Проверка наличия предмета (containsItem):
//Принимает название предмета
//Возвращает true если такой предмет есть

//Получение списка предметов (getItems):
//Возвращает неизменяемый список предметов

class Shelf(val capacity:Int, private val items: MutableList<String>) {

    fun addItem(itemName:String):Boolean{
        val space = items.sumOf { it.length }
        if (itemName.length + space <= capacity){
            items.add(itemName)
            return true
        } else {
            return false
        }

    }
    fun removeItem(itemName:String):Boolean{
        if(items.contains(itemName)){
            items.remove(itemName)
            println("Предмет удален")
            return true
        } else {
            println("Предмет не найден")
            return false
        }
    }
    fun canAccommodate(itemName: String): Boolean{
        val space = items.sumOf { it.length }
        return itemName.length + space <= capacity

    }
    fun containsItem(itemName:String):Boolean{
        return items.contains(itemName)
    }
    fun getItems(): List<String>{
        return items.toList()
    }
}

fun main(){
    val shelf = Shelf(20, mutableListOf())
    println(shelf.addItem("Книга"))
    println(shelf.addItem("Копилка"))
    println(shelf.getItems())
}