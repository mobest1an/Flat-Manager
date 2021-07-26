package server;

import control.CollectionController;
import control.DataBaseManager;
import control.ConsoleLogger;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Класс запускающий сервер, управляющий подключениями и запросами клиентов
 */
public class Server {

    private ServerSocketChannel server;
    private Selector selector;
    private DataBaseManager manager = new DataBaseManager();
    private CollectionController controller = new CollectionController(manager);
    private ThreadPoolExecutor readService = (ThreadPoolExecutor) Executors.newFixedThreadPool(10);
    private int PORT;
    private ConsoleLogger consoleLogger = new ConsoleLogger(Server.class);
    private RequestReader reader = new RequestReader();


    public Server() {
        configureServer();
    }

    /**
     * Метод запускает работу сервера
     */
    public void run() {
        try {
            while (true) {
                int events = selector.select();
                if (events == 0) {
                    continue;
                }
                Set<SelectionKey> selectedKeys = selector.selectedKeys();
                Iterator<SelectionKey> iterator = selectedKeys.iterator();
                while (iterator.hasNext()) {
                    SelectionKey key = iterator.next();
                    iterator.remove();
                    if (key.isAcceptable()) {
                        setConnection();
                    } else if (key.isReadable()) {
                        SocketChannel channel = (SocketChannel) key.channel();
                        receiveCommand(channel);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод конфигурирует параметры сервера и запускает его
     */
    private void configureServer() {
        try {
            Scanner portScanner = new Scanner(System.in);
            System.out.print("Введите порт: ");
            PORT = portScanner.nextInt();
            selector = Selector.open();
            server = ServerSocketChannel.open();
            server.socket().bind(new InetSocketAddress(PORT));
            server.configureBlocking(false);
            server.register(selector, SelectionKey.OP_ACCEPT);
            consoleLogger.infoLog("Сервер запущен...");
        } catch (IOException e) {
            consoleLogger.infoLog("Порт уже занят, введите другой!");
            configureServer();
        } catch (InputMismatchException e) {
            consoleLogger.infoLog("Неправильно задан порт!");
            configureServer();
        }
    }

    /**
     * Окрывает канал для соединения и общения с клиентом
     *
     * @throws IOException бросает исключение при неудачном соединении
     */
    private void setConnection() throws IOException {
        SocketChannel channel = server.accept();
        channel.configureBlocking(false);
        channel.register(selector, SelectionKey.OP_READ);
        consoleLogger.infoLog("Новое подключение: " + channel.toString());
    }

    /**
     * Получает запрос от клиента и выполняет команду
     *
     * @param channel принимает канал, который передает в методы для считывания команды и отправки ответа
     */
    private void receiveCommand(SocketChannel channel) {
        reader.setServiceData(channel, controller, manager);
        readService.submit(reader);
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
