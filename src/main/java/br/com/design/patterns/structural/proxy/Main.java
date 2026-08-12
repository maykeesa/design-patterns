package br.com.design.patterns.structural.proxy;

import br.com.base.service.ReportService;
import br.com.design.patterns.structural.proxy.service.ReportServiceImplProxy;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        ReportService reportService = new ReportServiceImplProxy();

        for (int i = 0; i < 2; i++) {
            long start = System.currentTimeMillis();
            String result = reportService.generate("1");

            String dadoFormatado = i == 0
                    ? "%d - %s%n".formatted(i + 1, result)
                    : "%d - %s (Cache) %n".formatted(i + 1, result);

            System.out.printf(dadoFormatado);
            System.out.printf("Tempo total: %.2fs%n", (System.currentTimeMillis() - start) / 1000.0);
        }
    }
}
