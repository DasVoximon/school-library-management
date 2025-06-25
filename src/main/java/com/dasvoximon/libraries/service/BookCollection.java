package com.dasvoximon.libraries.service;

import com.dasvoximon.libraries.models.Book;

import java.util.ArrayList;
import java.util.List;

public class BookCollection {
    public static final List<Book> books = new ArrayList<>();

    static {
        books.add(new Book("The Hobbit", "J.R.R. Tolkien", 9780547928227L));
        books.add(new Book("Fahrenheit 451", "Ray Bradbury", 9781451673319L));
        books.add(new Book("Moby-Dick", "Herman Melville", 9781503280786L));
        books.add(new Book("War and Peace", "Leo Tolstoy", 9781400079988L));
        books.add(new Book("Crime and Punishment", "Fyodor Dostoevsky", 9780143107637L));
        books.add(new Book("To Kill a Mockingbird", "Harper Lee", 9780061120084L));
        books.add(new Book("1984", "George Orwell", 9780451524935L));
        books.add(new Book("The Great Gatsby", "F. Scott Fitzgerald", 9780743273565L));
        books.add(new Book("Pride and Prejudice", "Jane Austen", 9780141439518L));
        books.add(new Book("The Catcher in the Rye", "J.D. Salinger", 9780316769488L));
        books.add(new Book("The Return", "Jonathan McCoy", 983773829937L));
    }

    public List<Book> getBooks() { return books; }

    public void addBook(Book book) { books.add(book); }

    public String getTotalBooks() {
        return String.format("Total number of books in library is %d", getBooks().size());
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

