package com.example.demo;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import com.example.demo.controller.BookController;
import com.example.demo.model.Book;
import com.example.demo.service.BookService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebMvcTest(BookController.class)
public class BookControllerTest {
	
	 @Autowired
	    private MockMvc mockMvc;

	    @MockBean
	    private BookService bookService;

	    @Test
	    public void testGetAllBooks() throws Exception {
	        List<Book> mockBooks = new ArrayList<>();
	        // Add mock Book objects to mockBooks list

	        Mockito.when(bookService.getAllBooks()).thenReturn(mockBooks);

	        mockMvc.perform(get("/api/books/allbooks"))
	            .andExpect(status().isOk())
	            .andExpect((ResultMatcher) jsonPath("$", hasSize(mockBooks.size())));
	    }

	    private Object hasSize(int size) {
			// TODO Auto-generated method stub
			return null;
		}

		@Test
	    public void testGetBookById() throws Exception {
	        Long bookId = 121L;
	        Book mockBook = new Book();
	        // Set properties of mockBook

	        Mockito.when(bookService.getBookById(bookId)).thenReturn(mockBook);

	        mockMvc.perform(get("/api/books/{id}", bookId))
	            .andExpect(status().isOk())
	            .andExpect(jsonPath("$.id", is(mockBook.getBook_id())));
	            // Add more assertions for other properties
	    }

	    @Test
	    public void testCreateBook() throws Exception {
	        Book mockBook = new Book();
	        // Set properties of mockBook

	        Mockito.when(bookService.createBook(Mockito.any(Book.class))).thenReturn(mockBook);

	        mockMvc.perform(post("/api/books")
	            .contentType(MediaType.APPLICATION_JSON)
	            .content(asJsonString(mockBook)))
	            .andExpect(status().isOk())
	            .andExpect(jsonPath("$.id", is(mockBook.getBook_id())));
	            // Add more assertions for other properties
	    }

	    @Test
	    public void testUpdateBook() throws Exception {
	        Long bookId = 121L;
	        Book mockBook = new Book();
	        // Set properties of mockBook

	        Mockito.when(bookService.updateBook(eq(bookId), Mockito.any(Book.class))).thenReturn(mockBook);

	        mockMvc.perform(put("/api/books/{id}", bookId)
	            .contentType(MediaType.APPLICATION_JSON)
	            .content(asJsonString(mockBook)))
	            .andExpect(status().isOk())
	            .andExpect(jsonPath("$.id", is(mockBook.getBook_id())));
	            // Add more assertions for other properties
	    }

	    @Test
	    public void testDeleteBook() throws Exception {
	        Long bookId = 121L;

	        mockMvc.perform(delete("/api/books/{id}", bookId))
	            .andExpect(status().isOk());

	        Mockito.verify(bookService, times(1)).deleteBook(bookId);
	    }

	    // Helper method to convert objects to JSON string
	    private static String asJsonString(final Object obj) {
	        try {
	            return new ObjectMapper().writeValueAsString(obj);
	        } catch (Exception e) {
	            throw new RuntimeException(e);
	        }
	    }

}
