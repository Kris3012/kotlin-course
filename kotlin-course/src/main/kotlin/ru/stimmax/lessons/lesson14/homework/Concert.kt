package ru.stimmax.lessons.lesson14.homework
//5. Мероприятие: концерт. Создайте класс, который будет представлять концерт.
// У него должны быть свойства “группа”, “место проведения”, “стоимость”, “вместимость зала”. Также приватное поле “проданные билеты”. Добавьте метод, который выводит информацию о концерте и метод “купить билет”, который увеличивает количество проданных билетов на один.


class Concert(
    val band: String,
    val location: String,
    val price: Double,
    val capacity: Int,
    private var soldTickets: Int
) {

    fun buyTicket() {
        if (soldTickets < capacity) {
            soldTickets++
        } else {
            println("Больше билетов продать нельзя")
        }
    }

    fun info() {
        println("Название группы: $band, место проведения: $location, цена билета: $price, вместимость площадки: $capacity, продано билетов: $soldTickets")
    }

}

fun main() {
    val concert = Concert("Muse", "Олимпийский", 5000.0, 1000, 1000)
    concert.info()
}