package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Book;
import com.example.demo.repo.BookRepo;


@Service
public class BookService {

	private BookRepo brepo;

	@Autowired
	public BookService(BookRepo brepo) {
		
		this.brepo = brepo;
	}
	
	
	   public List<Book> getAllBooks() {
	        return brepo.findAll();
	    }
	   

	    public Book getBookById(Long id) {
	        return brepo.findById(id).orElse(null);
	    }

	    public Book createBook(Book book) {
	        return brepo.save(book);
	    }

	    public Book updateBook(Long id, Book book) {
	        Book existingBook = brepo.findById(id).orElse(null);
	        if (existingBook != null) {
	            existingBook.setBook_id(book.getBook_id());
	            existingBook.setBook_name(book.getBook_name());
	            return brepo.save(existingBook);
	        }
	        return null;
	    }

	    public void deleteBook(Long id) {
	        brepo.deleteById(id);
	    }
	
	
	
}
