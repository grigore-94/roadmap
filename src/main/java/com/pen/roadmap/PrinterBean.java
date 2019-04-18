package com.pen.roadmap;

public class PrinterBean implements Printer {
    @Override
    public void print() {
        System.out.println("print from: " + PrinterBean.class);
    }
}
