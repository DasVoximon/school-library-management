package com.dasvoximon.libraries.controllers;

import com.dasvoximon.libraries.models.*;
import com.dasvoximon.libraries.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/library/books")
public class BookController {

    @Autowired
    BookService service;

    // Get all books
	@GetMapping
	public List<Book> getBooks() {
        return service.getBooks();
    }

    // Get book by isbn
    @GetMapping("/{isbn}")
    public ResponseEntity<Book> getBookByISBN(@PathVariable Long isbn) {
        return service.getBookByISBN(isbn);
    }

    // Get Total Amount of Books
    @GetMapping("/no-of-books")
    public String totalBooks() {
        return service.getTotalBooks();
    }

    //Add book
    @PostMapping("/add-book")
    public Book addBook(@RequestBody Book newBook) {
        service.addBook(newBook);
        return newBook;
    }

    // Delete book by ISBN
    @DeleteMapping("/{isbn}")
    public ResponseEntity<String> removeBook(@PathVariable Long isbn) {
        return service.removeBookByISBN(isbn);
    }
}
