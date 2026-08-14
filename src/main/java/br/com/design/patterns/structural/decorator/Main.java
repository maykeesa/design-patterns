package br.com.design.patterns.structural.decorator;

import br.com.design.patterns.structural.decorator.service.BaseTextProcessorService;
import br.com.design.patterns.structural.decorator.service.BooleanTextProcessorServiceImpl;
import br.com.design.patterns.structural.decorator.service.IntegerTextProcessorServiceImpl;
import br.com.design.patterns.structural.decorator.service.TextProcessorServiceImpl;

public class Main {

    public static void main(String[] args) {
        BaseTextProcessorService text = new TextProcessorServiceImpl();
        text = new BooleanTextProcessorServiceImpl(text, true);
        text = new IntegerTextProcessorServiceImpl(text, 10);

        System.out.println(text.process("Olá"));
    }
}
