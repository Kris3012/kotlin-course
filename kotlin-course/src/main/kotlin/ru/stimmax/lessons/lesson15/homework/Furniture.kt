package ru.stimmax.lessons.lesson15.homework

//Иерархия Мебели
//Базовый класс: Мебель
//Производные классы: Гостиная, Ванная
//Дополнительное разветвление для Гостиной: Диваны, Столики

open class Furniture(
    val cost: Double,
    val material: String
)
{
    fun info() {
        println("Материал: $material, Стоимость: $cost")
    }
    open class LivingRoom(
        cost: Double,
        material: String,
        val legsQuantity: Int
    ): Furniture(cost, material)

    class Bathroom(
        cost: Double,
        material: String,
        val isWaterproof:Boolean
    ): Furniture(cost, material)

    class Couches(
        cost: Double,
        material: String,
        legsQuantity: Int,
        val hasPillows:Boolean
    ): LivingRoom(cost,material,legsQuantity)

    class Tables(
        cost: Double,
        material: String,
        legsQuantity: Int,
        val tableType: String // журнальный, обеденный
    ): LivingRoom(cost,material,legsQuantity)
}
