package br.com.design.patterns.proxy.service;

import br.com.base.service.ReportService;
import br.com.base.service.ReportServiceImpl;
import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;

import java.util.concurrent.TimeUnit;

public class ReportServiceImplProxy implements ReportService {

    private final ReportServiceImpl reportService;
    private final Cache<String, String> cache;

    public ReportServiceImplProxy() {
        this.reportService = new ReportServiceImpl();
        this.cache = Caffeine.newBuilder()
                .expireAfterWrite(10, TimeUnit.MINUTES)
                .maximumSize(100)
                .build();
    }

    @Override
    public String generate(String id) throws InterruptedException {
        String cached = cache.getIfPresent(id);
        if (cached != null) return cached;

        String report = reportService.generate(id);
        cache.put(id, report);

        return report;
    }
}
