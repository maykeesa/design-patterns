package br.com.design.patterns.structural.decorator.service;

public class FloatTextProcessorServiceImpl implements BaseTextProcessorService{

    private final float value;
    private final BaseTextProcessorService baseTextProcessorService;

    public FloatTextProcessorServiceImpl(BaseTextProcessorService baseTextProcessorService, float value) {
        this.value = value;
        this.baseTextProcessorService = baseTextProcessorService;
    }

    @Override
    public String process(String message) {
        String text = this.baseTextProcessorService.process(message);

        return "%s %s".formatted(text, value);
    }
}
