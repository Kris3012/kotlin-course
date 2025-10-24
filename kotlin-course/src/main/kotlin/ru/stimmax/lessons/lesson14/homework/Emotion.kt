package ru.stimmax.lessons.lesson14.homework
//2. Аспект реальности: эмоция. Создайте класс Emotion, который представляет эмоцию.
// У него должно быть свойство type (String) и intensity (Int). Добавьте метод express(), который выводит описание эмоции в зависимости от её типа и интенсивности.

class Emotion(var type: String, var intensity: Int) {

    fun express() {
        println("Эмоция: $type, Интенсивность: $intensity")
    }
}

fun main() {
    val emotion = Emotion("Усталость", 8)
    emotion.express()
}