package com.pen.roadmap;

import org.springframework.stereotype.Service;

@Service
public class PrintAutowired implements Printer {
    @Override
    public void print() {
        System.out.println("print from: " + PrintAutowired.class);
    }
}
