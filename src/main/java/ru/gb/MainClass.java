package ru.gb;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.*;
import org.apache.log4j.Logger;

public class MainClass {
    private static final Logger logger = Logger.getLogger(ru.gb.MainClass.class.getName());      // Создает сообщения лога...

    public static void main(String[] args) throws IOException {

        logger.info("info");
        logger.warn("info");
        logger.error("info");
        logger.fatal("info");

        //LogManager.getLogManager().readConfiguration(new FileInputStream("logging.properties"));      // настройки из файла...

//        logger.log(Level.SEVERE, "Java");
//        logger.log(Level.INFO, "info log");
//        logger.log(Level.CONFIG, "CONFIG log");
//        logger.log(Level.FINE, "FINE log");

//        System.out.println(logger.getParent().getName() + " parent");
//        System.out.println(logger.getName() + " this");

//        logger.setLevel(Level.ALL);
//        logger.getHandlers()[0].setLevel(Level.ALL);
//        logger.getHandlers()[0].setFormatter(new Formatter() {
//            @Override
//            public String format(LogRecord record) {
//                return record.getLevel() + " " + record.getMessage() + " " + record.getMillis() + "\n";
//            }
//        });
//
//        logger.getHandlers()[0].setFilter(new Filter() {
//            @Override
//            public boolean isLoggable(LogRecord record) {
//                return record.getMessage().contains("Java");
//            }
//        });
//
//        Handler handler = new FileHandler("./mylog.log");
//        handler.setLevel(Level.ALL);
//        logger.addHandler(handler);
//
//        logger.log(Level.SEVERE, "Java");
//        logger.log(Level.INFO, "info log");
//        logger.log(Level.CONFIG, "CONFIG log");
//        logger.log(Level.FINE, "FINE log");
//        // OFF
//        // SEVERE
//        // WARNING
//        // INFO
//        // CONFIG
//        // FINE
//        // FINER
//        // FINEST
//        // ALL

    }

}
