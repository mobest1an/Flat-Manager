package tools;

import lab.Flat;

import java.io.Serializable;
import java.util.TreeMap;

/**
 * Класс для передачи ответа на запрос клиента
 */
public class Message implements Serializable {

    private String message;
    private int authorizationCondition;
    private Flat flat;
    private Flat[] flatCollection;

    public Flat getFlat() {
        return flat;
    }

    public void setFlat(Flat flat) {
        this.flat = flat;
    }

    public int getAuthorizationCondition() {
        return authorizationCondition;
    }

    public void setAuthorizationCondition(int authorizationCondition) {
        this.authorizationCondition = authorizationCondition;
    }

    public Flat[] getFlatCollection() {
        return flatCollection;
    }

    public void setFlatCollection(Flat[] flatCollection) {
        this.flatCollection = flatCollection;
    }

    /**
     * Установить сообщение для отправки
     *
     * @param message задает сообщение для отправки
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Получить отправленное сообщение
     *
     * @return возвращает сообщение
     */
    public String getMessage() {
        return message;
    }
}
