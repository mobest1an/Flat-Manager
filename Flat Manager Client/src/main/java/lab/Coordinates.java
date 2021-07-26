package lab;

import java.io.Serializable;

/**
 * Класс по умолчанию из варианта лабораторной работы
 *
 * @author Erik Karapetyan P3115
 * @version 1.0
 */

public class Coordinates implements Serializable {
    private Long x; //Максимальное значение поля: 235, Поле не может быть null
    private double y;

    /**
     * Конструктор для создания объектов класса для работы с координатами у объекта класса Flat
     *
     * @param x задает положение x в пространстве
     * @param y задает положение y в пространстве
     */

    public Coordinates(Long x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Метод для получения координаты x элемента
     *
     * @return возвращает числовое значение координаты x
     */

    public Long getX() {
        return x;
    }

    /**
     * Метод для получения координаты y элемента
     *
     * @return возвращает числовое значение координаты y
     */

    public double getY() {
        return y;
    }
}
