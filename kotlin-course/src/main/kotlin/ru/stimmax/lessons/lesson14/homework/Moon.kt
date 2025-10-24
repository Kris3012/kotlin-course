package ru.stimmax.lessons.lesson14.homework

//3. Природное явление: луна. Создайте объект Moon, который будет представлять Луну. Добавьте свойства isVisible (Boolean), чтобы отображать, видна ли Луна в данный момент, и phase (String), чтобы отображать текущую фазу Луны (например, "Full Moon", "New Moon").
// Добавьте метод showPhase(), который выводит текущую фазу Луны.

object Moon {
    var isVisible: Boolean = true
    var phase: String = "Full Moon"
    fun showPhase() {
        if (isVisible) {
            println("Фаза луны: $phase")
        } else {
            println("Луна не видна")
        }
    }

}

fun main() {
    Moon.showPhase()
}
