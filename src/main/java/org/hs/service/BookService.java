package org.hs.service;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.hs.model.Book;
import org.hs.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

	private BookRepository bookRepo;

	@Autowired
	public BookService(BookRepository bookRepo) {
		this.bookRepo = bookRepo;
	}

	public Book findBookByAuthorId(Integer authorId) {
		return bookRepo.findByAuthorId(authorId);
	}

	public Book findBookById(Integer id) {
		Optional<Book> book = bookRepo.findById(id);
		if (book.isPresent())
			return book.get();
		throw new EntityNotFoundException(String.format("Book was not found for parameters {id=%s}", id));
	}

	public Book save(Book book) {
		return bookRepo.save(book);
	}

	public Book updateBook(Book book, Integer bookId) {
		Optional<Book> bookFromId = bookRepo.findById(bookId);
		if (bookFromId.isPresent()) {
			Book book2 = bookFromId.get();
			book2.title = book.title;
			book2.authorId = book.authorId;
			book2.description = book.description;
			return bookRepo.save(book2);
		}
		return null;
	}
}
