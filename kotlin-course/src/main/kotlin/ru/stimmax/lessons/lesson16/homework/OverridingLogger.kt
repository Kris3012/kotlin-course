package ru.stimmax.lessons.lesson16.homework
// Перегрузка методов
//5. Класс “Логгер”: представляет из себя инструмент для вывода информации в консоль с разным префиксами уровня логирования (INFO, WARNING, ERROR, DEBUG)
//Базовый метод log(message) выводит в консоль сообщение message с префиксом INFO
//Выполнить перегрузку метода log, который:
//Принимает уровень логирования и сообщение. Выводит сообщения типа WARNING жёлтым цветом, а ERROR белым цветом на красном фоне.
//Принимает список сообщений и все их выводит с уровнем INFO
//Принимает объект типа Exception и выводит его поле message с префиксом уровня ERROR
//Попробуй создать логгер и добавить в него сообщения разными способами. Проверь вывод в консоли.

class OverridingLogger {
}
object Colors4 {
    const val RESET = "\u001B[0m"
    const val RED = "\u001B[31m"
    const val GREEN = "\u001B[32m"
    const val YELLOW = "\u001B[33m"
    const val WHITE = "\u001B[37m"
}
object Background4 {
    const val RESET = "\u001B[0m"
    const val RED = "\u001B[41m"
}

class Logger {
    fun log(message: String) {
        println("INFO: $message")
    }

    fun log(message: String, levelOfLog: String) {
        when (levelOfLog) {
            "WARNING" -> println("${Colors4.YELLOW}WARNING: $message${Colors4.RESET}")
            "ERROR" -> println("${Background4.RED}${Colors4.WHITE}ERROR: $message${Colors4.RESET}")
            else -> println("INFO: $message")
        }
    }

    fun log(messages: List<String>) {
        messages.forEach { println("INFO: $it") }
    }

    fun log(error: Exception) {
        println("${Background4.RED}${Colors4.WHITE}ERROR: ${error.message}${Colors4.RESET}")
    }
}

fun main(){
    val logger = Logger()
    logger.log(message = "Some info")
    logger.log(message = "Some serious p r o b l e m s", levelOfLog = "WARNING")
    logger.log(messages =listOf("Error_1, Error_2, Error_3"))
    logger.log(Exception("ACHTUNG"))

}

