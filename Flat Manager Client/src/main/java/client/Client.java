package client;

import gui.ConnectGUI;
import resources.ResourceController;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Основной класс программы запускающий работу клиента
 */
public class Client {

    /**
     * Точка входа в программу
     *
     * @param args принимает аргументы передаваемые JVM
     */
    public static void main(String[] args) {
        ResourceBundle bundleRU = ResourceBundle.getBundle("resources.Resources_ru", new Locale("ru", "RU"));
        ResourceBundle bundlePT = ResourceBundle.getBundle("resources.Resources_pt", new Locale("pt", "PT"));
        ResourceBundle bundleSQ = ResourceBundle.getBundle("resources.Resources_sq", new Locale("sq", "AL"));
        ResourceBundle bundleEN = ResourceBundle.getBundle("resources.Resources_en", new Locale("en", "CA"));

        ResourceBundle[] resourceBundles = new ResourceBundle[]{bundleRU, bundlePT, bundleSQ, bundleEN};
        ResourceController resourceController = new ResourceController(bundleRU, resourceBundles);

        RequestSender requestSender = new RequestSender();
        ConnectGUI connectGUI = new ConnectGUI(requestSender, resourceController);
        connectGUI.drawMessages();
        connectGUI.createFrame();
    }
}
