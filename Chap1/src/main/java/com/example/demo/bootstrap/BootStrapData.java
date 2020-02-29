package com.example.demo.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.demo.domain.Book;
import com.example.demo.domain.Author;
import com.example.demo.repository.AuthorRepository;
import com.example.demo.repository.BookRepository;

@Component
public class BootStrapData implements CommandLineRunner {
	
	private final AuthorRepository authorRepo;
	private final BookRepository bookRepo;
	
	public BootStrapData(AuthorRepository authorRepo, BookRepository bookRepo) {
		super();
		this.authorRepo = authorRepo;
		this.bookRepo = bookRepo;
	}

	@Override
	public void run(String... args) throws Exception {
		Book ddd = new Book("Domain Driven Design", "12345");
		Author longng = new Author("Long", "Nguyen");
		longng.getBooks().add(ddd);
		ddd.getAuthors().add(longng);
		authorRepo.save(longng);
		bookRepo.save(ddd);
	}

}
