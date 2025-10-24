package ru.stimmax.lessons.lesson14.homework
//4. Покупка: продукт. Создайте дата класс для продукта, который будет представлять продукт в магазине.
// У него должны быть свойства “название”, “цена”, “количество”.

data class Grocery(val name: String, val price: Double, var quantity: Int)

//quantity - количество упаковок
fun main() {
    val product = Grocery("Молоко", 80.0, 600)
    println(product)
}