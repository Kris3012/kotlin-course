package ru.stimmax.lessons.lesson25.homework

// Задание 1. Функция высшего порядка.
//Создайте функцию timeTracker, которая принимает другую функцию в качестве аргумента и измеряет время её выполнения.
// Функция timeTracker должна возвращать затраченное время в миллисекундах.
// Для измерения времени используйте System.currentTimeMillis() до и после выполнения переданной функции.

// time — имя параметра
// () -> Any — тип функции

fun timeTracker(time: () -> Any): Long {
    val first = System.currentTimeMillis()
    time()
    val second = System.currentTimeMillis()
    return (second - first)
}


// Задания для работы со scope функциями
//Классы для выполнения заданий:
class Person(val name: String, val age: Int) {
    var email: String = ""
}

class Employee(val name: String, val age: Int, val position: String) {
    var email: String = ""
    var department: String = "General"
}

// Задание 2: Использование apply для инициализации объекта Employee
//Создайте объект Employee и используйте apply для инициализации его полей email и department.

val employee = Employee("Имя", 30, "Должность")
    .apply {
        var email: String = ""
        var department: String = "General"
    }

// Задание 3: Использование also для логирования
//Создайте функцию, принимающую объект Person и выводящую информацию об объекте в консоль в красивом, отформатированном виде.
//Используй with для создания контекста Person и возможности использовать поля объекта напрямую без обращения к переменной.


fun task3(person: Person): String {
    return with(person) {
        email = "$name.${age}@mail.ru"
        "Имя: $name, Возраст: $age, Email: $email"
    }
}


fun main() {

    // к заданию 1
    val myFunction = {
        val list = List(10000000) { (0..10000).random() }
        list.sorted()
    }

    // к заданию 3.
        //Создайте объект Person и используйте also для добавления почты и печати данных
        // в консоль с помощью метода который только что создали.

val personEx = Person("Имя", 25)
    .also {
        val result = task3(it)
        println(result)
    }

// Задание 4: Использование with для преобразование Person в Employee
    //Создайте объект класса Person. Используйте функцию with, чтобы создать из этого объекта Employee, указав дополнительно должность.
    // Возвращаемым значением должен быть новый объект Employee.

    val personToEmployee = Person("Имя", 40)
    with (personToEmployee) {
        Employee("Имя", 40, "")
    }
    val employee = with(personToEmployee){
        Employee(name,age,"Должность")
    }

    //Задание 5: Использование run для преобразования и инициализации Employee
    //Перепиши предыдущую задачу на использование run вместо with.

    val personToEmployee2 = personToEmployee.run {
        Employee("Имя", 40, "Должность2")
    }


    //Задание 6: Использование let для безопасного преобразования Person в Employee
    //Создайте функцию toEmployee, которая расширяет класс Person, который может быть null.
    // В функции используйте функцию let для создания Employee, только если объект Person не null.
    // В противном случае возвращается null
        // пока не успела

}

