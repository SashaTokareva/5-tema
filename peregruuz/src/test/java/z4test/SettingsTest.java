package z4test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.lang.reflect.Method;



import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


public class SettingsTest {

    @Test
    void testDisplaySettings() {
        Class<?> systemSettingsClass = null;
        Class<?> userSettingsClass = null;
        try {
            systemSettingsClass = Class.forName("org.example.z4.SystemSettings");
            userSettingsClass = Class.forName("org.example.z4.UserSettings");
        } catch (ClassNotFoundException e) {
            Assertions.fail("Класс не найден: " + e.getMessage());
        }

        try {
            Method systemMethod = systemSettingsClass.getDeclaredMethod("displaySettings");
            Method userMethod = userSettingsClass.getDeclaredMethod("displaySettings");

            // Перенаправляем стандартный вывод в наш поток для проверки
            ByteArrayOutputStream systemOutContent = new ByteArrayOutputStream();
            ByteArrayOutputStream userOutContent = new ByteArrayOutputStream();
            PrintStream originalOut = System.out;

            // Проверка вывода от SystemSettings
            System.setOut(new PrintStream(systemOutContent));
            systemMethod.invoke(null); // static method doesn't need an instance
            System.setOut(originalOut);
            String systemOutput = systemOutContent.toString().trim();
            Assertions.assertEquals("System Configuration: Operating System, Memory", systemOutput);

            // Проверка вывода от UserSettings
            System.setOut(new PrintStream(userOutContent));
            userMethod.invoke(null); // static method doesn't need an instance
            System.setOut(originalOut);
            String userOutput = userOutContent.toString().trim();
            Assertions.assertEquals("User Configuration: Theme, Language", userOutput);

        } catch (NoSuchMethodException e) {
            Assertions.fail("метод не найден: " + e.getMessage());
        } catch (Exception e) {
            Assertions.fail("Ошибка при вызове метода: " + e.getMessage());
        } finally {
            System.setOut(System.out);
        }
    }
}


