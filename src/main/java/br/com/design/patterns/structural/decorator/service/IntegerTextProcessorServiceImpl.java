package br.com.design.patterns.structural.decorator.service;

public class IntegerTextProcessorServiceImpl implements BaseTextProcessorService{

    private Integer value;
    private BaseTextProcessorService baseTextProcessorService;

    public IntegerTextProcessorServiceImpl(BaseTextProcessorService baseTextProcessorService, Integer value) {
        this.value = value;
        this.baseTextProcessorService = baseTextProcessorService;
    }

    @Override
    public String process(String message) {
        String text = this.baseTextProcessorService.process(message);

        return "%s %s".formatted(text, this.value);
    }
}
