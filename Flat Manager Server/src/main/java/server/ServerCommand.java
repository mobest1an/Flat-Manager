package server;

import control.ConsoleLogger;

import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Класс, работа которого происходит в параллельном потоке, отправляет специальные команды на сервер
 */
public class ServerCommand implements Runnable {

    private ConsoleLogger consoleLogger = new ConsoleLogger(ServerCommand.class);

    /**
     * Подключение и отправка на сервер специальных команд
     */
    @Override
    public void run() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String commandName = "";
            try {
                commandName = scanner.nextLine();
            } catch (NoSuchElementException e) {
                System.exit(0);
            }
            if (commandName.trim().toLowerCase().equals("exit")) {
                consoleLogger.infoLog("Сервер закончил свою работу!");
                System.exit(0);
            } else if (!commandName.trim().toLowerCase().equals("")) {
                consoleLogger.infoLog("Неопознанная команда.");
            }
        }
    }
}
