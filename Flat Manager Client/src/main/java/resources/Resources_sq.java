package resources;

import java.util.ListResourceBundle;

public class Resources_sq extends ListResourceBundle {

    private static Object[][] contents = {
            {"Ошибка отправки команды на сервер!", "Gabim në dërgimin e komandës në server!"},
            {"Неправильно введен ключ!", "Çelësi u fut gabimisht!"},
            {"Неопознанная команда. Наберите 'help' для получения справки по доступным командам.", "Komanda e paidentifikuar. Shkruani 'help' për ndihmë në komandat e disponueshme."},
            {"Отсутствует аргумент.", "Argumenti i humbur."},
            {"Введите данные до конца!", "Vendosni të dhënat deri në fund!"},
            {"Неправильный формат площади!", "Formë katrore e gabuar!"},
            {"Неправильный формат количества комнат!", "Formati i gabuar për numrin e dhomave!"},
            {"Неправильный формат координаты x!", "Formati i gabuar i koordinatave x!"},
            {"Неправильный формат координаты y!", "Formati i gabuar i koordinatave y!"},
            {"Неправильно задано качество обстановки!", "Cilësia e mjedisit është vendosur gabimisht!"},
            {"Неправильно задано поле зрения!", "Fusha e shikimit është vendosur gabimisht!"},
            {"Неправильно задан вид транспорта!", "Modaliteti i transportit është konfiguruar gabimisht!"},
            {"Неправильный формат возраста дома!", "Formati i gabuar i moshës së shtëpisë!"},
            {"Неправильны коли формат количества квартир на этаже!", "Format i gabuar për numrin e apartamenteve në dysheme!"},
            {"Данные введены неверно!", "Të dhënat janë futur gabimisht!"},
            {"Соединение с сервером установлено!", "Lidhja me serverin është vendosur!"},
            {"Ошибка соединения с сервером!", "Gabim i lidhjes së serverit!"},
            {"Неправильный формат!", "Formati i pasaktë!"},
            {"Неверный формат аргумента!", "Formati i pavlefshëm i argumentit!"},
            {"Имя создателя: ", "Emri i krijuesit:"},
            {"Имя: ", "Emri:"},
            {"Дата создания: ", "Data e krijuar: "},
            {"Координата X: ", "Koordinata X: "},
            {"Координата Y: ", "Koordinata Y: "},
            {"Площадь: ", "Zona: "},
            {"Количество комнат: ", "Numri i dhomave: "},
            {"Качество обстановки: ", "Mobilimi: "},
            {"Видимость: ", "Pamja: "},
            {"Транспорт: ", "Transporti: "},
            {"Имя дома: ", "Emri i shtëpisë: "},
            {"Возраст дома: " , "Viti i shtëpisë: "},
            {"Количество квартир: ", "Numri i shtëpisë së banesave: "},
            {"Введите логин и пароль!", "Vendos hyrjen dhe fjalëkalimin!"},
            {"Соединение с сервером разорвано!", "Lidhja me serverin u ndërpre!"},
            {"Выберите строку!", "Ju lutem zgjidhni një rresht!"},
            {"Соединение с сервером восстановлено!", "Lidhja me serverin u rikuperua!"},
            {"Введите данные о квартире:", "Fut detajet e banesës:"},
            {"Имя:", "Emri:"},
            {"Площадь:", "Zona:"},
            {"Количество комнат:", "Numri i dhomave:"},
            {"Координата X:", "Koordinata X:"},
            {"Координата Y:", "Koordinata Y:"},
            {"Качество обстановки:", "Cilësia e mobiljeve:"},
            {"Поле зрения:", "Vija e shikimit:"},
            {"Вид транспорта:", "Lloji i transportit:"},
            {"Имя дома:", "Emri i shtëpisë:"},
            {"Возраст дома:", "Mosha e shtëpisë:"},
            {"Количество квартир на этаже:", "Numri i apartamenteve për kat:"},
            {"Назад", "Kthehu"},
            {"Таблица элементов коллекции:", "Tabela e elementeve të koleksionit:"},
            {"Удалить", "Fshi"},
            {"Изменить", "Redakto"},
            {"Обновить", "Përditëso"},
            {"Фильтр", "Filtër"},
            {"Консольные команды", "Komandat e konsolës"},
            {"Таблица", "Tabela"},
            {"Визуализация", "Paraqitje"},
            {"Введите порт", "Hyni në port"},
            {"Авторизация", "Autorizimi"},
            {"Вход", "Hyrja"},
            {"Регистрация", "Kontrolloni"}
    };

    @Override
    protected Object[][] getContents() {
        return contents;
    }
}
