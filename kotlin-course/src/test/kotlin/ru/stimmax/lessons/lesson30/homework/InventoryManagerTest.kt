package ru.stimmax.lessons.lesson30.homework

import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows


// Получилось 9 тестов

class InventoryManagerTest {

    private lateinit var inventory: InventoryManager

    @BeforeEach
    fun setUp() {
            inventory = InventoryManager(capacity = 10)
        }

    @AfterEach
    fun tearDown() {

    }

    @Test
    fun returnCorrectItemCount () {
        inventory.addItem("томат", 2)

    val count = inventory.getItemCount("томат")
        assertEquals(2,count)
}

    @Test
    fun returnNullItemCount () {

        val count = inventory.getItemCount("томат")
        assertEquals(0,count)
    }


    @Test
    fun addItemAddsNewItem () {
        inventory.addItem("тест", 1)
        assertEquals(1, inventory.getItemCount("тест"))
    }

    @Test //добавляем один и тот же айтем
    fun addItemAddsSameItemWithCorrectQuantity () {
        inventory.addItem("тест", 1)
        inventory.addItem("тест", 1)
        assertEquals(2, inventory.getItemCount("тест"))
    }

    @Test //удаление айтем верно удаляет
    fun removeItemRemovesCorrectItemQuantity () {
        inventory.addItem("тест", 1)
       val result =  inventory.removeItem("тест",1)
        assertTrue (result)
        assertEquals(0,inventory.getItemCount("тест"))
    }

    @Test //удаление не происходит, когда нет такого айтема
    fun removeItemFalseWhenNoItem() {
        val result =  inventory.removeItem("тест",1)
        assertFalse (result)
        assertEquals(0,inventory.getItemCount("тест"))
    }

    @Test //удаление не происходит, когда неверное кол-во
    fun removeItemFalseWhenWrongQuantity() {
        inventory.addItem("тест", 1)
        val result =  inventory.removeItem("тест",2)
        assertFalse (result)
        assertEquals(1,inventory.getItemCount("тест"))
    }

    @Test //проверим через addItem, что capacity не превышено и item добавляется
    fun checkCapacityWithAddItemNotExceeded ()
    {
        val inventory = InventoryManager(5)
        inventory.addItem("тест", 2)
        inventory.addItem("тест", 2)
        assertEquals(4, inventory.getItemCount("тест"))
    }

    @Test //проверим, что capacity превышено
    fun checkCapacityWithAddItemExceeded ()
    {
        val inventory = InventoryManager(3)
        inventory.addItem("тест", 2)
        assertThrows<IllegalStateException> {
            inventory.addItem("тест", 2)
        }


    }

}