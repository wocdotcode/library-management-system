package com.example.librarymanagementsystem;

import com.example.librarymanagementsystem.entity.Book;
import com.example.librarymanagementsystem.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class LibraryManagementSystemApplication implements ApplicationRunner {

	@Autowired
	private BookService bookService;


	public static void main(String[] args) {
		SpringApplication.run(LibraryManagementSystemApplication.class, args);
	}



	@Override
	public void run(ApplicationArguments args) throws Exception {

		List<Book> books = bookService.findAllBooks();

		if(books != null && books.isEmpty()) {


			Book book1 = Book.builder().name("Harry Potter and the Prisoner of Azkaban").price(1200.5).build();
			Book book2 = Book.builder().name("Sands of Time").price(800.2).build();
			Book book3 = Book.builder().name("Heartless").price(500.50).build();
			Book book4 = Book.builder().name("The Alchemist").price(1500.50).build();

			Arrays.asList(book1, book2, book3, book4).forEach(b -> bookService.createBook(b));

			System.out.println("New books added in database");
		}

	}
}
