package ru.stimmax.lessons.lesson27.homework

// Задание 1
//1 Создай Enum со статусами прохождения теста (passed, broken, failed).

enum class TestStatus {
    PASSED,
    BROKEN,
    FAILED,
    ;
}

//2 Создай Enum с типами жилой недвижимости для сайта аренды, включая человекопонятные названия этих типов.

enum class realEastateTypes ( val estateName: String) {
    ROOM ("Комната"),
    APARTMENT("Квартира"),
    PENTHOUSE("Пентхаус"),
    TOWNHOUSE("Таунхаус"),
    HOUSE("Частный дом"),
    ;
}

//3 Создай Enum с планетами солнечной системы, включая расстояние до солнца в астрономических единицах и вес планеты.

enum class SolarSystem (val distanceFromSun: Double, val planetWeight: Double) {
    MERCURY(0.39, 3.30e23),
    VENUS(0.72, 4.87e24),
    EARTH(1.00, 5.97e24),
    MARS(1.52, 6.42e23),
    JUPITER(5.20, 1.90e27),
    SATURN(9.58, 5.68e26),
    URANUS(19.20, 8.68e25),
    NEPTUNE(30.05, 1.02e26)
}

//Задание 2
//Создай функцию, которая выводит на печать человекочитаемые названия типов недвижимости в порядке возрастания длины названия enum.

fun estateName() {
    realEastateTypes.entries
        .sortedByDescending { it.estateName.length }
        .forEach { println(it.estateName) }
}

//Задание 3
//Создай функцию, которая принимает лямбду без аргументов и возвращаемого значения и возвращает Enum со статусом прохождения теста в зависимости от того как выполнится принятая лямбда:
    //если без исключений - PASSED
    //если будет AssertionError - FAILED
    //прочие исключения  - BROKEN

fun task3 ( lambda: () -> Unit ): TestStatus {
return try {
    lambda ()
    TestStatus.PASSED
} catch (e: AssertionError) {
        TestStatus.FAILED
    } catch (e: Exception) {
    TestStatus.BROKEN
    }
}


//Задание 4
//Создай функцию, которая принимает лямбду и возвращает enum планеты.
// Лямбда должна принимать планету и возвращать булево значение.
// Лямбда здесь выступает в качестве фильтра, который должен отфильтровать список всех планет по какому-либо признаку (расстояние или вес).
// Вернуть нужно первый элемент из отфильтрованного списка или выкинуть исключение если список пустой.

// не успеваю к дедлайну :С