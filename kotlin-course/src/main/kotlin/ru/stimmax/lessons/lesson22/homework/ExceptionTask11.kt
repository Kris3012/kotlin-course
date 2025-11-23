package ru.stimmax.lessons.lesson22.homework

//Задание 11. Создай свой тип исключения в отдельном файле, наследуемый от AssertionError и принимающий текст.

class MyException (message: String): AssertionError(message)