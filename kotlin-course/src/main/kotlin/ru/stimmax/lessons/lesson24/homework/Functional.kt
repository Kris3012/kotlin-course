package ru.stimmax.lessons.lesson24.homework

// Задачи на синтаксис функций высшего порядка.
// 1 Создай функцию, которая:
//принимает булево значение
//принимает функцию, принимающую строку и ничего не возвращающую
//возвращает целое число

fun task1(arg: Boolean, fun1: (String) -> Unit): Int {
    fun1("Oh Hi Mark")
    return 42
}

// 2 Создай функцию расширения целого числа, которая:
//принимает функцию расширения целого числа, принимающую строку и возвращающую список строк
//возвращает список строк

fun Int.task2(fun2: (String) -> List<String>): List<String> {
    fun2("Oh Hi Mark")
    return emptyList()
}

// 3 Создай функцию с двумя дженериками расширяющую первый дженерик, которая:
//принимает функцию расширяющую первый дженерик, ничего не принимает и возвращает второй дженерик
//возвращает второй дженерик

fun <T, R> task3(t: T, fun3: T.() -> R): R {
    return t.fun3()
}

// 4 Создай функцию, которая:
//принимает строку
//возвращает функцию, которая ничего не принимает и возвращает строку

fun task4(text: String): () -> String {
    return { text }
}

// 5 Создай функцию расширяющую дженерик, которая:
//ничего не принимает
//возвращает функцию, принимающую строку и возвращающую дженерик

fun <T> task5(t: T): (text: String) -> T {
    return { text -> t }
}

// Задание 6.
// Скопируй набор кодов цвета и функцию окрашивания строки в переданный в неё цвет из набора.

object Colors {
    const val RESET = "\u001B[0m"
    const val RED = "\u001B[31m"
    const val GREEN = "\u001B[32m"
    const val YELLOW = "\u001B[33m"
    const val BLUE = "\u001B[34m"
    const val PURPLE = "\u001B[35m"
    const val CYAN = "\u001B[36m"
    const val WHITE = "\u001B[37m"
}

fun String.colorize(color: String): String {
    return "$color$this${Colors.RESET}"
}

//Напиши функцию colorizeWords которая печатает слова из длинного предложения разбитого по пробелу разным цветом.
// Правило подбора цвета для каждого слова нужно передавать в виде функции, которая принимает слово и возвращает это же слово но уже "в цвете" через функцию colorize.
//Функция colorizeWords должна расширять строку и эту же строку и обрабатывать.

fun String.colorizeWords(text: (String) -> String) {
    this.split(" ").forEach { word ->
        print(text(word) + " ")
    }
    println()
}

//Напиши несколько функций обработки слов:
//цвет слова зависит от его характеристик (для каждой характеристики отдельный цвет):

//начинается с большой буквы
fun startsWithUpperCase(word: String) =
    if (word.firstOrNull()?.isUpperCase() == true) word.colorize(Colors.RED) else word

//длина меньше трёх символов
fun lengthLess(word: String) =
    if (word.length < 3) word.colorize(Colors.CYAN) else word

//длина больше 6 символов
fun lengthMore(word: String) =
    if (word.length > 6) word.colorize(Colors.BLUE) else word

//длина кратна двум
fun evenLength(word: String) =
    if (word.length % 2 == 0) word.colorize(Colors.GREEN) else word

//для всех прочих отдельный цвет.
fun otherColor(word: String): String {
    return word.colorize(Colors.YELLOW)
}


//цвет слова выбирается по очереди из списка цветов для каждого слова через счётчик.
    // пока не делала
// Когда счётчик доходит до края списка слов - он обнуляется и начинается заново.
    // пока не делала
//цвет слова выбирается по очереди из списка цветов для каждого слова через счётчик.
    // пока не делала
// Счётчиком управляет функция, находящаяся в изменяемой переменной.
    // пока не делала
// Сначала это функция с инкрементом счётчика. Когда счётчик доходит до края списка цветов, нужно заменить функцию счётчика на функцию с декрементом.
    // пока не делала
// Когда счётчик доходит до нуля - заменить функцию счётчика на функцию с инкрементом и так далее.
    // пока не делала


//  Создай переменную с длинным текстом (например из этого урока)
    //  и вызови у этой переменной функцию colorizeWords и передай в неё по очереди каждую из функций, проверь результат в консоли.

fun main(){
    val longText = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."

    longText.colorizeWords(::startsWithUpperCase)
    longText.colorizeWords(::lengthLess)
    longText.colorizeWords(::lengthMore)
    longText.colorizeWords(::evenLength)
    longText.colorizeWords(::otherColor)

}