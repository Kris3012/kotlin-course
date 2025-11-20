package ru.stimmax.lessons.lesson21.homework

class Typization {
}
//Задача 1
//Напишите функцию analyzeDataType, принимающую параметр типа Any. Функция должна определить тип аргумента и вывести соответствующее сообщение:
//Для строки: "Это строка: [значение]".
//Для любого числа: "Это число: [значение]".
//Для списка: "Это список, количество элементов: [количество]".
//Для словаря: "Это словарь, количество пар: [количество]".
//Для остальных типов: "Неизвестный тип данных".
//Используйте оператор is для проверки типов.

fun analyzeDataType(param: Any) {
    when (param) {
        is String -> println("Это строка: $param")
        is Number -> println("Это число: $param")
        is List<*> -> println("Это список, количество элементов: ${param.size}")
        is Map<*, *> -> println("Это словарь, количество пар: ${param.size}")
        else -> println("Неизвестный тип данных")
    }
}

//Задача 2
//Создайте функцию safeCastToList, принимающую параметр типа Any и возвращающую размер списка, если аргумент можно безопасно привести к типу List.
//В случае неудачного приведения функция должна возвращать -1. Используйте as? для безопасного приведения типа.

fun safeCastToList(param2: Any): Int {
    return (param2 as? List<*>)?.size ?: -1
}

//Задача 3
//Создайте функцию getStringLengthOrZero, которая принимает параметр типа Any? и возвращает длину строки, если аргумент можно привести к типу String.
//В случае, если аргумент равен null или не является строкой, функция должна возвращать 0.

fun getStringLengthOrZero(param3: Any?): Int {
    return (param3 as? String)?.length ?: 0

}


//Задача 4
//Создайте функцию-расширение класса Any toSquare. Функция гарантированно вызывается у числа (в виде числа или строки, например 4 или 4.2 или “4.2”) и должна вернуть квадрат этого числа.
//Если придёт число, его нужно возвести в квадрат, если придёт строка, то его нужно преобразовать в число через функцию toDouble() и возвести в квадрат.

fun Any.toSquare(): Double {
    val arg = when (this) {
    is Number -> this.toDouble()
    is String -> this.toDouble()
    else -> {
        println("Неверный тип")
        return 0.0     // чтобы выйти из функции
    }
    }
        return arg * arg
}


//Задача 5
//Напишите функцию sumIntOrDoubleValues, которая принимает список элементов типа Any и возвращает сумму всех целочисленных (Int) и вещественных (Double) значений в списке.
//Все остальные типы должны быть проигнорированы.

fun sumIntOrDoubleValues(elementsList: List<Any>): Double {
    var counter = 0.0
    for (element in elementsList) {
        when (element) {
            is Int -> counter += element.toDouble()  // привели к одному типу
            is Double -> counter += element
            else -> println("Это не те дроиды, которых вы ищите")
        }
    }
    return counter
}

//Задача 6
//Создайте функцию tryCastToListAndPrint, которая принимает параметр типа Any и пытается привести его к типу List<*>.
//Если приведение успешно, функция должна напечатать все строки из списка, если элемент не является строкой то вывести предупреждение об этом.
//Если приведение неудачно, должно быть выведено сообщение об ошибке, не прерывая выполнение программы.

fun tryCastToListAndPrint(param4: Any) {
    if (param4 is List<*>) {
        for (element in param4) {
            when (element){
                is String -> println(element)
                    else -> println("Warning: Это не строка")
            }
        }
    } else {
        println("Ошибка: это не список")
    }
}

