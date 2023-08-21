package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long book_id;
	private String book_name;

	public Book() {
		// TODO Auto-generated constructor stub
	}

	public void setBook_id(Long book_id) {
		this.book_id = book_id;
	}

	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}

	public Long getBook_id() {
		return book_id;
	}

	public String getBook_name() {
		return book_name;
	}
}
