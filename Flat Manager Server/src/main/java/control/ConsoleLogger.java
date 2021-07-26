package control;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Класс для логирования работы сервера
 *
 * @author Erik Karapetyan P3115
 * @version 1.0
 */
public class ConsoleLogger {

    private final Logger logger;

    /**
     * Регистрирация каждого класса в логгере
     *
     * @param clazz передает Class каждого класса
     */
    public ConsoleLogger(Class<?> clazz) {
        logger = LoggerFactory.getLogger(clazz.getSimpleName());
    }

    public void infoLog(String message) {
        logger.info(message);
    }
}
