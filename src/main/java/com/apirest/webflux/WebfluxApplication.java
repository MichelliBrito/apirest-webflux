package com.apirest.webflux;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import reactor.core.publisher.Flux;


@SpringBootApplication
public class WebfluxApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebfluxApplication.class, args);
		System.out.println("Ola mundo com webflux!!! ");

		Flux<String> colorFlux = Flux.just("black", "white", "blue");

			colorFlux
				.log()
				.map(String::toUpperCase);
//			.subscribe();
//			.subscribe(System.out::println);
	}
	

}

