package com.pen.roadmap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RoadmapApplication implements CommandLineRunner {

	@Autowired
	MyPrinter myPrinter;

	public static void main(String[] args) {
		SpringApplication.run(RoadmapApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		myPrinter.printAutowired();
		myPrinter.printConstructor();
		myPrinter.printSetter();
	}
}
