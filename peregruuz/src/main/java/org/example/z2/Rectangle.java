package org.example.z2;

//реализуйте здесь класс для прямоугольника













// Класс для прямоугольника
public class Rectangle extends Shape {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return width * height;
    }
}
