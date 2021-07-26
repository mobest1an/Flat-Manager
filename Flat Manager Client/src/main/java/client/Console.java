package client;

/**
 * Класс для реализации вывода в консоль информации
 */
public class Console {

    /**
     * Вывод сообщения с переносом строки
     *
     * @param message принимает сообщение для вывода
     */
    public static void println(String message) {
        System.out.println(message);
    }

    /**
     * Вывод сообщения без переноса строки
     *
     * @param message принимает сообщение для вывода
     */
    public static void print(String message) {
        System.out.print(message);
    }
}
