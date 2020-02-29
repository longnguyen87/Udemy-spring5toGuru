package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.repository.BookRepository;

@Controller
public class BookController {
	private BookRepository bookRepo;

	public BookController(BookRepository book) {
		super();
		this.bookRepo = book;
	}
	
	@RequestMapping("/books")
	public String getBooks (Model model) {
		model.addAttribute("books", bookRepo.findAll());
		return "books/list";
	}
	
}
