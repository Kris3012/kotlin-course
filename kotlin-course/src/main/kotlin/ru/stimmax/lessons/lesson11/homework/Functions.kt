package ru.stimmax.lessons.lesson11.homework

//Задачи на сигнатуру метода

//1. Не принимает аргументов и не возвращает значения.
fun task1(){

}

//2. Принимает два целых числа и возвращает их сумму.
fun task2(a:Int,b:Int):Int{
    return a+b
}

//3. Принимает строку и ничего не возвращает.
fun task3(arg:String){

}

//4. Принимает список целых чисел и возвращает среднее значение типа Double.
fun task4(arg:List<Int>):Double{
    var counter = 0
    for (i in arg){
        counter += i

    }
    return counter.toDouble() / arg.size
}

//5. Принимает nullable строку и возвращает её длину в виде nullable целого числа и доступна только в текущем файле.
private fun task5(arg:String?):Int?{
    return arg?.length
}

//6. Не принимает аргументов и возвращает nullable вещественное число.
fun task6():Double?{
    return null
}

//7. Принимает nullable список целых чисел, не возвращает значения и доступна только в текущем файле.
private fun task7(arg:List<Int>?){

}

//8. Принимает целое число и возвращает nullable строку.
fun task8(arg:Int):String?{
    return arg.toString()
}

//9. Не принимает аргументов и возвращает список nullable строк.
fun task9():List<String>?{
    return null
}

//10. Принимает nullable строку и nullable целое число и возвращает nullable булево значение.
fun task10(arg1:String?, arg2:Int?):Boolean?{
    return true
}

//Задачи на написание кода
//Напишите валидную сигнатуру метода, а так же рабочий код для задач.

//11. Напишите функцию multiplyByTwo, которая принимает целое число и возвращает его, умноженное на 2.
fun multiplyByTwo(arg:Int):Int{
    return arg*2
}

//12. Создайте функцию isEven, которая принимает целое число и возвращает true, если число чётное, и false в противном случае.
fun isEven(arg:Int):Boolean{
    return if (arg % 2 == 0) true else false
}

//13. Напишите функцию printNumbersUntil, которая принимает целое число n и выводит на экран числа от 1 до n. Если число n меньше 1, функция должна прекратить выполнение с помощью return без вывода сообщений.
fun printNumbersUntil(n:Int){
    if (n < 1) return
    for (i in 1..n)
        println(i)
}

//14. Создайте функцию findFirstNegative, которая принимает список целых чисел и возвращает первое отрицательное число в списке. Если отрицательных чисел нет, функция должна вернуть null.
    //пока пропускаю

//15. Напишите функцию processList, которая принимает список строк. Функция должна проходить по списку и выводить каждую строку. Если встречается null значение, функция должна прекратить выполнение с помощью return без возврата значения.
fun processList(list:List<String?>){
 for (string in list)
     if (string == null) return else println(string)
}