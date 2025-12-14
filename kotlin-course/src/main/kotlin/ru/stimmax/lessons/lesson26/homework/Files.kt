package ru.stimmax.lessons.lesson26.homework

import java.io.File

fun main() {

// Задача 1
//Создайте текстовый файл workspace/task1/example.txt. Запишите в него строку "Hello, Kotlin!", а затем проверьте, существует ли файл. Реши задачу с использованием scope функции без создания переменной.

        with(File("workspace/task1/example.txt")) {
            parentFile?.mkdirs()
            val file1 = createNewFile()
            writeText("Hello, Kotlin!")
        if (file1) {
            println("Файл был создан")
        } else {
            println("Файл уже существует")
        }
        }

//Задача 2
//Создайте директорию workspace/task2/testDir. Проверьте, является ли она директорией, и выведите её абсолютный путь.

    with(File("workspace/task2/testDir")) {
        mkdir()
        if (isDirectory) {
            println(absolutePath)
        }
    }

//Задача 3
//Создайте директорию workspace/task3/structure. Внутри директории structure создайте папку myDir с двумя вложенными поддиректориями subDir1 и subDir2. Проверьте, что myDir действительно содержит эти поддиректории.
// Используй scope функции для минимизации создания переменных а так же метод file.resolve("myDir") для создания нового объекта File путём добавления к существующему пути ещё одной секции. И так же для других директорий.

    File("workspace/task3/structure").apply {
        val myDir = resolve("myDir").apply {
            mkdir()
            resolve("subDir1").mkdir()
            resolve("subDir2").mkdir()
            val subDirs = listFiles()?.any { it.name.matches(Regex("subDir\\d+")) && it.isDirectory } // метод matches с regex выражением для поиска директорий, которые начинаются на subDir
            println(subDirs)
        }
    }


//Задача 4
//Создайте директорию workspace/task4/temp. Внутри директории temp создайте несколько вложенных файлов и директорий.
// Удалите директорию workspace/task4 со всем содержимым

    File("workspace/task4/temp").apply {
        resolve("subDir1").mkdirs()
        File("workspace/task4/temp/subDir1/wow1.txt").createNewFile()
        resolve("subDir2").mkdirs()
        File("workspace/task4/temp/subDir2/wow2.txt").createNewFile()
        if (parentFile.deleteRecursively()) {
            println("Директория и всё её содержимое удалено")
        } else {
            println("Не удалось удалить директорию")
        }
    }

//Задача 5
//Создайте файл workspace/task5/config/config.txt. запишите в него список параметров (в формате ключ=значение), а затем прочитайте файл и выведите только значения.

    with(File("workspace/task5/config/config.txt")) {
        parentFile?.mkdirs()
        createNewFile()
        val params = listOf(1 to "Один", 2 to "Два")
        val paramsToString = params.joinToString("\n") { "${it.first}=${it.second}" } // соединяем все элементы в одну строку, добавляем переносы
        writeText(paramsToString)
        val text = readText().split("\n")
        val values = text.map { it.split("=") }
        println(values)
    }


//Задача 6
//Пройди по всем вложенным директориям workspace и выведи в консоль сначала пути директорий, а потом пути файлов

    File("workspace")
        .walk()
        .filter { it.isDirectory }.forEach { println(it.absolutePath) }
        println()

    File("workspace")
        .walk()
        .filter { it.isFile }.forEach { println(it.absolutePath) }
        println()


//Задача 7
//Создайте директорию workspace/task7/docs. Проверь, есть ли файл с именем readme.md. Если файла нет, создайте его и запишите текст "This is a README file.".
// Проверьте текст в файле.

    with(File("workspace/task7/docs/readme.md")) {
        parentFile?.mkdirs()
        if (!exists()) { // нет ли такого файла уже
            createNewFile()
            writeText("This is a README file.")
        }
        println(readText())

    }




//Задача 8
//Создайте файлы
//workspace/task8/data/1/4/prod/data14.mysql
//workspace/task8/data/2/3/prod/data23.mysql
//workspace/task8/data/5/2/prod/data52.mysql
//Создайте директорию workspace/task8/backup и скопируйте туда файлы из workspace/task8/data сохраняя структуру директорий.
// Для копирования используй метод copyTo. Для получения относительного пути начиная от data используй relativeTo от пути до файла, передавая в него путь до базовой директории (то-есть data).
// Полученный relative фрагмент можно присоединить к пути бэкапа через resolve и таким образом получить путь назначения копирования, например workspace/task8/backup/1/4/prod/data14.mysql сохраняя весь относительный путь.

    // не делала
}