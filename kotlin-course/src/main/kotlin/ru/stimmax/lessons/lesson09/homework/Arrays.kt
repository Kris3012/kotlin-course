package ru.stimmax.lessons.lesson09.homework

fun main() {
//Работа с массивами Array

//Создайте массив из 5 целых чисел и инициализируйте его значениями от 1 до 5.
    val taskArray1: Array<Int> = arrayOf(1, 2, 3, 4, 5)

//Создайте пустой массив строк размером 10 элементов.
    val taskArray2 = Array(10) { "" }

//Создайте массив из 5 элементов типа Double и заполните его значениями, являющимися удвоенным индексом элемента.
    val taskArray3 = DoubleArray(5) { it * 2.0 }

//Создайте массив из 5 элементов типа Int. Используйте цикл, чтобы присвоить каждому элементу значение, равное его индексу, умноженному на 3.
    val taskArray4 = IntArray(5)
    for (i in taskArray4.indices) {
        taskArray4[i] = i * 3
    }

//Создайте массив из 3 nullable строк. Инициализируйте его одним null значением и двумя строками.
    val taskArray5 = arrayOf<String?>(null, "Hello", "Kotlin")

//Создайте массив целых чисел и скопируйте его в новый массив в цикле.
    val taskArray6 = intArrayOf(1, 2, 3, 4, 5)
    val copy = IntArray(taskArray6.size)
    for (i in taskArray6.indices) {
        copy[i] = taskArray6[i]
    }
//Создайте два массива целых чисел одинаковой длины. Создайте третий массив, вычев значения одного из другого. Распечатайте полученные значения.
    val Array1: Array<Int> = arrayOf(20, 30, 40, 50)
    val Array2: Array<Int> = arrayOf(10, 5, 6, 10)
    val result = IntArray(Array1.size)
    for (i in Array1.indices) {
        result[i] = Array1[i] - Array2[i]
        println(result)
    }

//Создайте массив целых чисел. Найдите индекс элемента со значением 5. Если значения 5 нет в массиве, печатаем -1. Реши задачу через цикл while.
    val taskArray7 = intArrayOf(1, 3, 7, 5, 9)
    var index = 0
    var foundIndex = -1
    while (index < taskArray7.size) {
        if (taskArray7[index] == 5) {
            foundIndex = index
            break
        }
        index++
    }
    println(foundIndex)

//Создайте массив целых чисел. Используйте цикл для перебора массива и вывода каждого элемента в консоль. Напротив каждого элемента должно быть написано “чётное” или “нечётное”.
    val nums = intArrayOf(2, 5, 8, 11, 14)
    for (n in nums) {
        if (n % 2 == 0)
            println("$n — чётное")
        else
            println("$n — нечётное")
    }

//Создай функцию, которая принимает массив строк и строку для поиска. Функция должна находить в массиве элемент, в котором принятая строка является подстрокой (метод contains()). Распечатай найденный элемент.

    //пока не знаю

//Работа со списками List
//Создайте пустой неизменяемый список целых чисел.
    val taskList1: List<Int> = listOf(1, 6, 4, 6, 7)

//Создайте неизменяемый список строк, содержащий три элемента (например, "Hello", "World", "Kotlin").
    val taskList2: List<String> = listOf("Hello", "World", "Kotlin")

//Создайте изменяемый список целых чисел и инициализируйте его значениями от 1 до 5.
//Имея изменяемый список целых чисел, добавьте в него новые элементы (например, 6, 7, 8).
    val taskList3: MutableList<Int> = mutableListOf(1, 2, 3, 4, 5)
    taskList3.add(6)
    taskList3.add(7)
    taskList3.add(8)

//Имея изменяемый список строк, удалите из него определенный элемент (например, "World").
    val taskList4: MutableList<String> = mutableListOf("Hello", "World", "Kotlin")
    taskList3.removeAt(1)

//Создайте список целых чисел и используйте цикл для вывода каждого элемента на экран.
    val taskList5 = listOf(1, 2, 3, 4, 5)
    for (num in taskList5) {
        println(num)
    }

//Создайте список строк и получите из него второй элемент, используя его индекс.
    val taskList6 = listOf("Hello", "World", "Kotlin")
    val second = taskList6[1]
    println(second)

//Имея изменяемый список чисел, измените значение элемента на определенной позиции (например, замените элемент с индексом 2 на новое значение).
    val taskList7: MutableList<Int> = mutableListOf(1, 2, 3, 4, 5)
    taskList7[2] = 8

//Создайте два списка строк и объедините их в один новый список, содержащий элементы обоих списков. Реши задачу с помощью циклов.
    val list1 = listOf("a", "b", "c")
    val list2 = listOf("x", "y", "z")
    val combined = mutableListOf<String>()
    for (item in list1) {
        combined.add(item)
    }
    for (item in list2) {
        combined.add(item)
    }
    println(combined)

//Создайте список целых чисел и найдите в нем минимальный и максимальный элементы используя цикл.
    //Имея список целых чисел, создайте новый список, содержащий только четные числа из исходного списка используя цикл.
//пока не знаю


//Работа с Множествами Set
// Создайте пустое неизменяемое множество целых чисел.
    val taskSet1: Set<Int> = setOf()

// Создайте неизменяемое множество целых чисел, содержащее три различных элемента (например, 1, 2, 3).
    val taskSet2: Set<Int> = setOf(1,2,3)

// Создайте изменяемое множество строк и инициализируйте его несколькими значениями (например, "Kotlin", "Java", "Scala").
    // Имея изменяемое множество строк, добавьте в него новые элементы (например, "Swift", "Go").
    val taskSet3: MutableSet<String> = mutableSetOf("Kotlin", "Java", "Scala")
    taskSet3.add("Swift")
    taskSet3.add("Go")


// Имея изменяемое множество целых чисел, удалите из него определенный элемент (например, 2).
    val taskSet4: MutableSet<Int> = mutableSetOf(1, 2, 3)
    taskSet4.remove(2)

// Создайте множество целых чисел и используйте цикл для вывода каждого элемента на экран.
    val taskSet5: Set<Int> = setOf(5,6,7,8)
    for (number in taskSet5){
        println(number)
    }

// Создай функцию, которая принимает множество строк (set) и строку и проверяет, есть ли в множестве указанная строка. Нужно вернуть булево значение true если строка есть. Реши задачу через цикл.
    //пока не знаю
// Создайте множество строк и конвертируйте его в изменяемый список строк с использованием цикла.
    val taskSet8: Set<String> = setOf("a", "b", "c")
    val myList = mutableListOf<String>()
    for (item in taskSet8) {
        myList.add(item)
    }
}