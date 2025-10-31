package ru.stimmax.lessons.lesson16.homework

//Переопределение методов

//1. Животные и Их Звуки
//Базовый класс: Animal с методом makeSound().
//Классы наследники: Dog, Cat, Bird.
//Базовый метод makeSound() в классе Animal выводит "This animal makes no sound."
//Переопределите метод makeSound() в каждом классе-наследнике, чтобы Dog выводил "Bark", Cat - "Meow", Bird - "Tweet". Обогати вывод звуков цветом.
//Создайте список животных List<Animal> и вызовите в цикле метод makeSound()

class OverloadingAnimal {
}
object Colors {
    const val RESET = "\u001B[0m"
    const val BLACK = "\u001B[30m"
    const val RED = "\u001B[31m"
    const val GREEN = "\u001B[32m"
    const val YELLOW = "\u001B[33m"
    const val BLUE = "\u001B[34m"
    const val PURPLE = "\u001B[35m"
    const val CYAN = "\u001B[36m"
    const val WHITE = "\u001B[37m"
}
fun printSound(sound:String, color:String){
    println("$color$sound${Colors.RESET}")
}

abstract class Animal {
    open val sound: String = "This animal makes no sound."

    open fun makeSound() {
        println(sound)
    }
}

class Dog : Animal() {
    override val sound = "Bark"
    override fun makeSound() {
        printSound(sound, Colors.CYAN)
    }
}

class Cat : Animal() {
    override val sound = "Meow"
    override fun makeSound() {
        printSound(sound, Colors.PURPLE)
    }
}

class Bird : Animal() {
    override val sound = "Tweet"
    override fun makeSound() {
        printSound(sound, Colors.YELLOW)
    }
}

fun main(){
    val animals: List<Animal> = listOf(Dog(),Cat(), Bird())
    animals.forEach { it.makeSound()
        println()
    }
}