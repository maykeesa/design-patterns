package br.com.design.patterns.creational.singleton;

import br.com.design.patterns.creational.singleton.service.LoggerService;
import br.com.design.patterns.creational.singleton.service.LoggerServiceImpl;

public class Main {

    public static void main(String[] args) {
        LoggerService firstInstance = new LoggerServiceImpl(null);
        System.out.println(firstInstance);

        LoggerService secondInstance = new LoggerServiceImpl(null);
        System.out.println(secondInstance);

        System.out.printf("São iguais as instâncias? %s%n%n", firstInstance == secondInstance);

        LoggerService firstSingleton = LoggerServiceImpl.getInstance();
        System.out.println(firstSingleton);

        LoggerService secondSingleton = LoggerServiceImpl.getInstance();
        System.out.println(secondSingleton);

        System.out.printf("São Iguais os singletons? %s", firstSingleton == secondSingleton);

        firstSingleton.log("Olá");
        secondSingleton.log("Mundo!");
    }
}
