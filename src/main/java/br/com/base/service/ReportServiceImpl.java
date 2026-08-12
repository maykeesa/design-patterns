package br.com.base.service;

public class ReportServiceImpl implements ReportService {

    @Override
    public String generate(String id) throws InterruptedException {

        // Lógica de geração
        Thread.sleep(5000);

        return "Relatório gerado: %s".formatted(id);
    }
}
