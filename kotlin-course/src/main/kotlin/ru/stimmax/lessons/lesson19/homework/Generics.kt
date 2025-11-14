package ru.stimmax.lessons.lesson19.homework

// 1 Напиши функцию getMiddleElement с дженериком, которая будет принимать список и возвращать средний элемент, если он существует, иначе возвращать null.
// Например, у списка из четырёх элементов - среднего элемента нет.

fun <T> getMiddleElement(list: List<T>): T? {
    if (list.size % 2 != 0) {
        return list[list.size / 2] //ищем индекс середины
    }
    return null
}

// 2 Напиши класс ListHolder, который будет хранить список элементов типа T и иметь метод для добавления нового элемента и получения всех элементов в виде неизменяемого списка.

class ListHolder<T>(val elements: MutableList<T>) {
    fun addElement(element: T) {
        elements.add(element)
    }

    fun getElements(): List<T> {
        return elements.toList() //тут у нас всегда будет по итогу неизменяемый список
    }
}

//3 Создай интерфейс Mapper с двумя дженериками, который будет определять методы для преобразования:
//элементов одного типа в элементы другого типа
//списка элементов одного типа в список элементов другого типа

interface Mapper<T, M> {
    fun transform1(arg1: T): M
    fun transform2(list: List<T>): List<M>
}

// 4 Создай класс PhrasesToListOfStrings и имплементируй интефрейс Mapper с типами String и List<String>.
// Метод преобразования должен разбивать входящую строку по символу пробела и возвращать список из полученных слов. Метод преобразования списков с аналогичной механикой.

class PhrasesToListOfStrings : Mapper<String, List<String>> {
    override fun transform1(arg1: String): List<String> {
        return arg1.split(" ")
    }

    override fun transform2(list: List<String>): List<List<String>> {
        return list.map { transform1(it) } // для каждого элемента списка вызываем transform1
    }
}

// 5 Создай функцию transposition с двумя дженериками, которая принимает словарь с дженериками и возвращает словарь, в котором ключ и значения поменялись местами.

fun <T, M> transposition(arg: Map<T, M>): Map<M, T> {
    val result = mutableMapOf<M, T>()

    for ((key, value) in arg) {
        result[value] = key
    }
    return result
}

// 6 Напиши интерфейс Validator с дженериком с функцией валидации, которая будет принимать элемент с типом дженерика и возвращать булево значение.

interface Validator<T> {
    fun validation(element: T): Boolean
}

// 7 Создай класс StringValidator и имплементируй интерфейс Validator с типом String?. Реализуй проверку, что строка не является null, не пустая и не состоит из одних пробелов.

class StringValidator : Validator<String?> {
    override fun validation(element: String?): Boolean {
        if (!element.isNullOrBlank()) {
            return true
        }
        return false
    }
}

// 8 Создай класс OddValidator и имплементируй интерфейс Validator типизированный по Int.
// Реализуй проверку, что число чётное.

class OddValidator: Validator<Int> {
    override fun validation(element: Int): Boolean {
        if (element % 2 == 0){
            return true
        }
        return false
    }

}

// 9 Создай класс ListValidator с дженериком, ограниченным типом Number, имплементируй интерфейс Validator типизированный по типу List с nullable типом дженерика класса
//Реализуй проверку:
//Ни один элемент списка не является null
//Ни один элемент приведённый к типу Double не равен 0.0

class ListValidator <T: Number>: Validator < List <T?> > {
    override fun validation(element: List<T?>): Boolean {
        for (item in element){
            if (item == null) return false
            if (item.toDouble() == 0.0) return false

        }

        return true
    }
}