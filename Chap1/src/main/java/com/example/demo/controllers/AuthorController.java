package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.repository.AuthorRepository;

@Controller
@RequestMapping("/authors")
public class AuthorController {
	private AuthorRepository authorRepo;

	public AuthorController(AuthorRepository authorRepo) {
		super();
		this.authorRepo = authorRepo;
	}
	@GetMapping
	public String getAuthors (Model model) {
		model.addAttribute("authors", authorRepo.findAll());
		return "authors/list";
	}
	
}	
