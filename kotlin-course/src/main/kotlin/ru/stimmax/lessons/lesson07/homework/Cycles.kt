package ru.stimmax.lessons.lesson07.homework


//Задания для цикла for
//Прямой диапазон
// 1. Напишите цикл for, который выводит числа от 1 до 5.
fun main() {
    for (i in 1..5) {
        println(i)
    }

// 2. Напишите цикл for, который выводит четные числа от 1 до 10.
    for (i in 1..10) {
        if (i % 2 == 0)
            println(i)
    }

//Обратный диапазон
// 3. Создайте цикл for, который выводит числа от 5 до 1.
    for (i in 5 downTo 1) {
        println(i)
    }

//4. Создайте цикл for, который выводит числа от 10 до 1, уменьшая их на 2.
    for (i in 10 downTo 1 step 2) {
        println(i)
    }

//С шагом (step)
//5. Используйте цикл for с шагом 2 для вывода чисел от 1 до 9.
    for (i in 1..10 step 2) {
        println(i)
    }

//6. Напишите цикл for, который выводит каждое третье число в диапазоне от 1 до 20.
    for (i in 1..20 step 3) {
        println(i)
    }
//Использование до (until)
//7. Создайте числовую переменную 'size'. Используйте цикл for с шагом 2 для вывода чисел от 3 до size не включая size.
    val size = 5
    for (i in 3 until size step 2) {
        println(i)
    }

//Задания для цикла while
//Цикл while
//8. Создайте цикл while, который выводит квадраты чисел от 1 до 5.
    var counter = 1
    while (counter <= 5) {
        var multiply = counter * counter
        println(multiply)
        counter++ // увеличиваем каждый раз на 1
    }
//9. Напишите цикл while, который уменьшает число от 10 до 5. После этого вывести результат в консоль
    var counter2 = 10
    while (counter2 > 5) {
        counter2--
    }
    println(counter2)


}
