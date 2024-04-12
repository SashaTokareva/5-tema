package z2test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ShapeTest {
    @Test
    void testCalculateArea() {
        Class<?> circleClass, rectangleClass, triangleClass;
        try {
            circleClass = Class.forName("org.example.z2.Circle");
            rectangleClass = Class.forName("org.example.z2.Rectangle");
            triangleClass = Class.forName("org.example.z2.Triangle");
        } catch (ClassNotFoundException e) {
            Assertions.fail("Один из классов не найден");
            return;
        }

        try {
            Constructor<?> circleConstructor = circleClass.getConstructor(double.class);
            Object circle = circleConstructor.newInstance(5.0);
            Method circleAreaMethod = circleClass.getMethod("calculateArea");
            circleAreaMethod.setAccessible(true);
            double circleArea = (double) circleAreaMethod.invoke(circle);
            Assertions.assertEquals(Math.PI * 25, circleArea, 0.01);

            Constructor<?> rectangleConstructor = rectangleClass.getConstructor(double.class, double.class);
            Object rectangle = rectangleConstructor.newInstance(4.0, 5.0);
            Method rectangleAreaMethod = rectangleClass.getMethod("calculateArea");
            rectangleAreaMethod.setAccessible(true);
            double rectangleArea = (double) rectangleAreaMethod.invoke(rectangle);
            Assertions.assertEquals(20.0, rectangleArea, 0.01);

            Constructor<?> triangleConstructor = triangleClass.getConstructor(double.class, double.class);
            Object triangle = triangleConstructor.newInstance(6.0, 7.0);
            Method triangleAreaMethod = triangleClass.getMethod("calculateArea");
            triangleAreaMethod.setAccessible(true);
            double triangleArea = (double) triangleAreaMethod.invoke(triangle);
            Assertions.assertEquals(21.0, triangleArea, 0.01);

        } catch (NoSuchMethodException e) {
            Assertions.fail("обязательный метод не найден: " + e.getMessage());
        } catch (IllegalAccessException e) {
            Assertions.fail("доступ в метод невозможен: " + e.getMessage());
        } catch (InstantiationException | InvocationTargetException e) {
            Assertions.fail("ошибка инстанцирования: " + e.getCause().getMessage());
        }
    }
}
