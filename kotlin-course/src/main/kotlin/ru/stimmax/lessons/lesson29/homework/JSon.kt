package ru.stimmax.lessons.lesson29.homework

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import ru.stimmax.lessons.lesson25.homework.employee
import java.io.File
import kotlin.io.writeText

// Задание 1
//Создай дата класс сотрудника компании Employee, содержащий:
//имя
//статус трудоустройства (булево)
//дата рождения (строка)
//должность CharacterTypes
//список подчинённых с типом Employee


enum class CharacterTypes {
    CTO,
    UX_UI,
    CRM,
    FRONTEND_DEV,
    TEAM_LEAD,
    BACKEND_DEV,
    PM,
    SYSADMIN,
    QA
}

data class Employee(
    val name: String,
    val isEmployed: Boolean,
    val dateOfBirth: String,
    val jobTitle: CharacterTypes,
    val employees: List<Employee>?
)

// Задание 2
//Создай объекты рабочей группы так, чтобы у CTO был PM и CRM, у PM было два тим-лида (на фронт и бэк)
// и у каждого было по группе сотрудников подходящего для его стека профиля.

// создаём снизу вверх

val frontendDev1 = Employee(
    name = "Alice",
    isEmployed = true,
    dateOfBirth = "1996-03-12",
    jobTitle = CharacterTypes.FRONTEND_DEV,
    employees = null
)

val backendDev1 = Employee(
    name = "Bob",
    isEmployed = true,
    dateOfBirth = "1994-07-21",
    jobTitle = CharacterTypes.BACKEND_DEV,
    employees = null
)

val frontendTeamLead = Employee(
    name = "Carol",
    isEmployed = true,
    dateOfBirth = "1990-05-10",
    jobTitle = CharacterTypes.TEAM_LEAD,
    employees = listOf(frontendDev1)
)

val backendTeamLead = Employee(
    name = "Dave",
    isEmployed = true,
    dateOfBirth = "1989-11-02",
    jobTitle = CharacterTypes.TEAM_LEAD,
    employees = listOf(backendDev1)
)

val pm = Employee(
    name = "Alex",
    isEmployed = true,
    dateOfBirth = "1988-01-18",
    jobTitle = CharacterTypes.PM,
    employees = listOf(frontendTeamLead, backendTeamLead)
)

val crm = Employee(
    name = "Frank",
    isEmployed = true,
    dateOfBirth = "1992-09-30",
    jobTitle = CharacterTypes.CRM,
    employees = null
)

val cto = Employee(
    name = "Grace",
    isEmployed = true,
    dateOfBirth = "1985-04-04",
    jobTitle = CharacterTypes.CTO,
    employees = listOf(pm, crm)
)

// Задание 3
//Создай функцию в которой:
//сериализуй CTO в текст с настройкой prettyPrinting
//текст запиши в файл в корне проекта.

fun task3(cto: Employee) {
    val gson = GsonBuilder()
        .setPrettyPrinting()
        .create()
    val json = gson.toJson(cto)
    val file = File("kotlin-course/lesson29.json")
    file.parentFile.mkdirs()
    file.writeText(json)
}

// Задание 4
//Создай функцию в которой:
    //прочитай текст из файла
    //десериализуй его в объект класса Employee
    //распечатай в консоль

fun task4 () {
    val gson = Gson()
    val json = File ("kotlin-course/lesson29.json").readText()
    val employee = gson.fromJson(json, Employee::class.java)
    println(employee)
}

fun main() {
    task3(cto)
}



