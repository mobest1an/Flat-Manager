package tools;

import lab.Flat;

import java.io.Serializable;

/**
 * Класс команды для отправки на сервер
 */
public class Request implements Serializable {

    private String name;
    private int key;
    private int replaced;
    private String textKey;
    private Flat flat;
    private String login;
    private String password;
    private boolean isRegistered;
    private String resourceBundleName;

    public String getResourceBundleName() {
        return resourceBundleName;
    }

    public void setResourceBundleName(String resourceBundleName) {
        this.resourceBundleName = resourceBundleName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRegistered(boolean registered) {
        isRegistered = registered;
    }

    public Request(String name, String login, String password, boolean isRegistered, String resourceBundleName) {
        this.name = name;
        this.login = login;
        this.password = password;
        this.isRegistered = isRegistered;
        this.resourceBundleName = resourceBundleName;
    }

    /**
     * Конструктор для команды без аргументов
     *
     * @param name принимает имя команды
     */
    public Request(String name, String resourceBundleName) {
        this.name = name;
        this.resourceBundleName = resourceBundleName;
    }

    /**
     * Конструтор для команды с числовым аргументом
     *
     * @param name принимает имя команды
     * @param key  принимает числовой аргумент
     */
    public Request(String name, int key, String resourceBundleName) {
        this.name = name;
        this.key = key;
        this.resourceBundleName = resourceBundleName;
    }

    /**
     * Конструтор для команды с двумя числовыми аргументами
     *
     * @param name     принимает имя команды
     * @param key      принимает числовой аргумент
     * @param replaced принимает второй числовой аргумент
     */
    public Request(String name, int key, int replaced, String resourceBundleName) {
        this.name = name;
        this.key = key;
        this.replaced = replaced;
        this.resourceBundleName = resourceBundleName;
    }

    /**
     * Конструтор для команды с текстовым аргументом
     *
     * @param name    принимает имя команды
     * @param textKey принимает текстовый аргумент
     */
    public Request(String name, String textKey, String resourceBundleName) {
        this.name = name;
        this.textKey = textKey;
        this.resourceBundleName = resourceBundleName;
    }

    /**
     * Конструтор для команды с объектом класса, которым управляет коллекция
     *
     * @param name принимает имя команды
     * @param flat принимает объект класса
     * @param key  принимает ключ для добавления в коллекцию
     */
    public Request(String name, Flat flat, int key, String resourceBundleName) {
        this.name = name;
        this.flat = flat;
        this.key = key;
        this.resourceBundleName = resourceBundleName;
    }

    /**
     * Получает имя команды
     *
     * @return возвращает имя
     */
    public String getName() {
        return name;
    }

    /**
     * Получает числовой аргумент команды
     *
     * @return возвращает числовой аргумент команды
     */
    public int getKey() {
        return key;
    }

    /**
     * Получает второй числовой аргумент команды
     *
     * @return возвращает второй числовой аргумент команды
     */
    public int getReplaced() {
        return replaced;
    }

    /**
     * Получает текстовый аргумент команды
     *
     * @return возвращает текстовый аргумент команды
     */
    public String getTextKey() {
        return textKey;
    }

    /**
     * Получает объект класса, которым управляет коллекция
     *
     * @return возвращает объект класса, которым управляет коллекция
     */
    public Flat getFlat() {
        return flat;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public boolean isRegistered() {
        return isRegistered;
    }
}
