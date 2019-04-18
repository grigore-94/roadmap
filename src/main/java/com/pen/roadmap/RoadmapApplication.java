package com.pen.roadmap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.function.IntSupplier;
import java.util.stream.IntStream;

@SpringBootApplication
public class RoadmapApplication implements CommandLineRunner {


	public static void main(String[] args) {
		SpringApplication.run(RoadmapApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {


		IntSupplier fibV1 = new IntSupplier() {
			private int previous = 0;
			private int current = 1;

			public int getAsInt() {
				int nextValue = this.previous + this.current;
				this.previous = this.current;
				this.current = nextValue;
				return this.previous;
			}
		};

		final int[] previous = {0};
		final int[] current = {1};
		IntSupplier fibV2 = () -> {
			int nextValue = previous[0] + current[0];
			previous[0] = current[0];
			current[0] = nextValue;
			return previous[0];

		};

		System.out.println("fib version 1");
		IntStream.generate(fibV1).limit(10).forEach(System.out::println);

		System.out.println("fib version 2");
		IntStream.generate(fibV2).limit(10).forEach(System.out::println);
	}
}
