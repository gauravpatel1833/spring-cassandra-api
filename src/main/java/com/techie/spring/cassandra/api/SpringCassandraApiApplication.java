package com.techie.spring.cassandra.api;

import com.techie.spring.cassandra.api.model.Author;
import com.techie.spring.cassandra.api.model.Book;
import com.techie.spring.cassandra.api.repository.AuthorRepository;
import com.techie.spring.cassandra.api.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

@SpringBootApplication
public class SpringCassandraApiApplication {

	@Autowired
	AuthorRepository authorRepository;

	@Autowired
	BookRepository bookRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringCassandraApiApplication.class, args);
	}

	@PostConstruct
	public void start(){
		initAuthor();
		initBook();
	}

	private void initBook() {
		Book book = new Book();
		book.setId("455");
		book.setName("The C");
		book.setDescription("Language for programming");
		book.setPublishedDate(LocalDate.now());
		book.setCoverIds(Arrays.asList("First", "Second", "Third"));
		book.setAuthorNames(Arrays.asList("Gaurav","Nayan","Pratik"));
		book.setAuthorIds(Arrays.asList("123","124"));

		System.out.println("Inserting the Book Object");
		bookRepository.save(book);
	}

	private void initAuthor() {
		Author author = new Author();
		author.setId("124");
		author.setName("Nayan");
		author.setPersonalName("Dewas");

		System.out.println("Inserting the author object");
		authorRepository.save(author);
	}

}
