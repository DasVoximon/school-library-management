package com.dasvoximon.libraries.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Book {

	String title;
	String author;
	Long isbn;

}
