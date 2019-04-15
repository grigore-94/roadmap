package com.pen.roadmap;

import org.springframework.stereotype.Service;

@Service
public class PrintConstructor implements Printer {
    @Override
    public void print() {
        System.out.println("print from: " + PrintConstructor.class);
    }
}
