package control;

import lab.*;

import java.io.*;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Класс для управления работой коллекции
 *
 * @author Erik Karapetyan P3115
 * @version 1.0
 */
public class CollectionController {

    private final HashMap<String, String> manual;
    private final Date initDate = new Date();
    private TreeMap<Integer, Flat> flatCollection;
    private DataBaseManager manager;
    private ConsoleLogger consoleLogger = new ConsoleLogger(CollectionController.class);
    private ReentrantLock locker = new ReentrantLock();
    private Flat updateFlat;

    public Flat getUpdateFlat() {
        return updateFlat;
    }

    /**
     * Автоматическое считывание данных из файла о сохраненной коллекции и добавление её в текущую при запуске программы.
     */
    public CollectionController(DataBaseManager manager) {
        this.manager = manager;
        flatCollection = this.manager.read();
    }

    {
        manual = new HashMap<>();
        manual.put("help", "Вывести справку по доступным командам.");
        manual.put("info", "Вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.).");
        manual.put("show", "Вывести в стандартный поток вывода все элементы коллекции в строковом представлении.");
        manual.put("insert", "Добавить новый элемент с заданным ключом.");
        manual.put("update", "Обновить значение элемента коллекции, id которого равен заданному.");
        manual.put("remove_key", "Удалить элемент из коллекции по его ключу");
        manual.put("clear", "Очистить коллекцию.");
        manual.put("execute_script", "Считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.");
        manual.put("exit", "Завершить программу (без сохранения в файл).");
        manual.put("remove_lower", "Удалить из коллекции все элементы, меньшие, чем заданный.");
        manual.put("history", "Вывести последние 14 команд (без их аргументов).");
        manual.put("replace_if_lower", "Заменить значение по ключу, если новое значение меньше старого.");
        manual.put("min_by_house", "Вывести любой объект из коллекции, значение поля house которого является минимальным.");
        manual.put("count_by_furnish", "Вывести количество элементов, значение поля furnish которых равно заданному.");
        manual.put("count_greater_than_furnish", "Вывести количество элементов, значение поля furnish которых больше заданного.");
        manual.put("man", "Вывести справку по команде.");
    }

    public Flat[] getFlatCollection() {
        return flatCollection.values().toArray(new Flat[0]);
    }

    /**
     * Метод для реализации команды "help".
     */
    public String help() {
        return "Команды: " + manual.keySet() + ".\nВывести справку по командам: man {команда}." +
                "\n" + "НАЦИОНАЛЬНЫЙ ИССЛЕДОВАТЕЛЬСКИЙ УНИВЕРСИТЕТ ИТМО: Факультет программной инженерии и компьютерной техники\n" +
                "Лабораторная работа №8 по программированию.\n" +
                "Вариант 9875321\n" + "Выполнил: Карапетян Эрик Акопович P3115\n" +
                "Преподаватель: Гаврилов Антон Валерьевич";
    }

    /**
     * Метод для реализации команды "show".
     */
    public String show(String login) {
        StringBuilder value = new StringBuilder();
        value.append("Коллекция в базе данных, ваши элементы отмечены стрелочкой:\n");
        if (flatCollection.size() != 0) {
            flatCollection.entrySet().forEach(p -> {
                if (manager.isUserElement(p.getKey(), login)) {
                    value.append("--> ").append(p.getValue().getUserName()).append(" --- ").append(p.getKey()).append(" --- ").append(p.getValue().getId()).append(" | ").append(p.getValue().getName()).append(" | ")
                            .append(p.getValue().getCoordinates()).append(" | ").append(p.getValue().getCreationDate().format(DateTimeFormatter.ofPattern("MM/dd/yyyy - HH:mm")))
                            .append(" | ").append(p.getValue().getArea()).append(" | ").append(p.getValue().getNumberOfRooms()).append(" | ").append(p.getValue().getFurnish())
                            .append(" | ").append(p.getValue().getView()).append(" | ").append(p.getValue().getTransport()).append(" | ").append(p.getValue().getHouse()).append("\n");
                } else {
                    value.append(p.getValue().getUserName()).append(" --- ").append(p.getKey()).append(" --- ").append(p.getValue().getId()).append(" | ").append(p.getValue().getName()).append(" | ")
                            .append(p.getValue().getCoordinates()).append(" | ").append(p.getValue().getCreationDate().format(DateTimeFormatter.ofPattern("MM/dd/yyyy - HH:mm")))
                            .append(" | ").append(p.getValue().getArea()).append(" | ").append(p.getValue().getNumberOfRooms()).append(" | ").append(p.getValue().getFurnish())
                            .append(" | ").append(p.getValue().getView()).append(" | ").append(p.getValue().getTransport()).append(" | ").append(p.getValue().getHouse()).append("\n");
                }
            });
            return value.toString().trim();
        }
        return "Коллекция пуста!";
    }

