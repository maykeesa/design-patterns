package br.com.design.patterns.structural.decorator.service;

public class BooleanTextProcessorServiceImpl implements BaseTextProcessorService{

    private boolean value;
    private BaseTextProcessorService baseTextProcessorService;

    public BooleanTextProcessorServiceImpl(BaseTextProcessorService baseTextProcessorService, boolean value) {
        this.value = value;
        this.baseTextProcessorService = baseTextProcessorService;
    }

    @Override
    public String process(String message) {
        String text = this.baseTextProcessorService.process(message);

        return "%s %s".formatted(text, this.value);
    }
}
