package com.dasvoximon.libraries.controllers;

import com.dasvoximon.libraries.models.*;
import com.dasvoximon.libraries.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/library/books")
public class BookController {

    @Autowired
    BookService service;

    // Get all books
	@GetMapping("/all-books")
	public List<Book> getBooks() {
        return service.getBooks();
    }

    // Get book by isbn
    @GetMapping("/{isbn}")
    public ResponseEntity<Book> getBook(@PathVariable Long isbn) {
        return getBooks().stream()
                .filter(book -> book.getIsbn().equals(isbn))
                .findFirst()
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
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
        boolean removed = getBooks().removeIf(book -> book.getIsbn().equals(isbn));

        if (removed) return ResponseEntity.ok("Book with ISBN: " + isbn + " has been removed succesfully");
        else return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Book with ISBN: " + isbn + " doesn't exist");
    }
}