    /**
     * Метод для реализации команды "insert".
     *
     * @param key задаёт значение ключа для нового элемента коллекции.
     */
    public String insert(int key, Flat flat, String login) {
        locker.lock();
        try {
            if (manager.write(key, flat, login)) {
                flat.setId(manager.readID(key));
                flatCollection.put(key, flat);
                return "Элемент добавлен в коллекцию успешно.";
            } else {
                return "Не удалось добавить элемент в базу данных.";
            }
        } finally {
            locker.unlock();
        }
    }

    /**
     * Метод для реализации команды "update".
     *
     * @param id задает значение id, такое, что, элемент в коллекции с таким значением id будет обновлён.
     */
    public String update(int id, Flat flat, String login) {
        locker.lock();
        try {
            if (flatCollection.size() != 0) {
                Optional<Map.Entry<Integer, Flat>> optional = flatCollection.entrySet().stream().filter(p -> p.getValue().getId() == id).findFirst();
                if (optional.isPresent()) {
                    int key = optional.get().getKey();
                    if (manager.isUserElement(key, login)) {
                        if (manager.remove(key)) {
                            flatCollection.remove(key);
                            if (manager.write(key, flat, login)) {
                                flat.setId(manager.readID(key));
                                flatCollection.put(key, flat);
                                updateFlat = flat;
                                return "Элемент коллекции обновлен успешно.";
                            }
                        } else {
                            return "Не удалось обновить элемент коллекции в базе данных.";
                        }
                    } else {
                        return "Невозможно модифицировать элемент, он не принадлежит вам!";
                    }
                } else {
                    return "Элемента с заданным ID не существует. Получить список элементов коллекции: show.";
                }
            }
            return "Коллекция пуста!";
        } finally {
            locker.unlock();
        }
    }

    public String remove(int id, String login) {
        locker.lock();
        try {
            int a = flatCollection.size();
            if (flatCollection.size() != 0) {
                Optional<Map.Entry<Integer, Flat>> optional = flatCollection.entrySet().stream().filter(p -> p.getValue().getId() == id).findFirst();
                if (optional.isPresent()) {
                    int key = optional.get().getKey();
                    if (manager.isUserElement(key, login)) {
                        if (manager.remove(key)) {
                            flatCollection.remove(key);
                            int b = flatCollection.size();
                            if (b < a) {
                                return "Элемент коллекции удален.";
                            } else {
                                return "Такого элемента не существует.";
                            }
                        } else {
                            return "Не удалось удалить элемент из базы данных";
                        }
                    } else {
                        return "Невозможно модифицировать элемент, он не принадлежит вам!";
                    }
                }
            }
            return "Коллекция пуста!";
        } finally {
            locker.unlock();
        }
    }

    /**
     * Метод для реализации команды "remove_key".
     *
     * @param key задает значение ключа, такое, что, элемент в коллекции с таким ключом будет удалён.
     */
    public String remove_key(int key, String login) {
        locker.lock();
        try {
            int a = flatCollection.size();
            if (manager.isUserElement(key, login)) {
                if (manager.remove(key)) {
                    flatCollection.remove(key);
                    int b = flatCollection.size();
                    if (b < a) {
                        return "Элемент коллекции удален.";
                    } else {
                        return "Такого элемента не существует.";
                    }
                } else {
                    return "Не удалось удалить элемент из базы данных";
                }
            } else {
                return "Невозможно модифицировать элемент, он не принадлежит вам!";
            }
        } finally {
            locker.unlock();
        }
    }

