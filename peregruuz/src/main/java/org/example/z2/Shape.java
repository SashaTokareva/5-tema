package org.example.z2;

//Задача: Создайте иерархию классов для геометрических фигур,
// таких как круг, прямоугольник и треугольник.
// Каждая фигура должна иметь метод calculateArea(), который вычисляет и возвращает площадь фигуры.
// Реализуйте этот метод в каждом классе иерархии,
// переопределяя его в соответствии с конкретной формулой для вычисления площади каждой фигуры.

// Родительский класс для геометрических фигур
abstract class Shape {
    public abstract double calculateArea();
}
