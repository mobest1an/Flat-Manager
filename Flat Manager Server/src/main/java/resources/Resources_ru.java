package resources;

import java.util.ListResourceBundle;

public class Resources_ru extends ListResourceBundle {

    private static Object[][] contents = {
            {"Вы успешно вошли в систему!", "Вы успешно вошли в систему!"},
            {"Неправильный логин или пароль!", "Неправильный логин или пароль!"},
            {"Аккаунт успешно создан!", "Аккаунт успешно создан!"},
            {"Пользователь с таким логином уже существует!", "Пользователь с таким логином уже существует!"}
    };

    @Override
    protected Object[][] getContents() {
        return contents;
    }
}