    /**
     * Метод для реализации команды "clear".
     */
    public String clear(String login) {
        locker.lock();
        try {
            if (flatCollection.size() != 0) {
                manager.clear(login, flatCollection);
                return "Коллекция очищена.";
            } else {
                return "Коллекция пуста!";
            }
        } finally {
            locker.unlock();
        }
    }

    private ArrayList<String> pathList = new ArrayList<>();

    /**
     * Метод для реализации команды "execute_script".
     *
     * @param path принимает путь до файла из которого нужно выполнить скрипт
     */
    public String execute_script(String path, String login) {
        locker.lock();
        try {
            String[] userCommandPart;
            String[] history = new String[15];
            StringBuilder message = new StringBuilder();
            int j = 0;
            try {
                FileReader scriptFile = new FileReader(path);
                BufferedReader reader = new BufferedReader(scriptFile);
                String line = reader.readLine();
                while (line != null) {
                    if (!line.equals("")) {
                        userCommandPart = line.trim().split(" ", 2);
                        if (j < 14) {
                            history[j] = userCommandPart[0];
                        } else {
                            history[14] = userCommandPart[0];
                            for (j = 0; j < 14; j++) {
                                history[j] = history[j + 1];
                            }
                        }
                        if (userCommandPart[0].equals("exit")) {
                            System.exit(0);
                        }
                        try {
                            switch (userCommandPart[0]) {
                                case "":
                                    break;
                                case "help":
                                    message.append(help()).append("\n");
                                    break;
                                case "info":
                                    message.append(toString()).append("\n");
                                    break;
                                case "show":
                                    message.append(show(login)).append("\n");
                                    break;
                                case "insert":
                                    userCommandPart[1] = userCommandPart[1].trim();
                                    String[] insertPart = new String[11];
                                    for (int i = 0; i < 11; i++) {
                                        insertPart[i] = reader.readLine();
                                    }
                                    int id = (int) (Math.random() * 1000);
                                    ZonedDateTime creationDate = ZonedDateTime.now();
                                    try {
                                        Flat flat = new Flat(login, id, insertPart[0], new Coordinates(Long.valueOf(insertPart[3]), Double.parseDouble(insertPart[4])),
                                                creationDate, Integer.parseInt(insertPart[1]), Integer.parseInt(insertPart[2]), Furnish.valueOf(insertPart[5].toUpperCase()), View.valueOf(insertPart[6].toUpperCase()),
                                                Transport.valueOf(insertPart[7].toUpperCase()), new House(insertPart[8], Integer.parseInt(insertPart[9]), Integer.parseInt(insertPart[10])));
                                        message.append(insert(Integer.parseInt(userCommandPart[1]), flat, login)).append("\n");
                                    } catch (IllegalArgumentException e) {
                                        message.append("Неправильный синтаксис команды \"insert\"").append("\n");
                                    }
                                    break;
                                case "update":
                                    userCommandPart[1] = userCommandPart[1].trim();
                                    String[] updatePart = new String[11];
                                    for (int i = 0; i < 11; i++) {
                                        updatePart[i] = reader.readLine();
                                    }
                                    int myId = Integer.parseInt(userCommandPart[1]);
                                    long count = flatCollection.entrySet().stream().filter(p -> p.getValue().getId() == myId).count();
                                    if (count != 0) {
                                        Optional<Map.Entry<Integer, Flat>> optional = flatCollection.entrySet().stream().filter(p -> p.getValue().getId() == myId).findFirst();
                                        if (optional.isPresent()) {
                                            ZonedDateTime myCreationDate = optional.get().getValue().getCreationDate();
                                            try {
                                                Flat flat1 = new Flat(login, myId, updatePart[0], new Coordinates(Long.valueOf(updatePart[3]), Double.parseDouble(updatePart[4])),
                                                        myCreationDate, Integer.parseInt(updatePart[1]), Integer.parseInt(updatePart[2]), Furnish.valueOf(updatePart[5].toUpperCase()), View.valueOf(updatePart[6].toUpperCase()),
                                                        Transport.valueOf(updatePart[7].toUpperCase()), new House(updatePart[8], Integer.parseInt(updatePart[9]), Integer.parseInt(updatePart[10])));
                                                message.append(update(Integer.parseInt(userCommandPart[1]), flat1, login)).append("\n");
                                            } catch (IllegalArgumentException e) {
                                                message.append("Неправильный синтаксис команды \"update\"").append("\n");
                                            }
                                        }
                                    }
                                    break;
                                case "remove_key":
                                    userCommandPart[1] = userCommandPart[1].trim();
                                    try {
                                        message.append(remove_key(Integer.parseInt(userCommandPart[1]), login)).append("\n");
                                    } catch (NumberFormatException e) {
                                        message.append("Неправильно введен ключ!").append("\n");
                                    }
                                    break;
                                case "clear":
                                    message.append(clear(login)).append("\n");
                                    break;
                                case "execute_script":
                                    pathList.add(path);
                                    userCommandPart[1] = userCommandPart[1].trim().toLowerCase();
                                    try {
                                        for (String a : pathList) {
                                            if (!userCommandPart[1].equals(a)) {
                                                message.append(execute_script(userCommandPart[1], login)).append("\n");
                                            } else {
                                                message.append("Нельзя исполнить этот же скрипт!").append("\n");
                                            }
                                        }
                                    } catch (ConcurrentModificationException ignored) {
                                    }
                                    break;
                                case "remove_lower":
                                    userCommandPart[1] = userCommandPart[1].trim();
                                    try {
                                        message.append(remove_lower(Integer.parseInt(userCommandPart[1]), login)).append("\n");
                                    } catch (NumberFormatException e) {
                                        message.append("Неправильно введен ключ!").append("\n");
                                    }
                                    break;
                                case "history":
                                    for (int k = 0; k < 14; k++) {
                                        if (history[k] != null) {
                                            message.append(history[k]).append("\n");
                                        }
                                    }
                                    break;
                                case "replace_if_lower":
                                    userCommandPart[1] = userCommandPart[1].trim();
                                    String replaced = reader.readLine();
                                    try {
                                        message.append(replace_if_lower(Integer.parseInt(userCommandPart[1]), Integer.parseInt(replaced), login)).append("\n");
                                    } catch (NumberFormatException e) {
                                        message.append("Неправильно введен ключ!").append("\n");
                                    }
                                    break;
                                case "min_by_house":
                                    message.append(min_by_house()).append("\n");
                                    break;
                                case "count_by_furnish":
                                    userCommandPart[1] = userCommandPart[1].trim();
                                    message.append(count_furnish(userCommandPart[1], false)).append("\n");
                                    break;
                                case "count_greater_than_furnish":
                                    userCommandPart[1] = userCommandPart[1].trim();
                                    message.append(count_furnish(userCommandPart[1], true)).append("\n");
                                    break;
                                default:
                                    message.append("Неопознанная команда. Наберите 'help' для получения справки по доступным командам.").append("\n");
                            }
                        } catch (ArrayIndexOutOfBoundsException ex) {
                            message.append("Отсутствует аргумент.").append("\n");
                        }
                    }
                    j++;
                    line = reader.readLine();
                }
            } catch (IOException e) {
                message.append("Неправильно указан путь к файлу!").append("\n");
            }
            return message.toString().trim();
        } finally {
            locker.unlock();
        }
    }

