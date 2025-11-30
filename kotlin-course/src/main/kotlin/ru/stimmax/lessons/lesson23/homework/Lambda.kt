package ru.stimmax.lessons.lesson23.homework

class Lambda {
}

// Задача 1 Создай функцию, которая принимает список чисел и возвращает среднее арифметическое всех чётных чисел этого списка.
// С помощью require проверь, что список не пустой.

fun task1(list: List<Int>): Int {
    require(list.isNotEmpty()) { "Список не должен быть пустым" }
    val evenList = list.filter { it % 2 == 0 }
    val sum = evenList.sum()
    require(evenList.isNotEmpty()) { "Нет чётных чисел" }
    return sum / evenList.size
}

// 1 Создай аналогичную анонимную функцию.
val task1 = fun(list: List<Int>): Int {
    require(list.isNotEmpty()) { "Список не должен быть пустым" }
    val evenList = list.filter { it % 2 == 0 }
    val sum = evenList.sum()
    require(evenList.isNotEmpty()) { "Нет чётных чисел" }
    return sum / evenList.size
}

// 2 Создай аналогичное лямбда выражение с указанием типа.
val task1Lambda: (List<Int>) -> Int = {     // убираем инфу про аргумент, вместо его названия можно писать it
    require(it.isNotEmpty()) { "Список не должен быть пустым" }
    val evenList = it.filter { number -> number % 2 == 0 } // дали название переменной (number), чтобы не путаться
    val sum = evenList.sum()
    require(evenList.isNotEmpty()) { "Нет чётных чисел" }
    sum / evenList.size
}

// 3 Создай лямбда выражение без указания типа.
val task1LambdaNoType = { list: List<Int> ->  // тут надо указывать аргумент и его тип
    require(list.isNotEmpty()) { "Список не должен быть пустым" }
    val evenList = list.filter { it % 2 == 0 }
    val sum = evenList.sum()
    require(evenList.isNotEmpty()) { "Нет чётных чисел" }
    sum / evenList.size
}


// Задача 2 Создай функцию, которая принимает большое число и возвращает сумму цифр этого числа.
// Сделай проверку, что входящее число больше нуля. Подсказка: для парсинга символа в число можно использовать функцию digitToInt()
fun task2(arg: Long): Int {
    require(arg > 0) { "Число должно быть больше 0" }
    val numbers = arg.toString().map { it -> it.digitToInt() }
    var sum = 0
    for (digit in numbers) {
        sum += digit
    }
    return sum
}

// 1 Создай аналогичную анонимную функцию.
val task2: (Long) -> Int = {
    require(it > 0) { "Число должно быть больше 0" }
    val numbers = it.toString().map { digit -> digit.digitToInt() }
    var sum = 0
    for (digit in numbers) {
        sum += digit
    }
    sum
}

// 2 Создай аналогичное лямбда выражение с указанием типа.
val task2Lambda = fun(arg: Long): Int {
    require(arg > 0) { "Число должно быть больше 0" }
    val numbers = arg.toString().map { it -> it.digitToInt() }
    var sum = 0
    for (digit in numbers) {
        sum += digit
    }
    return sum
}

// 3 Создай лямбда выражение без указания типа.
val task2LambdaNoType = { arg: Long ->

        require(arg > 0) { "Число должно быть больше 0" }
        val numbers = arg.toString().map { it -> it.digitToInt() }
        var sum = 0
        for (digit in numbers) {
            sum += digit
        }
        sum
    }

// Задача 3. Создай функцию-расширение списка чисел, которая будет возвращать множество дубликатов чисел (встречающихся в списке более одного раза).
fun List<Int>.task3(): Set<Int> {
    return this
        .filter { element -> this.count { it == element } > 1 }
        .toSet()

}

//1 Создай аналогичную анонимную функцию.
val task3: (List<Int>) -> Set<Int> = { list ->
    list
        .filter { element -> list.count { it == element } > 1 }
        .toSet()
}

//2 Создай аналогичное лямбда выражение с указанием типа.
val task3Lambda = fun (list: List<Int>) : Set<Int> {
    return list
        .filter { element -> list.count { it == element } > 1 }
        .toSet()
}


fun main() {
// пункт 4 к Задаче 1. Проверь, что лямбда выражение работает правильно с помощью нескольких наборов данных (в том числе пустого).

    // четные числа
    println(task1LambdaNoType(listOf(2, 4, 6)))

    // нечетные числа
    try {
        println(task1LambdaNoType(listOf(1, 3, 5)))
    } catch (e: IllegalArgumentException) {
        println("Ошибка IllegalArgumentException: в списке не должны быть только нечетные числа")
    }

    // пустой список
    try {
        println(task1LambdaNoType(emptyList()))
    } catch (e: IllegalArgumentException) {
        println("Ошибка IllegalArgumentException: список не может быть пустым")
    }

// пункт 4 к Задаче 2. Проверь, что лямбда выражение работает правильно с помощью нескольких наборов данных

    try {
       println(task2LambdaNoType(0))
    } catch (e: IllegalArgumentException) {
        println("Число должно быть больше 0")
    }
        // число меньше 0
    try {
        println(task2LambdaNoType(-1))
    } catch (e: IllegalArgumentException) {
        println("Число должно быть больше 0")
    }

    println(task2LambdaNoType(8))

    println(task2LambdaNoType(4445456112L))

// пункт 3 к Задаче 3. Проверь, что лямбда выражение работает правильно с помощью нескольких наборов данных.

    //есть повторы
    println(task3Lambda(listOf(1, 2, 3, 3, 3, 4, 5, 6, 6)))
    //нет повторов
    println(task3Lambda(listOf(1, 2, 3, 4)))
    //только повторы
    println(task3Lambda(listOf(7, 7, 7, 7)))

}
