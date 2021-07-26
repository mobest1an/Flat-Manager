package server;

import tools.Request;
import control.*;
import control.ConsoleLogger;
import tools.Message;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * Класс для обработки команды
 */
public class CommandHandler implements Callable<Message> {

    private String[] userCommandPart = new String[2];
    private Message message;
    private List<String> history = new ArrayList<>();
    private ConsoleLogger consoleLogger = new ConsoleLogger(CommandHandler.class);
    private Request request;
    private CollectionController controller;
    private DataBaseManager manager;
    private boolean isAuth;

    public void setServiceData(Request request, CollectionController controller, DataBaseManager manager, boolean isAuth) {
        this.request = request;
        this.controller = controller;
        this.manager = manager;
        this.isAuth = isAuth;
    }

    /**
     * Метод, реализующий выборку действий в зависимости от команды
     */
    public void handleRequest() {
        message = new Message();
        if (isAuth) {
            UserHandler userHandler = new UserHandler(request, manager, request.getResourceBundleName());
            message.setMessage(userHandler.checkUsers());
            message.setAuthorizationCondition(userHandler.isAuthorized());
        } else {
            userCommandPart[0] = request.getName();
            if (history.size() < 14) {
                if (!userCommandPart[0].equals("table")) {
                    history.add(userCommandPart[0]);
                }
            } else {
                if (!userCommandPart[0].equals("table")) {
                    history.add(userCommandPart[0]);
                    history.remove(0);
                }
            }
            switch (userCommandPart[0]) {
                case "":
                    break;
                case "remove":
                    message.setMessage(controller.remove(request.getKey(), request.getLogin()));
                    break;
                case "table":
                    message.setFlatCollection(controller.getFlatCollection());
                    break;
                case "help":
                    message.setMessage(controller.help());
                    break;
                case "info":
                    message.setMessage(controller.toString());
                    break;
                case "show":
                    message.setMessage(controller.show(request.getLogin()));
                    break;
                case "insert":
                    message.setMessage(controller.insert(request.getKey(), request.getFlat(), request.getLogin()));
                    break;
                case "update":
                    message.setMessage(controller.update(request.getKey(), request.getFlat(), request.getLogin()));
                    message.setFlat(controller.getUpdateFlat());
                    break;
                case "remove_key":
                    message.setMessage(controller.remove_key(request.getKey(), request.getLogin()));
                    break;
                case "clear":
                    message.setMessage(controller.clear(request.getLogin()));
                    break;
                case "execute_script":
                    message.setMessage(controller.execute_script(request.getTextKey(), request.getLogin()));
                    break;
                case "remove_lower":
                    message.setMessage(controller.remove_lower(request.getKey(), request.getLogin()));
                    break;
                case "history":
                    StringBuilder builder = new StringBuilder();
                    for (String historyPart : history) {
                        builder.append(historyPart).append("\n");
                        message.setMessage(builder.toString().trim());
                    }
                    break;
                case "replace_if_lower":
                    message.setMessage(controller.replace_if_lower(request.getKey(), request.getReplaced(), request.getLogin()));
                    break;
                case "min_by_house":
                    message.setMessage(controller.min_by_house());
                    break;
                case "count_by_furnish":
                    message.setMessage(controller.count_furnish(request.getTextKey(), false));
                    break;
                case "count_greater_than_furnish":
                    message.setMessage(controller.count_furnish(request.getTextKey(), true));
                    break;
            }
        }
    }

    @Override
    public Message call() {
        handleRequest();
        return message;
    }
}