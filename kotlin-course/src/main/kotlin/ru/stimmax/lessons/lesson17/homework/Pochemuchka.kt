package ru.stimmax.lessons.lesson17.homework

    //2. Почемучка
//Нужно скопировать код к себе и постараться ответить на все “почему” в комментариях и заданным образом доработать класс ChildrenClass (BaseClass доработке не подлежит)

    abstract class BaseClass(
  // 1. объясни, почему это поле доступно в main() для чтения из класса ChildrenClass
        // Ответ: это другое поле, т.к. в ChildrenClass переменная публичная, без модификатора private.
        private val privateVal: String,
  // 2. объясни, почему это поле недоступно в main()
        // Ответ: у него модификатор protected, его не видно снаружи из main() - он защищает доступ к содержимому извне
        protected val protectedVal: String,
        val publicVal: String
    ) {
        var publicField = "3. измени меня из функции main() на Антонио Бандераса и проверь через функцию getAll()" +
                "4. Доработай ChildrenClass таким образом, чтобы это получилось"
            set(value) {
                if (verifyPublicField(value)) {
                    field = value
                }
            }
        protected var protectedField = "5. измени меня из функции main() через сеттер в наследнике"
        private var privateField = "6. добавь сеттер чтобы изменить меня из main()"
        //п. 6 не получится сделать, т.к. у privateField модификатор private

        fun getAll(): String {
            return mapOf(
                "privateVal" to privateVal,
                "protectedVal" to protectedVal,
                "publicVal" to publicVal,
                "publicField" to publicField,
                "protectedField" to protectedField,
                "privateField" to privateField,
                "generate" to generate(),
            ).map { "${it.key}: ${it.value}" }
                .joinToString("\n")
        }

        fun printText() {
            privatePrint()
        }

        // 7. объясни, почему эта функция не может быть публичной
        //Ответ: потому что функция возвращает объект вложенного класса ProtectedClass,
        // а этот класс сам имеет модификатор protected
        protected open fun getProtectedClass() = ProtectedClass()
        protected open fun verifyPublicField(value: String): Boolean {
            return value.length < 3
        }

        // 8. Распечатай getAll() и объясни, почему в поле "generate" другой текст
        //Ответ: потому что мы переопределили метод в дочернем классе ChildrenClass ? и вызывается именно этот вариант
        open fun generate(): String {
            return "Это генерация из родительского класса"
        }

        private fun privatePrint() {
            println("Печать из класса BaseClass")
        }

        // 9. объясни, почему эта функция не может быть публичной или protected
        //Ответ: т.к. функция возвращает приватный объект private class PrivateClass() {} ?
        private fun getPrivateClass() = PrivateClass()

        protected class ProtectedClass() {}
        private class PrivateClass() {}
    }

    class ChildrenClass(
        val privateVal: String,
        protectedVal: String,

        // 10. объясни, почему этот аргумент доступен в main() несмотря на то, что это не поле
        //Ответ: Аргумент publicVal передаётся в родительский класс BaseClass, где создаётся публичное поле publicVal.
        // Поэтому в main() мы обращаемся к унаследованному полю родителя
        publicVal: String
    ) : BaseClass(privateVal, protectedVal, publicVal) {

        //п.4
        override fun verifyPublicField(value: String): Boolean {
            return true
        }

        //п.5
        fun updateProtectedField(newValue: String) {
            protectedField = newValue
        }

// 11. объясни, почему в main() доступна функция getAll() хотя её здесь нет
    //Ответ:потому что ChildrenClass унаследовала этот метод от BaseClass.
    // Даже если метод не объявлен явно в дочернем классе, наследование позволяет вызывать его через объект дочернего класса.

// 12. проверь, что выводится на печать при вызове функции printText()
// и объясни, почему не происходит переопределение метода privatePrint()
    //Ответ: выводится "Печать из класса BaseClass".
    //Метод privatePrint() в BaseClass private, значит он видим только внутри BaseClass.
        private fun privatePrint() {
            println("Печать из класса ChildrenClass")
        }

        override fun generate(): String {
            return "Это генерация из дочернего класса"
        }

    }

fun main() {
    val child = ChildrenClass("a", "b", "c")
    println(child.privateVal)

    //Проверим п.3
    child.publicField = "Антонио Бандерас"
    println(child.getAll())

    //Проверим п.5
    child.updateProtectedField("Новое значение")
    println(child.getAll())

    //Проверим п.7
    child.printText()

}