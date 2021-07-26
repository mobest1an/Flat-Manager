package resources;

import java.util.ListResourceBundle;

public class Resources_en extends ListResourceBundle {

    private static Object[][] contents = {
            {"Ошибка отправки команды на сервер!", "Error sending command to server!"},
            {"Неправильно введен ключ!", "The key was entered incorrectly!"},
            {"Неопознанная команда. Наберите 'help' для получения справки по доступным командам.", "Command not identified. Type 'help' to get help on available commands."},
            {"Отсутствует аргумент.", "Missing argument."},
            {"Введите данные до конца!", "Enter the data to the end!"},
            {"Неправильный формат площади!", "Wrong square shape!"},
            {"Неправильный формат количества комнат!", "Wrong format for the number of rooms!"},
            {"Неправильный формат координаты x!", "Wrong x-coordinate format!"},
            {"Неправильный формат координаты y!", "Wrong y-coordinate format!"},
            {"Неправильно задано качество обстановки!", "The environment quality is set incorrectly!"},
            {"Неправильно задано поле зрения!", "The field of view is set incorrectly!"},
            {"Неправильно задан вид транспорта!", "Transport mode is incorrectly configured!"},
            {"Неправильный формат возраста дома!", "Wrong age format of the house!"},
            {"Неправильный формат количества квартир на этаже!", "Wrong format for the number of apartments on the floor!"},
            {"Данные введены неверно!", "Data entered incorrectly!"},
            {"Соединение с сервером установлено!", "The connection to the server has been established!"},
            {"Ошибка соединения с сервером!", "Server connection error!"},
            {"Неправильный формат!", "Incorrect format!"},
            {"Неверный формат аргумента!", "Invalid argument format!"},
            {"Имя создателя: ", "Creator name: "},
            {"Имя: ", "Name: "},
            {"Дата создания: ", "Created date: "},
            {"Координата X: ", "X coordinate: "},
            {"Координата Y: ", "Y coordinate: "},
            {"Площадь: ", "Area: "},
            {"Количество комнат: ", "Number of rooms: "},
            {"Качество обстановки: ", "Furnish: "},
            {"Видимость: ", "View: "},
            {"Транспорт: ", "Transport: "},
            {"Имя дома: ", "House name: "},
            {"Возраст дома: ", "House year: "},
            {"Количество квартир: ", "House number of flats: "},
            {"Введите логин и пароль!", "Enter login and password!"},
            {"Соединение с сервером разорвано!", "The connection to the server was interrupted!"},
            {"Выберите строку!", "Please select a line!"},
            {"Соединение с сервером восстановлено!", "The connection to the server was restored!"},
            {"Введите данные о квартире:", "Enter the apartment details:"},
            {"Имя:", "Name:"},
            {"Площадь:", "Area:"},
            {"Количество комнат:", "Number of rooms:"},
            {"Координата X:", "X coordinate:"},
            {"Координата Y:", "Y coordinate:"},
            {"Качество обстановки:", "Furniture quality:"},
            {"Поле зрения:", "Line of sight:"},
            {"Вид транспорта:", "Transport type:"},
            {"Имя дома:", "House name:"},
            {"Возраст дома:", "Age of house:"},
            {"Количество квартир на этаже:", "Number of apartments per floor:"},
            {"Назад", "Back"},
            {"Таблица элементов коллекции:", "Table of collection elements:"},
            {"Удалить", "Delete"},
            {"Изменить", "Edit"},
            {"Обновить", "Update"},
            {"Фильтр", "Filter"},
            {"Консольные команды", "Console commands"},
            {"Таблица", "Table"},
            {"Визуализация", "Preview"},
            {"Введите порт", "Enter port"},
            {"Авторизация", "Authorization"},
            {"Вход", "Entrance"},
            {"Регистрация", "Check in"}
    };

    @Override
    protected Object[][] getContents() {
        return contents;
    }
}
