package ru.stimmax.lessons.lesson15.homework

//Это класс контейнера. Он абстрактный, это означает, что нельзя создавать экземлпяр этого класса, он нужен только для того, чтобы быть основой для подклассов.
//Создай подклассы этого контейнера, которые будут добавлять строку material (или коллекции или словари строк) в какое-то определённое место (места).

//4. Первый класс должен вставлять строку на дно контейнера (должно появиться под индексом 0)
//5. Второй класс должен получать список строк и вставлять их в начало контейнера но поочерёдно с теми данными, которые уже есть.
// То-есть, наш список должен появиться в контейнере по индексам 0, 2, 4 и так далее.
//6. Третий класс при добавлении строки должен отсортировать весь список метиралов в алфавитном порядке включая добавляемый материал.
//7. Четвёртый класс должен принимать словарь (ключи и значения строки). Каждая пара ключа и значения должна попадать в контейнер следующим образом - ключ в начало, значение в конец.
// Таким образом в начале должны быть ключи в обратном порядке, потом существующие материалы, потом все значения.

//4
abstract class Materials {
    private val materials = mutableListOf<String>()
    fun addMaterial(material: String) {
        materials.add(material)
    }

    fun extractMaterials(): List<String> {
        val extracted = materials.toList()
        materials.clear()
        return extracted
    }

    fun printContainer() {
        materials.forEachIndexed { index, layer ->
            println("[$index]: $layer")
        }
    }
}

class AddBeginningFromZero : Materials() {
    fun addItem(material: String) {
        val materialsList = extractMaterials() //вытаскиваем старые
        val newMaterialList = mutableListOf<String>()
        newMaterialList.add(material) //добавили новый, чтоб был индекс 0
        materialsList.forEach { newMaterialList.add(it) }
        newMaterialList.forEach { addMaterial(it) } //возвращаем всё обратно
    }

//5.
class AddBeginning: Materials(){
    fun getItem(materialGet:List<String>){
        val oldMaterials = extractMaterials()
        val newMaterialsList = mutableListOf<String>()
        val maxSizeList = maxOf(oldMaterials.size, materialGet.size)
        for (i in 0 until maxSizeList){
            if (i < materialGet.size){     // есть ли элемент с таким индексом в списке
                newMaterialsList.add(materialGet[i])
            }
            if (i < oldMaterials.size){
                newMaterialsList.add(oldMaterials[i])
            } else continue
        }
        newMaterialsList.forEach { addMaterial(it) }
    }
}

//6.
 class SortMaterials: Materials() {
    fun sortItem(newItem:String) {
        val materialsList = extractMaterials().toMutableList()
        materialsList.add(newItem)
        materialsList.sort()
        materialsList.forEach { addMaterial(it) }
    }
}

//7. пока не делала
}