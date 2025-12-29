package ru.stimmax.lessons.lesson31.homework

class PhoneNumberFormatter {

    fun formatPhoneNumber(number: String): String {
        val numbersOnly = number.replace("\\D".toRegex(), "")
        if (numbersOnly.length != 10 && numbersOnly.length != 11) {
            throw IllegalArgumentException("Невалидный номер")
        }
        val normalNumber = when (numbersOnly.length) {
            10 -> numbersOnly
            11 -> {
                if (numbersOnly.startsWith("7") || numbersOnly.startsWith("8")) {
                    numbersOnly.substring(1)
                } else {
                    throw IllegalArgumentException("Невалидный номер")
                }
            }

            else -> throw IllegalArgumentException("Невалидный номер")
        }

        return "+7 (${normalNumber.substring(0,3)}) " +
                "${normalNumber.substring(3,6)}-" +
                "${normalNumber.substring(6,8)}-" +
                "${normalNumber.substring(8,10)}"


    }
}