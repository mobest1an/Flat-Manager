package server;

import control.CollectionController;
import control.ConsoleLogger;
import control.DataBaseManager;
import tools.Message;
import tools.Request;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class RequestReader implements Runnable {

    private SocketChannel channel;
    private CollectionController controller;
    private DataBaseManager manager;
    private ConsoleLogger consoleLogger = new ConsoleLogger(RequestReader.class);
    private ThreadPoolExecutor handleService = (ThreadPoolExecutor) Executors.newCachedThreadPool();
    private CommandHandler handler = new CommandHandler();
    private ThreadPoolExecutor answerService = (ThreadPoolExecutor) Executors.newCachedThreadPool();
    private Answer answer = new Answer();
    private Message message;

    public void setServiceData(SocketChannel channel, CollectionController controller, DataBaseManager manager) {
        this.channel = channel;
        this.controller = controller;
        this.manager = manager;
    }

    /**
     * Метод, реализующий десериализацию объекта и чтение команды с проверкой на null через класс Optional<>
     *
     * @return возвращает объект Command через Optional
     */
    public Request readRequest() {
        try {
            ByteBuffer byteBuffer = ByteBuffer.allocate(65000);
            int num = channel.read(byteBuffer);
            if (num > 0) {
                ObjectInputStream objectInputStream = new ObjectInputStream(new ByteArrayInputStream(byteBuffer.array()));
                return (Request) objectInputStream.readObject();
            } else if (num == -1) {
                channel.close();
            }
        } catch (IOException e) {
            try {
                channel.close();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            consoleLogger.infoLog("Пользователь отключился!");
        } catch (ClassNotFoundException e) {
            consoleLogger.infoLog("Не удалось десериализаовать объект!");
        }
        return null;
    }

    @Override
    public void run() {
        Request request = readRequest();
        if (request != null) {
            if (request.getName().equals("auth")) {
                consoleLogger.infoLog("Входящий запрос на вход/авторизацию в системе.");
                handler.setServiceData(request, controller, manager, true);
            } else {
                consoleLogger.infoLog("Входящий запрос на выполнение команды: \u001B[34m" + request.getName() + "\u001B[0m");
                handler.setServiceData(request, controller, manager, false);
            }
            try {
                message = handleService.submit(handler).get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
            answer.setServiceData(message, channel);
            answerService.submit(answer);
        }
    }
}