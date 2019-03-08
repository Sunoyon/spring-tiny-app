package org.hs.controller;

import javax.validation.Valid;

import org.hs.model.Book;
import org.hs.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class BookController {
	
	private BookService bookService;
	
	@Autowired
	public BookController(BookService bookService) {
		this.bookService = bookService;
	}
	
	@RequestMapping(value = {"/"}, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Book insertBook(@RequestBody @Valid Book book) {
		return bookService.save(book);
	}

	@RequestMapping(value = {"/{bookId}"}, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Book getBook(@PathVariable Integer bookId) {
		return bookService.findBookById(bookId);
	}

	@RequestMapping(value = {"/{bookId}"}, method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Book updateBook(@RequestBody @Valid Book book, @PathVariable Integer bookId) {
		return bookService.updateBook(book, bookId);
	}
}
