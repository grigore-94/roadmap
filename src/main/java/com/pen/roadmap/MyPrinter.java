package com.pen.roadmap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class MyPrinter {

    @Autowired
    @Qualifier("printAutowired")
    private Printer printerAutowired;

    private Printer printerConstructor;

    private Printer printerSetter;

    MyPrinter(@Qualifier("printConstructor") Printer printer) {
        this.printerConstructor = printer;
    }

    @Autowired
    public void setPrinterSetter(@Qualifier("printSetter") Printer printerSetter) {
        this.printerSetter = printerSetter;
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
}
