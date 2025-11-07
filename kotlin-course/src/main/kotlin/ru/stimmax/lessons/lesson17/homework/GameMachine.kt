package ru.stimmax.lessons.lesson17.homework
// 1. Игровой автомат
//Опиши схематически класс игрового автомата, правильно расставив объявление полей (val или var) и методов (аргументы и возвращаемые значения), включая модификаторы доступа (private для приватных)
//
//Поля:
//цвет - color
//модель - model
//включен - isOn
//ОС загружена - osLoaded
//список установленных игр - gameList
//наличие джойстика - hasJoystick
//баланс вырученных средств - balance
//владелец - owner
//телефон поддержки - supportNumber
//игровой сеанс оплачен - sessionPaid
//стоимость одного игрового сеанса - sessionCost
//пин-код автомата - pinCode

//Методы:
//включить - публичный
//выключить - публичный
//загрузить ОС - приватный
//завершить работу ОС - приватный
//показать список игр - публичный
//включить игру - публичный
//оплатить игровой сеанс - публичный
//забрать наличные с помощью пин-кода - приватный
//открыть сейф и выдать наличные - приватный

class GameMachine(
    var color: String,
    val model: String,
    val gameList: List<String>,
    val hasJoystick: Boolean,
    private var isOn: Boolean,
    private var osLoaded: Boolean,
    private var balance: Double,
    private var sessionPaid: Boolean,
    val owner: String,
    val supportNumber: String,
    var sessionCost: Double,
    private var pinCode: String
) {

    fun switchOn() {
        isOn = true
        loadOs()
    }

    fun switchOff() {
        isOn = false
        endOs()
    }

    private fun loadOs() {

    }

    private fun endOs() {

    }

    fun showGameList() {
        if (isOn == false){
        println("Автомат не включен")
        } else {
            println(gameList)
        }
    }

    fun turnOnGame() {
        if (isOn == true && osLoaded == true && sessionPaid == true){
            println("Выбери игру: ${gameList}")
        } else {
            println("Чтобы играть, внеси ${sessionCost} руб")
        }
    }

    fun paySession() {
        if (isOn == true && osLoaded == true){
            sessionPaid = true
            balance += sessionCost //т.к. внесли денег за игру
        }
    }

    private fun takeCash(pinCode: String) {
    if (this.pinCode == pinCode){
        openSafe()
    } else {
        println("Неверный пин-код. Попробуйте еще раз")
    }
    }

    private fun openSafe() {
        balance = 0.0 //выдаём наличные
        println("Средства выведены.")
    }

}