package com.example.bookStore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.bookStore.domain.Book;
import com.example.bookStore.domain.BookRepository;

@SpringBootApplication
public class BookStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookStoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner booklist(BookRepository repository) {
		return (args) -> {
			Book b1 = new Book("Chen James", "CoronaVirus Research", "12122019", "2020");
			Book b2 = new Book("Li Hong", "5G War", "12112019", "2021");
			Book b3 = new Book("Koskinen Mika", "Finland Equality", "11122019", "2022");

			repository.save(b1);
			repository.save(b2);
			repository.save(b3);
		};
	}

}
