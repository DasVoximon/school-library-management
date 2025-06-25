package com.dasvoximon.libraries.models;

@SuppressWarnings("unused")
public class Book {

	String title;
	String author;
	Long isbn;

	public Book() {}

	public Book(String title, String author, Long isbn) {
		this.title = title;
		this.author = author;
		this.isbn = isbn;
	}

	public String getTitle() { return title; }

	public void setTitle(String title) { this.title = title; }

	public String getAuthor() { return author; }

	public void setAuthor(String author) { this.author = author; }

	public Long getIsbn() { return isbn; }

	public void setIsbn(Long isbn) { this.isbn = isbn; }

}
