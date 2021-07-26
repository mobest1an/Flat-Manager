package client;

import resources.ResourceController;
import tools.Request;
import java.util.Scanner;

/**
 * Класс реализующий выборку команды для отправки на сервер и получения ответа
 */
public class UserAction {

    /**
     * Метод реализующий выборку команды для отправки на сервер и получения ответа
     */
    public static String consoleMoves(String userCommand, RequestSender requestSender, String login, String password, boolean isRegistered, ResourceController resourceController) {
        String[] userCommandPart;
        Request request;
        userCommandPart = userCommand.toLowerCase().trim().split(" ", 2);
        if (userCommandPart[0].equals("exit")) {
            System.exit(0);
        }
        try {
            switch (userCommandPart[0]) {
                case "":
                    break;
                case "help":
                case "show":
                case "info":
                case "clear":
                case "history":
                case "min_by_house":
                    request = new Request(userCommandPart[0], resourceController.getMainResourceBundle().getBaseBundleName());
                    request.setLogin(login);
                    request.setPassword(password);
                    request.setRegistered(isRegistered);
                    if (requestSender.sendRequest(request))
                        return requestSender.getAnswer().getMessage();
                    else {
                        ConnectionStatus.setConnectionStatus(false);
                        return "Ошибка отправки команды на сервер!";
                    }
                case "remove":
                case "remove_key":
                case "remove_lower":
                    userCommandPart[1] = userCommandPart[1].trim();
                    try {
                        request = new Request(userCommandPart[0], Integer.parseInt(userCommandPart[1]), resourceController.getMainResourceBundle().getBaseBundleName());
                        request.setLogin(login);
                        request.setPassword(password);
                        request.setRegistered(isRegistered);
                        if (requestSender.sendRequest(request))
                            return requestSender.getAnswer().getMessage();
                        else {
                            ConnectionStatus.setConnectionStatus(false);
                            return resourceController.getMainResourceBundle().getString("Ошибка отправки команды на сервер!");
                        }
                    } catch (NumberFormatException e) {
                        return resourceController.getMainResourceBundle().getString("Неправильно введен ключ!");
                    }
                case "replace_if_lower":
                    userCommandPart[1] = userCommandPart[1].trim();
                    userCommandPart[2] = userCommandPart[2].trim();
                    try {
                        request = new Request(userCommandPart[0], Integer.parseInt(userCommandPart[1]), Integer.parseInt(userCommandPart[2]), resourceController.getMainResourceBundle().getBaseBundleName());
                        request.setLogin(login);
                        request.setPassword(password);
                        request.setRegistered(isRegistered);
                        if (requestSender.sendRequest(request))
                            return requestSender.getAnswer().getMessage();
                        else {
                            ConnectionStatus.setConnectionStatus(false);
                            return resourceController.getMainResourceBundle().getString("Ошибка отправки команды на сервер!");
                        }
                    } catch (NumberFormatException e) {
                        return resourceController.getMainResourceBundle().getString("Неправильно введен ключ!");
                    }
                case "execute_script":
                case "count_by_furnish":
                case "count_greater_than_furnish":
                    userCommandPart[1] = userCommandPart[1].trim();
                    request = new Request(userCommandPart[0], userCommandPart[1], resourceController.getMainResourceBundle().getBaseBundleName());
                    request.setLogin(login);
                    request.setPassword(password);
                    request.setRegistered(isRegistered);
                    if (requestSender.sendRequest(request))
                        return requestSender.getAnswer().getMessage();
                    else {
                        ConnectionStatus.setConnectionStatus(false);
                        return resourceController.getMainResourceBundle().getString("Ошибка отправки команды на сервер!");
                    }
                default:
                    return resourceController.getMainResourceBundle().getString("Неопознанная команда. Наберите 'help' для получения справки по доступным командам.");
            }
        } catch (ArrayIndexOutOfBoundsException ex) {
            return resourceController.getMainResourceBundle().getString("Отсутствует аргумент.");
        }
        return null;
    }
}
