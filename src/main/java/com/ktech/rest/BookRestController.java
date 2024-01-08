package com.ktech.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ktech.constants.Constants;
import com.ktech.entity.Book;
import com.ktech.service.BookService;

@RestController
@RequestMapping(value = Constants.REQ_MEPPING)
public class BookRestController {
	@Autowired
	private BookService sBookService;

	@PostMapping(value = Constants.SAVE_BOOK, produces = "application/json", consumes = "application/json")
	public ResponseEntity<String> saveBook(@RequestBody Book book) {
		String bookSaveStatus = sBookService.createBook(book);
		return new ResponseEntity<String>(bookSaveStatus, HttpStatus.CREATED);
	}

	@DeleteMapping(value = Constants.DELETE_BOOK)
	public ResponseEntity<String> DeleteBook(@PathVariable Long id) {
		String bookSaveStatus = sBookService.deleteBook(id);
		return new ResponseEntity<String>(bookSaveStatus, HttpStatus.OK);
	}

	@GetMapping(value = Constants.GET_ALL_BOOKS)
	public ResponseEntity<List<Book>> getListBooks() {
		List<Book> allBooks = sBookService.getAllBooks();
		return new ResponseEntity<List<Book>>(allBooks, HttpStatus.OK);
	}

	@PutMapping(value = Constants.UPDATE_BOOK, produces = "application/json", consumes = "application/json")
	public ResponseEntity<Book> updateBook(@RequestBody Book book, @PathVariable Long id) {
		Book updateBook = sBookService.updateBook(book, id);
		return new ResponseEntity<Book>(updateBook, HttpStatus.CREATED);
	}

	@GetMapping(value = Constants.GET_BOOK)
	public ResponseEntity<Book> getBook(@PathVariable Long id) {
		Book bookById = sBookService.getBookById(id);
		return new ResponseEntity<Book>(bookById, HttpStatus.OK);
	}
}
