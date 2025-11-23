package ru.stimmax.lessons.lesson22.homework

class Exceptions {
}
// Задание 1-8 Воспроизвести фрагменты кода, которые могут привести к возникновению исключений.
//Задание 9. Оберни все вызовы из предыдущего задания в блок try-catch и создай для каждого типа ошибки свой catch блок:

fun main() {
//1 NullPointerException
    try {
        val number: Int? = null
        println(number!!)
    } catch (e: NullPointerException) {
        println("Число не может быть null")
    }


//2 IndexOutOfBoundsException
    try {
        val array = arrayOf(100, 200, 300)
        array[3]
    } catch (e: IndexOutOfBoundsException) {
        println("Такого индекса не существует")
    }


// 3 ClassCastException
    try {
        val cast: String = "Мы не знаем, что это такое"
        cast as Int
    } catch (e: ClassCastException) {
        println("Недопустимое приведение типов")
    }


    // 4 IllegalArgumentException
    fun illegalMessage(message: String) {
        require(message.length > 10) { "Слишком короткий текст" }
        try {
            illegalMessage("Окак")
        } catch (e: IllegalArgumentException) {
            println("Слишком короткий текст")
        }

// 5 NumberFormatException
        try {
            val someString = "здесь текст"
            someString.toDouble()
        } catch (e: NumberFormatException) {
            println("Это NumberFormatException")
        }


        // 6 IllegalStateException
        fun isItNull(task6: Boolean?) {
            checkNotNull(task6)
            try {
                val task6: Boolean? = null
                isItNull(task6)
            } catch (e: IllegalStateException) {
                println("Это IllegalStateException")
            }

            // 7 OutOfMemoryError
            fun memory() {
                try {
                    val bigArray = Array(1000) { ByteArray(1_000_000) }
                } catch (e: OutOfMemoryError) {
                    println("Это OutOfMemoryError")
                }


                // 8 StackOverflowError
                fun createOverflow() {
                    try {
                        createOverflow()
                    } catch (e: StackOverflowError) {
                        println("Это StackOverflowError")
                    }
                }

//Задание 10. Напиши функцию, которая принимает nullable аргумент типа Any и в блоке try/catch выполни набор действий с этим аргументом, которые могут потенциально вызвать одно из исключений в этом же порядке:
//NullPointerException
//IndexOutOfBoundsException
//ClassCastException
//IllegalArgumentException
//NumberFormatException
//IllegalStateException

// В блоке catch перехватывай исключение с общим типом Throwable а внутри через when определи тип исключения и выведи сообщение с названием исключения.
// Сразу после when выброси перехваченное исключение через throw, чтобы прекратить работу программы.
// Если аргумент функции не вызвал исключение, то выведи текст, сообщающий что переданный аргумент фантастически хорош!

                fun task10(param: Any?) {
                    try {
                        param!! //NullPointerException
                        param as String
                        param[90] //IndexOutOfBoundsException
                        param as Int //ClassCastException
                        require(param is Number) //IllegalArgumentException
                        (param as String).toDouble() //NumberFormatException
                        check(param != null) // IllegalStateException
                    } catch (e: Throwable) {
                        when (e) {
                            is NullPointerException -> {
                                println("Это NullPointerException")
                            }

                            is IndexOutOfBoundsException -> {
                                println("Это IndexOutOfBoundsException")
                            }

                            is ClassCastException -> {
                                println("Это ClassCastException")
                            }

                            is IllegalArgumentException -> {
                                println("Это IllegalArgumentException")
                            }

                            is NumberFormatException -> {
                                println("Это NumberFormatException")
                            }

                            is IllegalStateException -> {
                                println("Это IllegalStateException")

                            }

                            else -> println("Неизвестное исключение")

                        }
                        throw e
                    }
                    println("Переданный аргумент фантастически хорош!")
                }
            }
        }
    }
//Задание 11. Создай свой тип исключения в отдельном файле, наследуемый от AssertionError и принимающий текст.
// Выброси это исключение в main

    fun main() {
        throw MyException("Кастомное исключение")
    }
//Задание 12. Создай свой тип исключения в отдельном файле, наследуемый от RuntimeException и принимающий IndexOutOfBoundsException тип в качестве аргумента.
// Напиши код, который спровоцирует выброс IndexOutOfBoundsException, перехвати его с помощью try-catch и в блоке catch выведи сообщение в консоль и сделай выброс своего типа исключения.

// пока не делала

}




