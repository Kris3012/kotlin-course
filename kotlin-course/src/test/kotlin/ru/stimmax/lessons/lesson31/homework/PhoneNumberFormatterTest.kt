package ru.stimmax.lessons.lesson31.homework

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.ValueSource

class PhoneNumberFormatterTest {

    @ParameterizedTest
    @MethodSource("provideValidNumbers")
    fun `should return valid number`(input: String, expected: String) {
        val formatter = PhoneNumberFormatter()
        val result = formatter.formatPhoneNumber(input)
        assertEquals(expected, result)
    }

    companion object {
        @JvmStatic
        fun provideValidNumbers() = listOf(
            Arguments.of("8(999) 999 88 88", "+7 (999) 999-88-88"),
            Arguments.of("79999998888", "+7 (999) 999-88-88"),
            Arguments.of("+79999998888", "+7 (999) 999-88-88")
        )

    }

    @ParameterizedTest
    @ValueSource(
        strings = [
            "12345",
            "+1 (999) 991-11-11",
            "999",
            "123456789012"
        ]
    )
    fun `should return exception for invalid number`(input: String) {
        val formatter = PhoneNumberFormatter()
        assertThrows<IllegalArgumentException> {
            val result = formatter.formatPhoneNumber(input)
        }
    }

}