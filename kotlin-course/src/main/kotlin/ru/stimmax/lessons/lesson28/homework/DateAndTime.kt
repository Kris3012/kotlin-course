@file:OptIn(kotlin.time.ExperimentalTime::class)
package ru.stimmax.lessons.lesson28.homework

import java.time.Instant
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.Period
import java.time.format.DateTimeFormatter
import java.time.ZoneId
import java.time.ZonedDateTime
import java.time.temporal.Temporal

//1 Создай текущую метку времени и выведи её на печать (чтобы ещё раз запомнить название этого класса)
fun main() {
    val instant = Instant.now()
    println(instant)

//2 Создай дату своего дня рождения.
    val myBirthdayDate = LocalDate.of(1992, 12, 30)

//3 Создай период между датой своего рождения и текущей датой. Выведи на печать количество лет из этого периода.
    val todayDate = Instant.now().atZone(ZoneId.systemDefault()).toLocalDate()
    val periodDate = Period.between(myBirthdayDate, todayDate)
    println(periodDate)

//4 Создай функцию, которая принимает тип Temporal и выводит форматированное значение в зависимости от того, содержит ли аргумент время и часовой пояс.
    // Temporal - это общий тип для разных классов даты-времени. В форматированном значении нужно выводить часы, минуты, секунды и таймзону, если они представлены в переданном объекте.
    // Обработай в методе все типы дат, которые знаешь. Реализуй два варианта функции - с собственный форматированием и с форматами из ISO коллекции.

    fun temporal(argument: Temporal) {
        when (argument) {
            is ZonedDateTime -> {
                println(argument.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss ZZZ")))
                println(argument.format(DateTimeFormatter.ISO_ZONED_DATE_TIME))
            }

            is LocalDateTime -> {
                println(argument.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
                println(argument.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME))
            }

            is LocalDate -> {
                println(argument.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")))
                println(argument.format(DateTimeFormatter.ISO_LOCAL_DATE))
            }

            is LocalTime -> {
                println(argument.format(DateTimeFormatter.ofPattern("HH:mm:ss")))
                println(argument.format(DateTimeFormatter.ISO_LOCAL_TIME))
            }

            else -> println("Некорректные данные даты")
        }
    }
//5 Создай объекты дат и / или времени которые мы изучили и по очереди передай их в метод созданный выше. Не используй в них метод now()

    val dateTask5 = LocalDate.of(2006, 6, 6)
    val timeTask5 = LocalTime.of(22, 5)
    val dateTimeTask5 = LocalDateTime.of(2000, 1, 1, 16, 10)
    val zoneTask5 = ZonedDateTime.of(2025, 2, 26, 10, 0, 0, 0, ZoneId.of("Europe/Paris"))

    println(temporal(dateTask5))
    println(temporal(timeTask5))
    println(temporal(dateTimeTask5))
    println(temporal(zoneTask5))

//6 Создайте функцию identifyGeneration, которая расширяет класс LocalDate и печатает строку, определяющую, к какому поколению принадлежит человек родившийся в эту дату:
    // "Бумер" для тех, кто родился с 1946 по 1964 год включительно, и "Зумер" для тех, кто родился с 1997 по 2012 год включительно.
    // Если дата рождения не попадает ни в один из этих диапазонов, функция должна печатать "Не определено".
    // Для сравнения дат используй методы isAfter(otherDate) и isBefore(otherDate) или проверку вхождения в диапазон.
    // Объекты с эталонными датами вынеси в приватные поля файла с методом identifyGeneration.

    fun LocalDate.identifyGeneration() {
        return when (this.year) {
            in 1946..1964 -> println("Данный человек принадлежит поколению Бумеров")
            in 1997..2012 -> println("Данный человек принадлежит поколению Зумеров")
            else -> println("Не определено")
        }
    }

    val birthDate = LocalDate.of(1999, 5, 10)
    println(birthDate.identifyGeneration())

//7 Создай два объекта даты: 25 февраля 2023 года и 25 февраля 2024 года. Создай форматтер, который форматирует дату в месяц и день.
val dateOne = LocalDate.of(2023,2,25)
val dateTwo = LocalDate.of(2024,2,25)

val formatter = DateTimeFormatter.ofPattern("'Месяц' MM', день' dd")

//8 Выведи первую отформатированную дату, прибавив к ней 10 дней.
val resultDateOne = dateOne.plusDays(10).format(formatter)
println(resultDateOne)

//9 Выведи вторую отформатированную дату, прибавив к ней 10 дней. Найди отличия)))
val resultDateTwo = dateTwo.plusDays(10).format(formatter)
println(resultDateTwo)

    // какой-то из годов високосный

}

