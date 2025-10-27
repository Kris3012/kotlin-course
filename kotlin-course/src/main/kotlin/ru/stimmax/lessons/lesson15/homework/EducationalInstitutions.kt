package ru.stimmax.lessons.lesson15.homework

//Базовый класс: Учебное Заведение
//Производные классы: Школа, Гимназия
//Дополнительное разветвление для Школы: Частная школа, Государственная школа

open class EducationalInstitutions (
    val studentsQuantity: Int,
    val teachersQuantity: Int
){

    open fun info(){
    println("Количество учителей: $teachersQuantity")
    println("Количество учеников: $studentsQuantity")
}

}
class Gymnasium(
    studentsQuantity: Int,
    teachersQuantity: Int,
    val accreditationLevel: String
): EducationalInstitutions(studentsQuantity,teachersQuantity)

open class School(
    studentsQuantity: Int,
    teachersQuantity: Int,
    val schoolNumber: Int
): EducationalInstitutions(studentsQuantity, teachersQuantity)

class PrivateSchool(
    studentsQuantity: Int,
    teachersQuantity: Int,
    schoolNumber: Int,
    val tuitionFee: Double //стоимость обучения
): School(studentsQuantity, teachersQuantity, schoolNumber){

}

class PublicSchool(
    studentsQuantity: Int,
    teachersQuantity: Int,
    schoolNumber: Int,
    val governmentFunding: Double // финансирование
): School(studentsQuantity, teachersQuantity, schoolNumber) {

}

fun main(){
    val privateSchool = PrivateSchool(120, 8, 7, 350.0)
    privateSchool.info()
}