    /**
     * Метод для реализации команды "remove_lower".
     *
     * @param id задает значение id, такое, что, элементы в коллекции со значением меньше этого, будут удалены.
     */
    public String remove_lower(int id, String login) {
        locker.lock();
        try {
            if (flatCollection.size() != 0) {
                long count = flatCollection.entrySet().stream().filter(p -> p.getValue().getId() < id).count();
                if (count != 0) {
                    Optional<Map.Entry<Integer, Flat>> optional = flatCollection.entrySet().stream().filter(p -> p.getValue().getId() < id).findFirst();
                    if (optional.isPresent()) {
                        int key = optional.get().getKey();
                        if (manager.isUserElement(key, login)) {
                            if (manager.remove(key)) {
                                flatCollection.remove(key);
                                return "Элемент коллекции удален.";
                            } else {
                                return "Не удалось удалить элемент из базы данных";
                            }
                        } else {
                            return "Невозможно модифицировать элемент, он не принадлежит вам!";
                        }
                    }
                } else {
                    return "Такого элемента не существует.";
                }
            }
            return "Коллекция пуста!";
        } finally {
            locker.unlock();
        }
    }

    /**
     * Метод для реализации команды "replace_if_lower".
     *
     * @param key задает значение ключа, такое, что, у элемента в коллекции с таким ключом, будет заменено значение id, если новое значение меньше старого.
     */
    public String replace_if_lower(int key, int id, String login) {
        locker.lock();
        try {
            if (flatCollection.size() != 0) {
                if (manager.isUserElement(key, login)) {
                    long count = flatCollection.entrySet().stream().filter(p -> key == p.getKey()).filter(p -> id < p.getValue().getId()).count();
                    if (count != 0) {
                        Optional<Map.Entry<Integer, Flat>> optional = flatCollection.entrySet().stream().filter(p -> id < p.getValue().getId()).findFirst();
                        if (optional.isPresent()) {
                            optional.get().getValue().setId(id);
                            return "Значение элемента успешно изменено.";
                        }
                    } else {
                        return "Элемента с заданным ID не существует или новое значение больше всех остальных значений в коллекции. Получить список элементов коллекции: show.";
                    }
                } else {
                    return "Невозможно модифицировать элемент, он не принадлежит вам!";
                }
            }
            return "Коллекция пуста!";
        } finally {
            locker.unlock();
        }
    }

