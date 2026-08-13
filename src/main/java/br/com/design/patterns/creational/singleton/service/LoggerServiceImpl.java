package br.com.design.patterns.creational.singleton.service;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class LoggerServiceImpl implements LoggerService {

    private final String logFile;
    private static LoggerServiceImpl instance;

    public LoggerServiceImpl(String logFile) {
        this.logFile = logFile == null
                ? "./src/main/java/br/com/design/patterns/creational/singleton/logs/app.log"
                : logFile;
    }

    private LoggerServiceImpl() {
        this.logFile = "./src/main/java/br/com/design/patterns/creational/singleton/logs/app.log";
    }

    public static LoggerServiceImpl getInstance(){
        if(instance == null){
            instance = new LoggerServiceImpl();
        }

        return instance;
    }

    @Override
    public void log(String message) {
        try (FileWriter writer = new FileWriter(logFile, true)) {
            writer.write("[" + LocalDateTime.now() + "] - " + message + "\n");
        } catch (IOException e) {
            throw new RuntimeException("Falha ao escrever no arquivo de log: " + logFile, e);
        }
    }
}
