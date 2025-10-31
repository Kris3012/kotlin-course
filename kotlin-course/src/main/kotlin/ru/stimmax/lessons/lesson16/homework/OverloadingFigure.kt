package ru.stimmax.lessons.lesson16.homework

import ru.stimmax.lessons.lesson08.homework.phrase1

//Переопределение методов
//2. Геометрические Фигуры и Их Площадь
//Абстрактный (базовый) класс: Shape с open методом area().
//Классы наследники: Circle, Square, Triangle.
//Метод area() возвращает 0.0.
//Переопределите метод area() в каждом классе-наследнике для расчета площади соответствующей фигуры.
//Подсказка: каждый класс должен иметь аргументы конструктора, позволяющие вычислить площадь (для круга это радиус, для квадрата это сторона, для треугольника это две стороны и угол между ними)
//Создай набор геометрических фигур и выведи в цикле их площадь

class OverloadingFigure {
}
abstract class Shape(){
    open fun area(): Double{
        return 0.0
    }
}

class Circle(
    val radius: Double
): Shape() {
    override fun area(): Double{
        return kotlin.math.PI * (radius * radius) // kotlin.math.PI - пришлось гуглить чтоб понять как записать формулу
    }
}

class Square(
    val side: Double
): Shape() {
    override fun area(): Double {
        return side * side
    }
}

class Triangle(
    val side1: Double,
    val side2: Double,
): Shape() {
    override fun area(): Double{
        return 0.5 * side1 * side2
    }
}

fun main() {
    val circle = Circle(3.0)
    val square = Square(4.0)
    val triangle = Triangle(5.0, 6.0)

    val figures: List<Shape> = listOf(circle, square, triangle)
    figures.forEach {
        it.area()
        println("Площадь фигуры: ${it.area()}")
    }
}