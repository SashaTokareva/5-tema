package z1test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;

public class StoreTest {
    @Test
    void testAddProductMethods() {
        Class<?> classObj = null;
        try {
            classObj = Class.forName("org.example.z1.Store");
        } catch (ClassNotFoundException e) {
            Assertions.fail("Класс не найден");
            return;
        }
        try {
            Object store = classObj.getConstructor().newInstance();

            // Перенаправление System.out в ByteArrayOutputStream для захвата вывода
            ByteArrayOutputStream outContent = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outContent));

            // Проверка метода добавления обычного товара
            Method addProduct1 = classObj.getMethod("addProduct", String.class, String.class, double.class);
            addProduct1.invoke(store, "001", "Ноутбук", 1200.00);
            Assertions.assertEquals("Добавлен товар: 001, Ноутбук, Цена: $1200.0", outContent.toString().trim());

            outContent.reset(); // Очистка содержимого потока

            // Проверка метода добавления музыкального альбома
            Method addProduct2 = classObj.getMethod("addProduct", String.class, String.class, String.class, double.class);
            addProduct2.invoke(store, "002", "Thriller", "Michael Jackson", 15.99);
            Assertions.assertEquals("Добавлен музыкальный альбом: 002, Thriller, Исполнитель: Michael Jackson, Цена: $15.99", outContent.toString().trim());

            outContent.reset(); // Очистка содержимого потока

            // Проверка метода добавления фильма
            Method addProduct3 = classObj.getMethod("addProduct", String.class, String.class, int.class, double.class);
            addProduct3.invoke(store, "003", "Star Wars", 120, 29.99);
            Assertions.assertEquals("Добавлен фильм: 003, Star Wars, Продолжительность: 120 мин., Цена: $29.99", outContent.toString().trim());

        } catch (Exception e) {
            Assertions.fail("Ошибка при вызове метода: " + e.getMessage());
        } finally {
            System.setOut(System.out); // Возвращаем стандартный вывод на место
        }
    }
}

