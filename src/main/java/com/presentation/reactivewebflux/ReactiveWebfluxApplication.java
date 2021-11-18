package com.presentation.reactivewebflux;

import com.presentation.reactivewebflux.model.Customer;
import com.presentation.reactivewebflux.repository.CustomerRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.r2dbc.core.DatabaseClient;
import reactor.core.publisher.Flux;

import java.util.stream.Stream;

@SpringBootApplication
public class ReactiveWebfluxApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReactiveWebfluxApplication.class, args);
	}

//	@Bean
//	ApplicationRunner init(CustomerRepository repository, DatabaseClient client)  {
//		return args -> {
//			client.execute("create table IF NOT EXISTS CUSTOMER" +
//					"(id SERIAL PRIMARY KEY, name varchar (255) not null, email varchar (255) not null);").fetch().first().subscribe();
//			client.execute("DELETE FROM CUSTOMER;").fetch().first().subscribe();
//
//			Stream<Customer> stream = Stream.of(new Customer("Imran", "imran@gmail.com"));
//
//			// initialize the database
//
//			repository.saveAll(Flux.fromStream(stream))
//					.then()
//					.subscribe(); // execute
//
//		};
//	}

}
