package lab;

import java.io.Serializable;

/**
 * Класс по умолчанию из варианта лабораторной работы
 *
 * @author Erik Karapetyan P3115
 * @version 1.0
 */

public class House implements Serializable {
    private String name; //Поле может быть null
    private int year; //Значение поля должно быть больше 0
    private Integer numberOfFlatsOnFloor; //Значение поля должно быть больше 0

    /**
     * Конструктор для создания объектов класса для работы с данными дома у объекта класса Flat
     *
     * @param name                 задает имя
     * @param year                 задает возраст
     * @param numberOfFlatsOnFloor задает количество квартир на этаже
     */

    public House(String name, int year, Integer numberOfFlatsOnFloor) {
        this.name = name;
        this.year = year;
        this.numberOfFlatsOnFloor = numberOfFlatsOnFloor;
    }

    /**
     * Метод для получения имени дома
     *
     * @return возвращает строковое значение имени
     */

    public String getName() {
        return name;
    }

    /**
     * Метод для получения возраста дома
     *
     * @return возвращает числовое значение возраста
     */

    public int getYear() {
        return year;
    }

    /**
     * Метод для получения количества квартир на этаже дома
     *
     * @return возвращает числовое значение количества квартир на этаже
     */

    public Integer getNumberOfFlatsOnFloor() {
        return numberOfFlatsOnFloor;
    }
}
