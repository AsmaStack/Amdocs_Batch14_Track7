package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Book;
import com.example.demo.service.BookService;


@RestController
@RequestMapping("/api/books")
public class BookController {

	private BookService bookservice;

	@Autowired
	public BookController(BookService bookservice) {
		
		this.bookservice = bookservice;
	}
	
	//select *From book;
    //http://localhost:8085/api/books/allbooks

    @GetMapping("/allbooks")
    public List<Book> getAllBooks() {
        return bookservice.getAllBooks();
    }

    //select *From book where book_id=121;
    //http://localhost:8085/api/books/121
    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id) {
        return bookservice.getBookById(id);
    }

   

 @PostMapping
    public Book createBook(@RequestBody Book book) {
        return bookservice.createBook(book);
    }

    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody Book book) {
        return bookservice.updateBook(id, book);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookservice.deleteBook(id);
    }
	
	
	
}
