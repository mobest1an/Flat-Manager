package lab;

import java.io.Serializable;
import java.time.ZonedDateTime;

/**
 * Класс по умолчанию из варианта лабораторной работы
 *
 * @author Erik Karapetyan P3115
 * @version 1.0
 */

public class Flat implements Serializable {
    private String userName;
    private Integer id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private ZonedDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Integer area; //Максимальное значение поля: 700, Значение поля должно быть больше 0
    private Integer numberOfRooms; //Значение поля должно быть больше 0
    private Furnish furnish; //Поле может быть null
    private View view; //Поле не может быть null
    private Transport transport; //Поле может быть null
    private House house; //Поле не может быть null

    /**
     * Конструктор для создания объектов класса для хранения его в коллекции
     *
     * @param id            задает id
     * @param name          задает имя
     * @param coordinates   создает объект класса Coordinates для хранения и работы с ним
     * @param creationDate  задает дату и время создания объекта
     * @param area          задает площадь
     * @param numberOfRooms задает количество комнат
     * @param furnish       задает тип Furnish для хранения
     * @param view          задает тип View для хранения
     * @param transport     задает тип Transport для хранения
     * @param house         создает объект класса House для хранения и работы с ним
     */

    public Flat(String userName, Integer id, String name, Coordinates coordinates, ZonedDateTime creationDate,
                Integer area, Integer numberOfRooms, Furnish furnish, View view, Transport transport, House house) {
        this.userName = userName;
        this.id = id;
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = creationDate;
        this.area = area;
        this.numberOfRooms = numberOfRooms;
        this.furnish = furnish;
        this.view = view;
        this.transport = transport;
        this.house = house;
    }

    public String getUserName() {
        return userName;
    }

    /**
     * Метод для получения id элемента
     *
     * @return возвращает числовое значение id
     */
    public Integer getId() {
        return id;
    }

    /**
     * Метод для присваивания id элементу
     *
     * @param id принимает числовое значение id для присваивания элементу
     */

    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Метод для получения имени элемента
     *
     * @return возвращает строковое значение имени
     */

    public String getName() {
        return name;
    }

    /**
     * Метод для получения данных об объекте класса Coordinates в элементе
     *
     * @return возвращает строковое значение координат x и y
     */

    public String getCoordinates() {
        return coordinates.getX() + "; " + coordinates.getY();
    }

    /**
     * Метод для получения даты и времени создания элемента
     *
     * @return возвращает дату и время создания элемента в формате ZonedDateTime
     */

    public ZonedDateTime getCreationDate() {
        return creationDate;
    }

    /**
     * Метод для получения площади элемента
     *
     * @return возвращает числовое значение площади
     */

    public Integer getArea() {
        return area;
    }

    /**
     * Метод для получения количества комнат элемента
     *
     * @return возвращает числовое значение количества комнат
     */

    public Integer getNumberOfRooms() {
        return numberOfRooms;
    }

    /**
     * Метод для получения типа обстановки элемента
     *
     * @return возвращает тип обстановки в формате Furnish
     */

    public String getFurnish() {
        return furnish.name();
    }

    /**
     * Метод для получения типа поля зрения элемента
     *
     * @return возвращает тип поля зрения в строковом формате
     */

    public String getView() {
        return view.name();
    }

    /**
     * Метод для получения типа транспорта элемента
     *
     * @return возвращает тип транспорта в в строковом формате
     */

    public String getTransport() {
        return transport.name();
    }

    /**
     * Метод для получения данных об объекте класса House в элементе
     *
     * @return возвращает строковую информацию об имени, возрасте и количестве квартир на этаже дома
     */

    public String getHouse() {
        return house.getName() + "; " + house.getYear() + "; " + house.getNumberOfFlatsOnFloor();
    }
}
