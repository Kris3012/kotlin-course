package ru.stimmax.lessons.lesson16.homework

//4. Перегрузка методов
//
//Класс “Корзина товаров”: содержит поле словаря из ID товаров и их количества.
//Базовый метод addToCart(itemId) добавляет одну единицу товара к уже существующим в корзине.
//Выполнить перегрузку addToCart который:
//Принимает два аргумента (itemId и количество amount)
//Принимает словарь из id и количества и добавляет всё в корзину
//Принимает список из id (добавляет по одной единице).
//Учесть, что если товар уже есть в корзине, нужно увеличить его количество, если нет - добавить.
//Попробуй создать корзину и положить в неё товар разными способами, потом распечатать корзину в консоль.
//Переопредели у корзины метод toString для красивого форматирования содержимого таблицы, включая итоговое количество артикулов и общее количество всего товара в корзине.

class OverridingCart {
}


class Cart(val cartMap: MutableMap<Int, Int>) {
    fun addToCart(itemId: Int) {
        if (cartMap.contains(itemId)) {
            cartMap[itemId] = (cartMap[itemId] ?: 0) + 1
        } else {
            cartMap[itemId] = 1
        }

    }

    //Принимает два аргумента (itemId и количество amount)
    fun addToCart(itemId: Int, amount: Int) {
        if (cartMap.contains(itemId)) {
            cartMap[itemId] = (cartMap[itemId] ?: 0) + amount
        } else {
            cartMap[itemId] = amount
        }

    }

    //Принимает словарь из id и количества и добавляет всё в корзину
    fun addToCart(items: Map<Int, Int>) {
        items.forEach { (key, value) -> addToCart(key, value) }
    }

    //Принимает список из id (добавляет по одной единице).
    fun addToCart(items: List<Int>) {
        items.forEach { id -> addToCart(id) }
    }

    override fun toString(): String {
        var result = ""
        var cartSum = 0
        for ((id, amount) in cartMap) {
            result += "id: $id | Количество: $amount"
            cartSum += amount
        }
        result += "Товары: ${cartMap.size}| Количество: ${cartSum}"
        return result
    }
}


fun main() {
    val cart = Cart(mutableMapOf())
    cart.addToCart(10, 5)
    cart.addToCart(mapOf(40 to 2, 20 to 4))
    cart.addToCart(listOf(5, 15, 10, 3, 8))

    println(cart)
}