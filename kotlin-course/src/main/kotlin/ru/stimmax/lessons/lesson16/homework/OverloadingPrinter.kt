package ru.stimmax.lessons.lesson16.homework

import java.awt.Color

//3. Создай абстрактный принтер, который имеет абстрактный метод печати, принимающий в качестве аргумента строку.
//Создай классы наследники: лазерный и струйный
//Лазерный принтер должен разбивать фразу на слова по пробелу и выводить каждое слово отдельно чёрными буквами на белом фоне (хорошо работает на тёмной теме)
//Струйный принтер должен разбивать фразу на слова по пробелу и выводить каждое слово отдельно цветными буквами на цветном фоне.
// Слова должны быть разноцветны. Можно сделать список пар с цветом текста и фона и проходить циклически по этому списку при выводе текста. Проверить работу на длинном тексте


class OverloadingPrinter {
}
object Colors3 {
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
object Background3 {
    const val RESET = "\u001B[0m"
    const val BLACK = "\u001B[40m"
    const val RED = "\u001B[41m"
    const val GREEN = "\u001B[42m"
    const val YELLOW = "\u001B[43m"
    const val BLUE = "\u001B[44m"
    const val PURPLE = "\u001B[45m"
    const val CYAN = "\u001B[46m"
    const val WHITE = "\u001B[47m"
}

abstract class Printer() {
    abstract fun print(text: String)
}

class LaserPrinter(): Printer(){
    override fun print(text: String) {
        val words = text.split(" ") // разбили строку по словам, проходимся по кажд слову
        for (word in words){
            println("${Colors3.BLACK}${Background3.WHITE}$word${Colors3.RESET}")
        }
    }
}

class InkjetPrinter(): Printer(){
    override fun print(text: String) {
        val words = text.split(" ")
        val textColors = listOf(Colors3.RED, Colors3.GREEN, Colors3.BLUE, Colors3.CYAN)
        val bgColors = listOf(Background3.YELLOW, Background3.PURPLE, Background3.RED, Background3.GREEN)
        var colorIndex = 0
         for (word in words){
             val textColor = textColors[colorIndex]
             val bgColor = bgColors[colorIndex]
             println("$textColor$bgColor$word${Colors3.RESET}")
             colorIndex++
             if(colorIndex == textColors.size){
                 colorIndex = 0
             }
         }
    }
}

fun main(){
 val text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi suscipit consequat arcu, eget mollis ex faucibus ac. Integer nulla velit, volutpat ut nunc ac, dignissim volutpat velit. Morbi vitae cursus urna. Integer tristique tempus enim, quis scelerisque eros laoreet et. Fusce lectus ligula, maximus vel venenatis in, venenatis nec lorem. In auctor finibus egestas. Mauris gravida nisl a risus interdum facilisis. Suspendisse pellentesque arcu eu ligula pulvinar molestie et vel turpis. Nam interdum ante sapien, eget vulputate augue dictum at. Etiam eu dui hendrerit tortor fringilla consequat nec fermentum orci. Phasellus ultrices ut tortor quis ornare. Nam vel ultrices nibh, sed facilisis ligula. Donec fringilla congue augue sodales feugiat."

    val laser = LaserPrinter()
    val inkjet = InkjetPrinter()

    laser.print(text)
    inkjet.print(text)
}

