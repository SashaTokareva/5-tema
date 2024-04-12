package z5test;

import org.junit.Test;

import org.junit.jupiter.api.Assertions;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;



public class EventCalculatorTest {

    @Test
    public void eventCalculatorTests() {
        Class<?> classObj = null;
        try {
            classObj = Class.forName("org.example.z5.EventCalculator");
        } catch (ClassNotFoundException e) {
            Assertions.fail("Класс не найден");
        }

        try {
            // Создаем экземпляры класса EventCalculator
            Constructor<?> constructor = classObj.getConstructor();
            Object eventCalculatorInstance = constructor.newInstance();

            // Тест 1: Проверка стоимости без скидки
            Method calculateCost = classObj.getMethod("calculateCost", int.class, double.class);
            double result1 = (double) calculateCost.invoke(eventCalculatorInstance, 10, 100);
            Assertions.assertEquals(1000.0, result1, 0.01, "Ошибка в расчете стоимости без скидки");

            // Тест 2: Проверка стоимости со скидкой
            Method calculateCostDiscount = classObj.getMethod("calculateCost", int.class, double.class, double.class);
            double result2 = (double) calculateCostDiscount.invoke(eventCalculatorInstance, 10, 100, 10.0);
            Assertions.assertEquals(900.0, result2, 0.01, "Ошибка в расчете стоимости со скидкой");

            // Тест 3: Проверка продолжительности по длительности
            Method calculateTimeDuration = classObj.getMethod("calculateTime", int.class);
            int result3 = (int) calculateTimeDuration.invoke(eventCalculatorInstance, 3);
            Assertions.assertEquals(3, result3, "Ошибка в расчете времени по длительности");

            // Тест 4: Проверка продолжительности по начальному и конечному времени
            Method calculateTimeStartEnd = classObj.getMethod("calculateTime", int.class, int.class);
            int result4 = (int) calculateTimeStartEnd.invoke(eventCalculatorInstance, 10, 14);
            Assertions.assertEquals(4, result4, "Ошибка в расчете времени по начальному и конечному времени");

        } catch (NoSuchMethodException e) {
            Assertions.fail("Метод не найден");
        } catch (IllegalAccessException e) {
            Assertions.fail("Нет доступа к методу");
        } catch (InstantiationException e) {
            Assertions.fail("Ошибка при создании экземпляра класса");
        } catch (InvocationTargetException e) {
            Assertions.fail("Вызываемый метод вызвал исключение: " + e.getCause().getMessage());
        }
    }
}
