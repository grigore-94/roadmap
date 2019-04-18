package com.pen.roadmap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

@Service
@Configuration
public class MyPrinter {

    @Autowired
    @Qualifier("printAutowired")
    private Printer printerAutowired;

    private Printer printerConstructor;

    private Printer printerSetter;

    @Autowired
    private PrinterBean printerBean;

    MyPrinter(@Qualifier("printConstructor") Printer printer) {
        this.printerConstructor = printer;
    }

    @Autowired
    public void setPrinterSetter(@Qualifier("printSetter") Printer printerSetter) {
        this.printerSetter = printerSetter;
    }

    @Bean
    public Printer printerBean() {
        System.out.println("bean creation");
        return new PrinterBean();
    }

    public void printAutowired() {
        this.printerAutowired.print();
    }

    public void printConstructor() {
        this.printerConstructor.print();
    }

    public void printSetter() {
        this.printerSetter.print();
    }


    public void printBean() {
        this.printerBean.print();
    }

}
