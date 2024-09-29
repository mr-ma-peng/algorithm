package org.example;

import java.util.logging.Logger;

public class App {
    public String getGreeting() {
        return "Hello World!";
    }

    public static void main(String[] args) {
        Logger logger = Logger.getLogger(App.class.getName());
        logger.info(new App().getGreeting());
    }
}
