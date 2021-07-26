package server;

import control.DataBaseManager;
import resources.ResourceController;
import tools.Request;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class UserHandler {

    private Request request;
    private DataBaseManager manager;
    private HashMap<String, String> usersInfo;
    private int authorizationCondition;
    private String resourceBundleName;

    public UserHandler(Request request, DataBaseManager manager, String resourceBundleName) {
        this.request = request;
        this.manager = manager;
        this.resourceBundleName = resourceBundleName;
        usersInfo = manager.getUsers();
    }

    public String checkUsers() {
        long loginsCount = usersInfo.entrySet().stream().filter(p -> p.getKey().equals(request.getLogin())).count();
        if (request.isRegistered()) {
            Optional<Map.Entry<String, String>> optional = usersInfo.entrySet().stream().filter(p -> {
                if (p.getKey().equals(request.getLogin()) && p.getValue().equals(request.getPassword())) {
                    setAuthorized(0);
                    return true;
                } else {
                    setAuthorized(-1);
                    return false;
                }
            }).findFirst();
            if (optional.isPresent()) {
                return ResourceController.getResourceByName(resourceBundleName).getString("Вы успешно вошли в систему!");
            } else {
                return ResourceController.getResourceByName(resourceBundleName).getString("Неправильный логин или пароль!");
            }
        } else {
            if (loginsCount == 0) {
                manager.addUser(request.getLogin(), request.getPassword());
                setAuthorized(0);
                return ResourceController.getResourceByName(resourceBundleName).getString("Аккаунт успешно создан!");
            } else {
                setAuthorized(-1);
                return ResourceController.getResourceByName(resourceBundleName).getString("Пользователь с таким логином уже существует!");
            }
        }
    }

    public int isAuthorized() {
        return authorizationCondition;
    }

    private void setAuthorized(int authorizationCondition) {
        this.authorizationCondition = authorizationCondition;
    }
}
