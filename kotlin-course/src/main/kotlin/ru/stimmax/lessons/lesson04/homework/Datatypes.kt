package ru.stimmax.lessons.lesson04.homework

val v1: Int = 42
val v2: Long = 98765432123456789L
val v3: Float = 23.45f
// к значению надо добавить f чтоб было как Float
//val v4: Float = 0.123456789
val v5: String = "Kotlin & Java"
// булевый тип пишется  строчными буквами, false
//val v6: Boolean = FALSE
val v7: Char = 'c'
val v8: Short = 500
val v9: Long = 4294967296L
val v10: Float = 18.0f
val v11: Any = -0.001
val v12: String = "OpenAI"
val v13: String = "true"
// с числами надо указать вместо listOf arrayOf, например val v14: Array<Int> = arrayOf(3,14)
//val v14: = listOf(3, 14)
val v15: Char = '9'
val v16: Short = 2048
val v17: Long = 10000000000L
// со строками надо указать listOf, например val v18: List<String> = listOf("OpenAI", "Quantum Computing")
//val v18 = setOf("OpenAI", "Quantum Computing")
val v19: Float = 5.75f
// здесь одинарные кавычки как у Char, но чар не может быть с точкой
//val v20: `1.414`
val v21: String = "Artificial Intelligence"
// здесь лучше указать тип Any? т.к. есть и Сhar, и String
//val v22 = arrayOf('x', "A")
val v23: String = "Android Studio"
val v24: Char = '@'
val v25: Int = 1024
val v26: Long = 1234567890123L
val v27: Float = 10.01f
val v28: Any = -273.15
val v29: String = "SpaceX"
// булевый тип пишется  строчными буквами, false
// val v30 = FALSE
val v31: Float = 0.007f
// какой-то левый символ, под any не подходит
// val v32 = “🤯”
val v33: Map<String, Int> = mapOf("true" to 2, "false" to 34)
// здесь одинарные кавычки как у Char, но чар не может быть в несколько символов
//val v34 = ‘65535’
val v35: Long = 72057594037927935L
val v36: Float = 2.71828f
val v37: Double = 101.0101
val v38: String = "Quantum Computing"
val v39: Map<Int, String> = mapOf(2 to "true", 34 to "false")
val v40: Char = 'x'
val v41: Int = 314
val v42: Long = 123456789123456789L
val v43: Float = 6.626f
// булевый тип пишется  строчными буквами, true
// val v44 = TRUE


//1. Хранить букву, на которую указывает палец медиума во время спиритического сеанса.
val finger: Char = 'F'
//2. Хранить количество ложек сахара, которые я кладу в одну чашку чая.
val sugarSpoons: Int = 2
//3. Хранить список расходов на доставку еды, чтобы ещё раз убедиться, что готовить было дешевле.
val deliveryCost: Long = 12132322342446L
//4. Хранить длину очереди в столовой до миллиардной доли сантиметра.
val queueLength: Double = 800.883
//5. Хранить факт, закрыт ли баг после того, как его просто переименовали в фичу.
val bugIsClosed: Boolean = false
//6. Хранить количество свистков чайника за день.
val kettleWhistlePerDay: Int = 6
//7. Хранить количество нажатий котом на клавиатуру ноутбука за всё время твоей работы.
val catStomp: Int = 20
//8. Хранить количество попыток пересчитать звёзды на небе за всю историю человечества.
val starCounting: Long = 926474979858985485L
//9. Хранить массу воздуха в спускающем матрасе после нападения кота в долях грамма.
val mattresAir: Float = 1.088f
//10. Хранить словарь «название стартапа → сумму потерь инвесторов».
val epicFail: Map<String,Double> = mapOf("Крутое пике" to 854.7884)
//11. Хранить строку «починилось само», чтобы закрывать тикеты без лишних слов.
val niceJob: String = "Починилось само"
//12. Хранить список тем для митингов, которые на самом деле никому не нужны.
val meetingList: List<String> = listOf("Один","Два","Три")