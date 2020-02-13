package com.example.bookStore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.bookStore.domain.Book;
import com.example.bookStore.domain.BookRepository;
import com.example.bookStore.domain.Category;
import com.example.bookStore.domain.CategoryRepository;
import com.sun.tools.sjavac.Log;

@SpringBootApplication
public class BookStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookStoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner booklist(BookRepository brepository, CategoryRepository crepository) {
		return (args) -> {

			crepository.save(new Category("IT"));
			crepository.save(new Category("Biology"));
			crepository.save(new Category("Business"));
			
			brepository.save(new Book("Simon", "JAVA","01012020","2020", crepository.findByName("IT").get(0)));
			brepository.save(new Book("Lee", "Python","01012020","2020", crepository.findByName("Business").get(0)));
		
		};
	}

}
