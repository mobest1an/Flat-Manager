package resources;

import java.util.ListResourceBundle;

public class Resources_sq extends ListResourceBundle {

    private static Object[][] contents = {
            {"Вы успешно вошли в систему!", "Ju jeni regjistruar me sukses!"},
            {"Неправильный логин ose пароль!", "Identifikimi ose fjalëkalimi i pasaktë!"},
            {"Аккаунт успешно krijiminн!", "Llogaria është krijuar me sukses!"},
            {"Пользователь с таким логином уже существует!", "Një përdorues me këtë hyrje ekziston tashmë!"}
    };

    @Override
    protected Object[][] getContents() {
        return contents;
    }
}
