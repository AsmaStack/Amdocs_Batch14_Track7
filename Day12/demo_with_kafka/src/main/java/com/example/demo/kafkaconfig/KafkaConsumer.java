package com.example.demo.kafkaconfig;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.example.demo.model.Book;

@Service
public class KafkaConsumer {

    @KafkaListener(topics = "bookcreated_successtopic", groupId = "book_group")
    public Book consume(Book book) {
    	return book;
        
        // You can perform further processing or save the book to your system
    }
}
