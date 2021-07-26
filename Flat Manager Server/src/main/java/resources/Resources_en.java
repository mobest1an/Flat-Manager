package resources;

import java.util.ListResourceBundle;

public class Resources_en extends ListResourceBundle {

    private static Object[][] contents = {
            {"Вы успешно вошли в систему!", "You are successfully logged in!"},
            {"Неправильный логин или пароль!", "Incorrect login or password!"},
            {"Аккаунт успешно создан!", "Account has been successfully created!"},
            {"Пользователь с таким логином уже существует!", "A user with this login already exists!"}
    };

    @Override
    protected Object[][] getContents() {
        return contents;
    }
}