    /**
     * Метод для реализации команды "min_by_house".
     */
    public String min_by_house() {
        if (flatCollection.size() != 0) {
            flatCollection.entrySet().forEach(p -> {
                String[] buff = p.getValue().getHouse().split("; ");
                String value;
                int year = Integer.MAX_VALUE;
                int myYear = Integer.parseInt(buff[2]);
                for (int i = 0; i < flatCollection.size(); i++) {
                    if (myYear < year) {
                        year = myYear;
                        value = p.getKey() + " --- " + p.getValue().getId() + " | " + p.getValue().getName() + " | " + p.getValue().getCoordinates()
                                + " | " + p.getValue().getCreationDate().format(DateTimeFormatter.ofPattern("MM/dd/yyyy - HH:mm")) + " | " + p.getValue().getArea() + " | " + p.getValue().getNumberOfRooms()
                                + " | " + p.getValue().getFurnish() + " | " + p.getValue().getView() + " | " + p.getValue().getTransport()
                                + " | " + p.getValue().getHouse();
                        setValue(value);
                    }
                }
            });
            return value;
        }
        return "Коллекция пуста!";
    }

    private String value;

    private void setValue(String value) {
        this.value = value;
    }

    /**
     * Метод для реализации команды "count_by_furnish" и "count_greater_than_furnish".
     *
     * @param furnish задает значение furnish.
     * @param isMore  задает состояние для метода, исходя из которого программа понимает, вывести количество элементов, значение поля furnish которых равно или больше заданного.
     */
    public String count_furnish(String furnish, boolean isMore) {
        long count;
        if (flatCollection.size() != 0) {
            if (!isMore) {
                count = flatCollection.entrySet().stream().filter(p -> Furnish.valueOf(furnish.toUpperCase()).compareTo(Furnish.valueOf(p.getValue().getFurnish())) == 0).count();
            } else {
                count = flatCollection.entrySet().stream().filter(p -> Furnish.valueOf(furnish.toUpperCase()).compareTo(Furnish.valueOf(p.getValue().getFurnish())) > 0).count();
            }
            if (count == 0 && !isMore) {
                return "Элемента с таким значением Furnish не существует!";
            } else if (count == 0) {
                return "Элемента со значением Furnish больше заданного не существует!";
            } else {
                return "Количество элементов: " + count;
            }
        }
        return "Коллекция пуста!";
    }

    /**
     * Метод для реализации команды "info".
     *
     * @return возвращает строку для вывода информации о коллекции в консоль.
     */
    @Override
    public String toString() {
        return "Тип коллекции: " + flatCollection.getClass() +
                "\nДата инициализации: " + initDate +
                "\nКоличество элементов: " + flatCollection.size();
    }
}
