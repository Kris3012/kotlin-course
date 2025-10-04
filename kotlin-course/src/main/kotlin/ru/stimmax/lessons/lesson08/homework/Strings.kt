package ru.stimmax.lessons.lesson08.homework

fun main() {
    phrase1("Он сказал, что это невозможно")
    phrase2("Я не уверен, что мы зарелизим в пятницу")
    phrase3("Произошла катастрофа на сервере")
    phrase4("Этот код работает без проблем")
    phrase5("баги")
    task2("Пользователь вошел в систему -> 2021-12-01 09:48:23")
    task3("4539 1488 0343 6467")
    task4("username@example.com")
    task5("D:/good.themes/dracula.theme")
    task6("Котлин лучший язык программирования" )

}
//1. Преобразование строк
//Создайте функцию, которая будет анализировать входящие фразы и применять к ним различные преобразования, делая текст более ироничным или забавным. Функция должна уметь распознавать ключевые слова или условия и соответственно изменять фразу.
//Правила проверки и преобразования:
//Если фраза содержит слово "невозможно":
//Преобразование: Замените "невозможно" на "совершенно точно возможно, просто требует времени".
fun phrase1(phrases: String) {
    val result = when {
        phrases.contains("невозможно", ignoreCase = true) -> phrases.replace("невозможно", "совершенно точно возможно, просто требует времени", ignoreCase = true)

        else -> phrases
    }
    println(result)
}

//Если фраза начинается с "Я не уверен":
//Преобразование: Добавьте в конец фразы ", но моя интуиция говорит об обратном".

fun phrase2(phrases: String) {
    val result = when {
        phrases.startsWith("Я не уверен") ->  "$phrases, но моя интуиция говорит об обратном"
        else -> phrases
    }
    println(result)
}

//Если фраза содержит слово "катастрофа":
//Преобразование: Замените "катастрофа" на "интересное событие".
fun phrase3(phrases: String) {
    val result = when {
        phrases.contains("катастрофа", true) -> phrases.replace("катастрофа","интересное событие", true)
        else -> phrases
    }
    println(result)
}

//Если фраза заканчивается на "без проблем":
//Преобразование: Замените "без проблем" на "с парой интересных вызовов на пути".
fun phrase4(phrases: String) {
    val result = when {
        phrases.endsWith("без проблем") -> phrases.replace("без проблем", "с парой интересных вызовов на пути", true)
        else -> phrases
    }
    println(result)
}

//Если фраза содержит только одно слово:
//Преобразование: Добавьте перед словом "Иногда," и после слова ", но не всегда".
fun phrase5(phrases: String) {
    val result = when {
        phrases.split(" ").size == 1 -> "Иногда $phrases, но не всегда"
        else -> phrases
    }
    println(result)
}

//2. Извлечение даты из строки лога
//У вас есть строка лога, например "Пользователь вошел в систему -> 2021-12-01 09:48:23" (данные могут быть любыми, но формат всегда такой).
// Извлеките отдельно дату и время из этой строки и сразу распечатай их по очереди. Используй indexOf или split для получения правой части сообщения.

fun task2(log: String){
    val arrowIndex = log.indexOf("->")
    val rightPart = log.substring(arrowIndex + 3)
    val result = rightPart.split(" ")
    println(result[0])
    println(result[1])
}

//3. Маскирование личных данных
//Дана строка с номером кредитной карты, например "4539 1488 0343 6467".
// Замаскируйте все цифры, кроме последних четырех, символами "*".

fun task3(creditCard: String){
    val probel = creditCard.replace(" ", "")
    val length = creditCard.length
    val leftPart = creditCard.substring(0, 12)
    val rightPart = creditCard.substring(12, 16)
    val result = "*".repeat(leftPart.length) + rightPart
         println(result)
}

//4. Форматирование адреса электронной почты.
//У вас есть электронный адрес, например "username@example.com".
//Преобразуйте его в строку "username [at] example [dot] com", используя функцию replace()

fun task4(eMail:String){
    val result = eMail.replace("@"," [at] ").replace(".", " [dot] ")
      print(result)
}

//5. Извлечение имени файла из пути.
//Дан путь к файлу, например "C:/Пользователи/Документы/report.txt" или "D:/good.themes/dracula.theme" (может быть любым).
// Извлеките название файла с расширением.

fun task5(fileName: String){
    val result = fileName.split("/").last()
    println(result)
}

//6. Создание аббревиатуры из фразы.
//У вас есть фраза, например "Котлин лучший язык программирования" (может быть любой с разделителями слов - пробел).
//Создайте аббревиатуру из начальных букв слов (например, "ООП").
//Используйте split. Используйте for для перебора слов. Используйте var переменную для накопления первых букв.

fun task6(abbreviature: String){
    val words = abbreviature.split(" ")
    var result = "" // накопляем буквы тут
    for (word in words) {
        result+= word[0].uppercase()
    }
    println(result)

}