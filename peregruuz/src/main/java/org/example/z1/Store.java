package org.example.z1;

// Задача: Напишите программу для учета продаж в магазине.
// В магазине продаются различные товары: книги, музыкальные альбомы и фильмы.
// Каждый товар имеет свой уникальный идентификатор, название и цену.
// Напишите класс Store, который содержит методы для добавления нового товара в магазин
// и вывода информации о проданных товарах.
// Реализуйте перегрузку методов для разных типов товаров.

public class Store {
    public void addProduct(String productId, String productName, double price) {
        System.out.println("Добавлен товар: " + productId + ", " + productName + ", Цена: $" + price);
    }

    public void addProduct(String productId, String productName, String artist, double price) {
        System.out.println("Добавлен музыкальный альбом: " + productId + ", " + productName + ", Исполнитель: " + artist + ", Цена: $" + price);
    }

    public void addProduct(String productId, String productName, int duration, double price) {
        System.out.println("Добавлен фильм: " + productId + ", " + productName + ", Продолжительность: " + duration + " мин., Цена: $" + price);
    }
}
