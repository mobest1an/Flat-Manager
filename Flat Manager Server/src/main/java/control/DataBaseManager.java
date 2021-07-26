package control;

import lab.*;

import java.sql.*;
import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Класс для работы с базой данных
 *
 * @author Erik Karapetyan P3115
 * @version 1.0
 */
public class DataBaseManager {

    private final String DB_URL = "jdbc:postgresql://localhost:43276/studs";
    private final String USER = "******";
    private final String PASS = "******";
    private ConsoleLogger consoleLogger = new ConsoleLogger(DataBaseManager.class);
    private Connection connection;
    private TreeMap<Integer, Flat> flatCollection;
    private HashMap<Integer, String> database;
    private ReentrantLock locker = new ReentrantLock();

    public DataBaseManager() {
        flatCollection = new TreeMap<>();
        database = new HashMap<>();
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
            consoleLogger.infoLog("Вы успешно подключились к базе данных.");
        } catch (ClassNotFoundException e) {
            consoleLogger.infoLog("Драйвер PostgreSQL JDBC не найден!");
        } catch (SQLException e) {
            consoleLogger.infoLog("Не удалось подключиться к базе данных!");
            System.exit(1);
        }
    }

    public TreeMap<Integer, Flat> read() {
        try {
            String query = "SELECT * FROM collection";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String[] coordinates = resultSet.getString(4).trim().split("; ");
                Long x = Long.valueOf(coordinates[0]);
                double y = Double.parseDouble(coordinates[1]);
                ZonedDateTime creationDate = ZonedDateTime.parse(resultSet.getString(5));
                String[] house = resultSet.getString(11).trim().split("; ");
                String houseName = house[0];
                int houseYear = Integer.parseInt(house[1]);
                Integer houseNumberOfFlatsOnFloor = Integer.valueOf(house[2]);
                flatCollection.put(resultSet.getInt(1), new Flat(resultSet.getString(12), resultSet.getInt(2), resultSet.getString(3), new Coordinates(x, y), creationDate,
                        resultSet.getInt(6), resultSet.getInt(7), Furnish.valueOf(resultSet.getString(8)), View.valueOf(resultSet.getString(9)),
                        Transport.valueOf(resultSet.getString(10)), new House(houseName, houseYear, houseNumberOfFlatsOnFloor)));
                database.put(resultSet.getInt(1), resultSet.getString(12));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flatCollection;
    }

    /**
     * Сохранение элемента в базе данных.
     *
     * @param key   ключ элемента коллекции
     * @param flat  элемент коллекции
     * @param login сохранение информации о пользователе
     */
    public boolean write(int key, Flat flat, String login) {
        try {
            String query = "INSERT INTO collection(flat_key, flat_name, flat_coordinates, flat_creation_date, flat_area, flat_number_of_rooms, flat_furnish, flat_view, flat_transport, flat_house, user_login) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, key);
            preparedStatement.setString(2, flat.getName());
            preparedStatement.setString(3, flat.getCoordinates());
            preparedStatement.setString(4, String.valueOf(flat.getCreationDate()));
            preparedStatement.setInt(5, flat.getArea());
            preparedStatement.setInt(6, flat.getNumberOfRooms());
            preparedStatement.setString(7, flat.getFurnish());
            preparedStatement.setString(8, flat.getView());
            preparedStatement.setString(9, flat.getTransport());
            preparedStatement.setString(10, flat.getHouse());
            preparedStatement.setString(11, login);
            preparedStatement.executeUpdate();
            database.put(key, login);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Integer readID(int key) {
        try {
            String query = "SELECT * FROM collection";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                if (resultSet.getInt(1) == key) {
                    return resultSet.getInt(2);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Удаляет элемент по заданному ключу
     *
     * @param elementKey принимает ключ, по которому будет удален элемент
     */
    public boolean remove(int elementKey) {
        try {
            String query = "DELETE FROM collection WHERE flat_key = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, elementKey);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Очистка данных о коллекции в базе данных.
     */
    public void clear(String login, TreeMap<Integer, Flat> flatCollection) {
        locker.lock();
        try {
            database.entrySet().stream().forEach(p -> {
                if (isUserElement(p.getKey(), login)) {
                    remove(p.getKey());
                    flatCollection.remove(p.getKey());
                }
            });
        } finally {
            locker.unlock();
        }
    }

    public void addUser(String login, String password) {
        try {
            String query = "INSERT INTO users(user_login, user_password) VALUES(?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public HashMap<String, String> getUsers() {
        HashMap<String, String> usersInfo = new HashMap<>();
        try {
            String query = "SELECT * FROM users";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                usersInfo.put(resultSet.getString(1), resultSet.getString(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usersInfo;
    }

    public boolean isUserElement(int key, String login) {
        Optional<Map.Entry<Integer, String>> optional = database.entrySet().stream().filter(p -> p.getKey() == key && p.getValue().equals(login)).findFirst();
        return optional.isPresent();
    }
}
