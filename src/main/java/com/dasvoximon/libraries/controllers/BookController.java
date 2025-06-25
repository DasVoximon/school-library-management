package com.dasvoximon.libraries.controllers;

import com.dasvoximon.libraries.models.*;
import com.dasvoximon.libraries.service.BookCollection;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/library/books")
public class BookController {

    BookCollection bc = new BookCollection();

    // Get all books
	@GetMapping("/all-books")
	public List<Book> getBooks() { return bc.getBooks(); }

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
    public String totalBooks() { return bc.getTotalBooks(); }

    //Add book
    @PostMapping("/add-book")
    public Book addBook(@RequestBody Book newBook) {
        bc.addBook(newBook);
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
