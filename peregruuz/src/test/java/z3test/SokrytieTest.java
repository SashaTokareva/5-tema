package z3test;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class SokrytieTest {
    @Test
    void testPrivateFieldAccess() {
        Class<?> classObj = null;
        try {
            classObj = Class.forName("org.example.z3.Sokritie");
        } catch (ClassNotFoundException e) {
            Assertions.fail("Класс не найден");
        }
        try {
            Object obj = classObj.getConstructor().newInstance();

            Field field = classObj.getDeclaredField("privateField");
            field.setAccessible(true);

            field.set(obj, 100);  // Задаем значение приватного поля

            Method getPrivateField = classObj.getDeclaredMethod("getPrivateField");
            int result = (int) getPrivateField.invoke(obj);  // Получаем значение приватного поля через геттер

            Assertions.assertEquals(100, result, "Значение privateField должно быть 100");

        } catch (NoSuchFieldException | NoSuchMethodException e) {
            Assertions.fail("Не найден метод или поле: " + e.getMessage());
        } catch (IllegalAccessException e) {
            Assertions.fail("Недостаточно прав для доступа к полю или методу");
        } catch (InstantiationException e) {
            Assertions.fail("Ошибка создания экземпляра класса");
        } catch (InvocationTargetException e) {
            Assertions.fail("Ошибка вызова метода: " + e.getCause().getMessage());
        }
    }
}

