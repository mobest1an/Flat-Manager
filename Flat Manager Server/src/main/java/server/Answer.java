package server;

import control.ConsoleLogger;
import tools.Message;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * Класс для отправки ответа на клиент, с котрого пришел запрос
 */
public class Answer implements Runnable {

    private Message message;
    private SocketChannel channel;
    private ConsoleLogger consoleLogger = new ConsoleLogger(Answer.class);

    public void setServiceData(Message message, SocketChannel channel) {
        this.message = message;
        this.channel = channel;
    }

    /**
     * Метод, реализующий сериализацию объекта и последующую отправку на клиент
     */
    public void sendMessage() {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(message);
            objectOutputStream.flush();
            byte[] bytes = byteArrayOutputStream.toByteArray();
            ByteBuffer byteBuffer = ByteBuffer.wrap(bytes);
            channel.write(byteBuffer);
        } catch (IOException e) {
            try {
                channel.close();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            consoleLogger.infoLog("Пользователь отключился!");
        }
    }

    @Override
    public void run() {
        sendMessage();
    }
}