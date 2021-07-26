package resources;

import java.util.ListResourceBundle;

public class Resources_pt extends ListResourceBundle {

    private static Object[][] contents = {
            {"Вы успешно вошли в систему!", "Você foi logado com sucesso!"},
            {"Неправильный логин или пароль!", "Login ou senha incorretos!"},
            {"Аккаунт успешно создан!", "A conta foi criada com sucesso!"},
            {"Пользователь с таким логином уже существует!", "Já existe um usuário com este login!"}
    };

    @Override
    protected Object[][] getContents() {
        return contents;
    }
}
