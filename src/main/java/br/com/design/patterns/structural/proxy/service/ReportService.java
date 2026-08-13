package br.com.design.patterns.structural.proxy.service;

public interface ReportService {

    String generate(String id) throws InterruptedException;
}
