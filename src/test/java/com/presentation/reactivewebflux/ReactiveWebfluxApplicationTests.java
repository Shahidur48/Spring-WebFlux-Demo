package com.presentation.reactivewebflux;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@SpringBootTest
class ReactiveWebfluxApplicationTests {

	@Test
	public void testMono() {
		Mono<String> monoString = Mono.just("java").log();
		monoString.subscribe(System.out::println);
	}

	@Test
	public void testFlux() {
		Flux<String> fluxString = Flux.just("java","spring","Hibernate","Cloud")
				.log();
		fluxString.subscribe(System.out::println);
	}

}
