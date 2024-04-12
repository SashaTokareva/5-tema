package org.example.z5;

//Задача: Калькулятор мероприятий
//Цель: Создать класс EventCalculator, который предоставляет перегруженные методы для расчёта стоимости и времени проведения мероприятий, таких как семинары, конференции и концерты.
//
//Детали реализации
//Класс EventCalculator
//Методы:
//calculateCost(int attendees, double pricePerPerson) — расчитывает стоимость мероприятия на основе количества участников и цены билета на одного человека.
//calculateCost(int attendees, double pricePerPerson, double discount) — перегруженный метод, который также учитывает скидку для больших групп.
//calculateTime(int duration) — возвращает продолжительность мероприятия в часах.
//calculateTime(int startHour, int endHour) — перегруженный метод, который возвращает продолжительность мероприятия на основе времени начала и окончания.















//решение
public class EventCalculator {

    public double calculateCost(int attendees, double pricePerPerson) {
        return attendees * pricePerPerson;
    }

    public double calculateCost(int attendees, double pricePerPerson, double discount) {
        double total = attendees * pricePerPerson;
        return total - (total * discount / 100);
    }

    public int calculateTime(int duration) {
        return duration;
    }

    public int calculateTime(int startHour, int endHour) {
        return endHour - startHour;
    }
}

