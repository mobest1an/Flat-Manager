package resources;

import java.util.ListResourceBundle;

public class Resources_pt extends ListResourceBundle {

    private static Object[][] contents = {
            {"Ошибка отправки команды на сервер!", "Erro ao enviar comando para o servidor!"},
            {"Неправильно введен ключ!", "A chave foi inserida incorretamente!"},
            {"Неопознанная команда. Наберите 'help' для получения справки по доступным командам.", "Comando não identificado. Digite 'help' para obter ajuda sobre os comandos disponíveis."},
            {"Отсутствует аргумент.", "Argumento faltando."},
            {"Введите данные до конца!", "Insira os dados até o fim!"},
            {"Неправильный формат площади!", "Formato quadrado errado!"},
            {"Неправильный формат количества комнат!", "Formato errado para o número de quartos!"},
            {"Неправильный формат координаты x!", "Formato de coordenada x errado!"},
            {"Неправильный формат координаты y!", "Formato de coordenada y errado!"},
            {"Неправильно задано качество обстановки!", "A qualidade do ambiente está configurada incorretamente!"},
            {"Неправильно задано поле зрения!", "O campo de visão está configurado incorretamente!"},
            {"Неправильно задан вид транспорта!", "O meio de transporte está configurado incorretamente!"},
            {"Неправильный формат возраста дома!", "Formato errado da idade da casa!"},
            {"Неправильный формат количества квартир на этаже!", "Formato errado para o número de apartamentos no andar!"},
            {"Данные введены неверно!", "Dados inseridos incorretamente!"},
            {"Соединение с сервером установлено!", "A conexão com o servidor foi estabelecida!"},
            {"Ошибка соединения с сервером!", "Erro de conexão do servidor!"},
            {"Неправильный формат!", "Formato incorreto!"},
            {"Неверный формат аргумента!", "Formato de argumento inválido!"},
            {"Имя создателя: ", "Nome do criador: "},
            {"Имя: ", "Nome: "},
            {"Дата создания: ", "Data de criação: "},
            {"Координата X: ", "Coordenada X: "},
            {"Координата Y: ", "Coordenada Y: "},
            {"Площадь: ", "Área: "},
            {"Количество комнат: ", "Número de quartos: "},
            {"Качество обстановки: ", "Qualidade do mobiliário: "},
            {"Видимость: ", "Visibilidade: "},
            {"Транспорт: ", "Transporte: "},
            {"Имя дома: ", "Nome da casa: "},
            {"Возраст дома: ", "Idade da casa: "},
            {"Количество квартир: ", "Número de apartamentos: "},
            {"Введите логин и пароль!", "Digite o login e a senha!"},
            {"Соединение с сервером разорвано!", "A conexão com o servidor foi interrompida!"},
            {"Выберите строку!", "Selecione uma linha!"},
            {"Соединение с сервером восстановлено!", "A conexão com o servidor foi restaurada!"},
            {"Введите данные о квартире:", "Insira os detalhes do apartamento:"},
            {"Имя:", "Nome:"},
            {"Площадь:", "Área:"},
            {"Количество комнат:", "Número de quartos:"},
            {"Координата X:", "Coordenada X:"},
            {"Координата Y:", "Coordenada Y:"},
            {"Качество обстановки:", "Qualidade do mobiliário:"},
            {"Поле зрения:", "Linha de visão:"},
            {"Вид транспорта:", "Tipo de transporte:"},
            {"Имя дома:", "Nome da casa:"},
            {"Возраст дома:", "Idade da casa:"},
            {"Количество квартир на этаже:", "Número de apartamentos por andar:"},
            {"Назад", "De volta"},
            {"Таблица элементов коллекции:", "Tabela de elementos de coleção:"},
            {"Удалить", "Excluir"},
            {"Изменить", "Editar"},
            {"Обновить", "Atualizar"},
            {"Фильтр", "Filtro"},
            {"Консольные команды", "Comandos de console"},
            {"Таблица", "Mesa"},
            {"Визуализация", "Visualização"},
            {"Введите порт", "Entrar na porta"},
            {"Авторизация", "Autorização"},
            {"Вход", "Entrada"},
            {"Регистрация", "Check-in"}
    };

    @Override
    protected Object[][] getContents() {
        return contents;
    }
}
