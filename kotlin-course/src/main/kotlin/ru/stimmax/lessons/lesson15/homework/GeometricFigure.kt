package ru.stimmax.lessons.lesson15.homework

//Геометрические Фигуры
//Базовый класс: Геометрическая Фигура
//Производные классы: Многоугольник, Круг
//Дополнительное разветвление для Многоугольник: Треугольник, Четырехугольник

open class GeometricFigure (
    val figureName: String)

{
}

open class Polygon(
    figureName: String,
    val numberOfAngles: Int,
    val numberOfVertices:Int // количество вершин
): GeometricFigure(figureName)
{

}
class Circle(
    figureName: String,
    val radius: Double
): GeometricFigure(figureName)

class Triangle(
    figureName: String,
    numberOfAngles: Int,
    numberOfVertices: Int,
    val base: Double,
    val height: Double
): Polygon(figureName,3,numberOfVertices)
{

}
class Quadrilateral(
    figureName: String,
    numberOfAngles: Int,
    numberOfVertices: Int,
    val lenght: Double,
    val weight: Double
): Polygon(figureName, numberOfAngles, numberOfVertices)
{

}