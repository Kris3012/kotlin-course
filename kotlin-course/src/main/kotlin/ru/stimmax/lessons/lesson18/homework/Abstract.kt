package ru.stimmax.lessons.lesson18.homework

abstract class Abstract {
}

// копируем изначальные условия интерфейсов
interface Powerable {
    fun powerOn()
    fun powerOff()
}

interface Openable {
    fun open()
    fun close()
}

interface WaterContainer {
    val capacity: Int
    fun fillWater(amount: Int)
    fun getWater(amount: Int)
}

interface TemperatureRegulatable {
    val maxTemperature: Int
    fun setTemperature(temp: Int)
}

interface WaterConnection {
    fun connectToWaterSupply()
    fun getWater(amount: Int)
}

interface AutomaticShutdown {
    val sensorType: String
    val maxSensoredValue: Int
    fun startMonitoring()
}

interface Drainable {
    fun connectToDrain()
    fun drain()
}

interface Timable {
    fun setTimer(time: Int)
}

interface BatteryOperated {
    fun getCapacity(): Double
    fun replaceBattery()
}

interface Mechanical {
    fun performMechanicalAction()
}

interface LightEmitting {
    fun emitLight()
    fun completeLiteEmission()
}

interface SoundEmitting {
    fun setVolume(volume: Int)
    fun mute()
    fun playSound(stream: String)
}

interface Programmable {
    fun programAction(action: String)
    fun execute()
}

interface Movable {
    fun move(direction: String, distance: Int)
}

interface Cleanable {
    fun clean()
}

interface Rechargeable {
    fun getChargeLevel(): Double
    fun recharge()
}

//Задача 1. Создай абстрактные классы устройств, используя эти интерфейсы. Реализовывать методы не нужно.
// Холодильник
abstract class AbstractFreezer : Powerable, Openable, LightEmitting {

}

// Стиральная машина
abstract class AbstractWashingMachine : Powerable, Openable, WaterConnection, Drainable, TemperatureRegulatable,
    Timable, Programmable, Cleanable, AutomaticShutdown {

}

// Умная лампа
abstract class AbstractSmartLamp : LightEmitting, Programmable, Rechargeable {

}

// Электронные часы
abstract class AbstractElectricWatch : Openable, Timable, BatteryOperated, Rechargeable {

}

// Робот-пылесос
abstract class AbstractRoboCleaner : Powerable, Openable, WaterContainer, Rechargeable, Programmable, Movable,
    Cleanable {

}

// Механические часы
abstract class AbstractMechanicWatch : Openable, Mechanical, BatteryOperated, Cleanable {

}

// Фонарик
abstract class AbstractFlashlight : Powerable, Openable, BatteryOperated, LightEmitting, Movable {

}

// Кофемашина
abstract class AbstractCoffeeMachine : Powerable, Openable, WaterContainer, TemperatureRegulatable, Programmable,
    Cleanable {

}

// Умная колонка
abstract class AbstractSmartSpeaker : Powerable, Rechargeable, Programmable, SoundEmitting, Movable {

}

//Задача 2. Создай абстрактный класс для включаемого оборудования и имплементируй соответствующий интерфейс с реализацией методов
// (достаточно println с выполняемым действием).

abstract class PowerEquipment : Powerable {
    protected var isPowerOn: Boolean = false //для Задачи 5

    override fun powerOn() {
        if (!isPowerOn) {
            isPowerOn = true
            println("Оборудование ВКЛючено")
        } else {
            println("Оборудование выключено")
        }
    }

    override fun powerOff() {
        if (isPowerOn) {
            isPowerOn = false
            println("Оборудование выключено")
        } else {
            println("Оборудование ВКЛючено")
        }

    }
}

//Задача 3. Создай абстрактный класс для программируемого оборудования (с имплементацией соответствующего интерфейса и реализацией методов)
// и наследуй его от абстрактного класса включаемого оборудования.

    abstract class ProgramEquipment : PowerEquipment(), Programmable {
        override fun programAction(action: String) {
            if (isPowerOn) {
                println("Выполнено $action")
            } else {
                println("Включите устройство")
            }
        }

        override fun execute() {
            if (isPowerOn) {
                println("Действие выполнено")
            } else {
                println("Включите устройство")
            }
        }
    }

//Задача 4. Создай абстрактный класс оборудования с возможностью устанавливать температуру и открываться и с наследованием от программируемого оборудования.
// Также имплементируй интерфейсы.

        abstract class TemperatureSetAndOpenableEquipment : ProgramEquipment(), Openable, TemperatureRegulatable {
            override fun setTemperature(temp: Int) {
                if (isPowerOn) {
                    println("Установлена температура - $temp градусов")
                } else {
                    println("Включите устройство")
                }
            }

            override fun open() {
                println("Устройство открыто")
            }

             override fun close() {
                 println("Устройство закрыто")
    }
}

//Задача 5. Создай не абстрактные классы устройств с наследованием от абстрактного класса с возможностью устанавливать температуру и открываться.
// Пусть это будет холодильник, стиральная машина, чайник, духовка.
// Добавь недостающие интерфейсы и реализуй необходимые методы (достаточно вывод в консоль производимого действия).
// Обрати внимание на то, что установка температуры и программирование устройства (считай - задание режима работы) не имеет смысла при выключенном питании - добавь эту проверку.
//Создай объекты этих устройств и позапускай их с различными методами.

class Freezer(override val maxTemperature: Int) : TemperatureSetAndOpenableEquipment(), LightEmitting {
    override fun emitLight() {
        println("Свет включен")
    }

    override fun completeLiteEmission() {
        println("Свет ВЫКЛючен")
    }

}

class WashingMachine(override val maxTemperature: Int): TemperatureSetAndOpenableEquipment(), Drainable, Cleanable {
    override fun clean() {
        println("Машинка почищена")
    }

    override fun connectToDrain() {
        println("Подключите устройство к сливу")
    }

    override fun drain() {
        println("Вода слита")
    }
}

class Oven(override val maxTemperature: Int): TemperatureSetAndOpenableEquipment(), LightEmitting{
    override fun emitLight() {
        println("Свет включен")
    }

    override fun completeLiteEmission() {
        println("Свет ВЫКЛючен")
    }
}

class Kettle(override val maxTemperature: Int, override val capacity: Int): TemperatureSetAndOpenableEquipment(), WaterContainer{
    override fun fillWater(amount: Int){
        println("Наполнить чайник на $amount мл")
    }
    override fun getWater(amount: Int){
        println("Вылить $amount мл")
    }
}

fun main(){
    val freezer = Freezer(5)
    val washingMachine = WashingMachine(90)
    val oven = Oven(250)
    val kettle = Kettle(100, 1500)

    // Включаем устройства
    freezer.powerOn()
    washingMachine.powerOn()
    oven.powerOn()
    kettle.powerOn()


    // Пробуем установить температуру
    freezer.setTemperature(3)
    washingMachine.setTemperature(60)
    oven.setTemperature(200)
    kettle.setTemperature(95)

    // Программируем устройства
    freezer.programAction("заморозка")
    washingMachine.programAction("деликатная стирка")
    oven.programAction("какое-то выпекание")
    kettle.programAction("закипятить воду")

    // Выключаем устройства
    freezer.powerOff()
    washingMachine.powerOff()
    oven.powerOff()
    kettle.powerOff()
}