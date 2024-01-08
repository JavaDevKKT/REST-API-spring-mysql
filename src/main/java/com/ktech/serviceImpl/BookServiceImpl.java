package com.ktech.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.apache.catalina.authenticator.SavedRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ktech.entity.Book;
import com.ktech.repo.BookRepository;
import com.ktech.service.BookService;

@Service
public class BookServiceImpl implements BookService{
	@Autowired
	private BookRepository bookRepository;
	private  boolean existsBybookName;
	private String message;
	private Book updateBook;

	@Override
	public String createBook(Book book) {
      existsBybookName = bookRepository.existsBybookName(book.getBookName());
      if (existsBybookName) {
    	  message="Book Alreday Exist";
	} else {
		bookRepository.save(book);
		message="Book Successfully Save";
	}
		return message;
	}

	@Override
	public Book getBookById(Long id) {
		Optional<Book> byId = bookRepository.findById(id);
		return byId.get();
	}

	@Override
	public List<Book> getAllBooks() {
		List<Book> allBooks = bookRepository.findAll();
		return allBooks;
	}

	@Override
	public Book updateBook(Book book,Long id) {
	    Book byId = bookRepository.getById(id);
	      byId.setAutherName(book.getAutherName());
	      byId.setBookName(book.getBookName());
	      byId.setBookPrice(book.getBookPrice());
	      updateBook = bookRepository.save(byId);
		return updateBook;
	}

	@Override
	public String deleteBook(Long id) {
		Optional<Book> byId = bookRepository.findById(id);
        if (byId.isPresent()) {
    		bookRepository.deleteById(id);
    		message="Book Successfully Deleted";
		} else {
	    	  message="Book Not Exist";
		}
		return message;
	}
}
