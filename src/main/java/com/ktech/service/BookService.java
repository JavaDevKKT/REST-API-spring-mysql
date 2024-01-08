package com.ktech.service;

import java.util.List;
import com.ktech.entity.Book;

public interface BookService {
	String createBook(Book book);

	Book getBookById(Long id);

	List<Book> getAllBooks();

	Book updateBook(Book book,Long id);

	String deleteBook(Long id);
}
