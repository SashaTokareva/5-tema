package org.example.z4;

//Задача: Управление доступом к настройкам
//В этом задании вам необходимо реализовать базовый класс SystemSettings и подкласс UserSettings,
// которые используют статические методы для предоставления информации о настройках системыи пользователя соответственно.
// Методы в подклассе должны "скрыть" одноименные статические методы базового класса.

//Детали реализации

//Класс SystemSettings
//Создайте статический метод displaySettings(), который выводит общие настройки системы.

//Класс UserSettings
//Наследуйте от SystemSettings.
//"Скройте" метод displaySettings(), реализовав в нём вывод пользовательских настроек.





//решение
public class SystemSettings {
    public static void displaySettings() {
        System.out.println("System Configuration: Operating System, Memory");
    }
}

