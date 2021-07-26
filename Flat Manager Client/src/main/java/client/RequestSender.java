package client;

import tools.Message;
import tools.Request;

import java.io.*;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * Класс для соединения с сервером, отправки запросов и получения ответа
 */
public class RequestSender {

    private SocketChannel socketChannel;
    private int PORT;

    public boolean setConnection() {
        try {
            socketChannel = SocketChannel.open();
            socketChannel.connect(new InetSocketAddress(PORT));
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    /**
     * Метод для соединения с сервером
     */
    public boolean setConnection(int PORT) {
        this.PORT = PORT;
        try {
            socketChannel = SocketChannel.open();
            socketChannel.connect(new InetSocketAddress(PORT));
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    /**
     * Метод для отправки запроса - команды
     *
     * @param request принимает команду для отправки
     */
    public boolean sendRequest(Request request) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(request);
            objectOutputStream.flush();
            byte[] bytes = byteArrayOutputStream.toByteArray();
            ByteBuffer byteBuffer = ByteBuffer.wrap(bytes);
            socketChannel.write(byteBuffer);
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    /**
     * Метод для получения ответа от сервера
     */
    public Message getAnswer() {
        try {
            ByteBuffer byteBuffer = ByteBuffer.allocate(65000);
            int num = socketChannel.read(byteBuffer);
            if (num > 0) {
                ObjectInputStream objectInputStream = new ObjectInputStream(new ByteArrayInputStream(byteBuffer.array()));
                Message message = (Message) objectInputStream.readObject();
                return message;
            }
        } catch (IOException | ClassNotFoundException e) {
            return null;
        }
        return null;
    }
}
