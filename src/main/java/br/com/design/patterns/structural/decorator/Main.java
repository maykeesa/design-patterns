package br.com.design.patterns.structural.decorator;

import br.com.design.patterns.structural.decorator.service.BaseTextProcessorService;
import br.com.design.patterns.structural.decorator.service.BooleanTextProcessorServiceImpl;
import br.com.design.patterns.structural.decorator.service.FloatTextProcessorServiceImpl;
import br.com.design.patterns.structural.decorator.service.IntegerTextProcessorServiceImpl;
import br.com.design.patterns.structural.decorator.service.TextProcessorServiceImpl;

public class Main {

    public static void main(String[] args) {
        BaseTextProcessorService firstText = new TextProcessorServiceImpl();
        firstText = new FloatTextProcessorServiceImpl(firstText, 6.7f);
        firstText = new IntegerTextProcessorServiceImpl(firstText, 10);
        firstText = new BooleanTextProcessorServiceImpl(firstText, false);

        System.out.println(firstText.process("Olá"));

        BaseTextProcessorService secondText = new TextProcessorServiceImpl();
        secondText = new BooleanTextProcessorServiceImpl(secondText, true);
        secondText = new IntegerTextProcessorServiceImpl(secondText, 97);
        secondText = new FloatTextProcessorServiceImpl(secondText, 3.14f);

        System.out.println(secondText.process("Teste"));


    }
}
