package server;

/**
 * Основной класс программы запускающий работу сервера
 */
public class App {

    /**
     * Точка входа в программу
     *
     * @param args принимает аргументы передаваемые JVM
     */
    public static void main(String[] args) {
        Server server = new Server();
        Thread thread = new Thread(new ServerCommand());
        thread.start();
        server.run();
    }
}
