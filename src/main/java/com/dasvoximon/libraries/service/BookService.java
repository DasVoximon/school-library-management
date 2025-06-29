package com.dasvoximon.libraries.service;

import com.dasvoximon.libraries.models.Book;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class BookService {

    private static final List<Book> books = Arrays.asList(
            new Book("The Hobbit", "J.R.R. Tolkien", 9780547928227L),
            new Book("Fahrenheit 451", "Ray Bradbury", 9781451673319L),
            new Book("Moby-Dick", "Herman Melville", 9781503280786L),
            new Book("War and Peace", "Leo Tolstoy", 9781400079988L),
            new Book("Crime and Punishment", "Fyodor Dostoevsky", 9780143107637L),
            new Book("To Kill a Mockingbird", "Harper Lee", 9780061120084L),
            new Book("1984", "George Orwell", 9780451524935L),
            new Book("The Great Gatsby", "F. Scott Fitzgerald", 9780743273565L),
            new Book("Pride and Prejudice", "Jane Austen", 9780141439518L),
            new Book("The Catcher in the Rye", "J.D. Salinger", 9780316769488L),
            new Book("The Return", "Jonathan McCoy", 983773829937L)
            );

    public List<Book> getBooks() { return books; }

    public void addBook(Book book) { books.add(book); }

    public String getTotalBooks() {
        return String.format("Total number of books in library is %d", getBooks().size());
    }

    public ResponseEntity<Book> getBookByISBN(Long isbn) {
        return getBooks().stream()
                .filter(book -> book.getIsbn().equals(isbn))
                .findFirst()
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    public ResponseEntity<String> removeBookByISBN(Long isbn) {
        boolean removed = getBooks().removeIf(book -> book.getIsbn().equals(isbn));

        if (removed)
            return ResponseEntity.ok("Book with ISBN: " + isbn + " has been removed successfully");
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Book with ISBN: " + isbn + " doesn't exist");
    }
}

//  {
//    "title": "The Silent Patient",
//    "author": "Alex Michaelides",
//    "isbn": 9781250301697
//  },
//  {
//    "title": "Where the Crawdads Sing",
//    "author": "Delia Owens",
//    "isbn": 9780735219090
//  },
//  {
//    "title": "Project Hail Mary",
//    "author": "Andy Weir",
//    "isbn": 9780593135204
//  },
//  {
//    "title": "The Midnight Library",
//    "author": "Matt Haig",
//    "isbn": 9780525559474
//  },
//  {
//    "title": "Educated",
//    "author": "Tara Westover",
//    "isbn": 9780399590504
//  }

