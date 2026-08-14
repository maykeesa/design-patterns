package br.com.design.patterns.structural.decorator.service;

public class TextProcessorServiceImpl implements BaseTextProcessorService {

    @Override
    public String process(String message) {
        return message;
    }
}
