package com.example.demo.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.demo.domain.Book;
import com.example.demo.domain.Publisher;
import com.example.demo.domain.Author;
import com.example.demo.repository.AuthorRepository;
import com.example.demo.repository.BookRepository;
import com.example.demo.repository.PublisherRepository;

@Component
public class BootStrapData implements CommandLineRunner {
	
	private final AuthorRepository authorRepo;
	private final BookRepository bookRepo;
	private final PublisherRepository pubRepo;

	public BootStrapData(AuthorRepository authorRepo, BookRepository bookRepo, PublisherRepository pubRepo) {
		super();
		this.authorRepo = authorRepo;
		this.bookRepo = bookRepo;
		this.pubRepo = pubRepo;

	}

	@Override
	public void run(String... args) throws Exception {
		Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "123123");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepo.save(eric);
        bookRepo.save(ddd);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "3939459459");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        authorRepo.save(rod);
        bookRepo.save(noEJB);
        
        // Create POJO Publisher
        
        Publisher pub1 = new Publisher();

        pub1.setName("Long Nguyen");
        pub1.setAddress("1968 Anton Way");
        
        pubRepo.save(pub1);
        
        System.out.println("Started in Bootstrap");
        System.out.println("Number of Books: " + bookRepo.count());
        System.out.println("Publisher: " + pubRepo.count());
	}

}


