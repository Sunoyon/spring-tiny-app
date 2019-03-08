package org.hs.repository;

import java.util.Optional;

import org.hs.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

	Optional<Book> findById(Integer id);
	
	@NonNull
	Book findByAuthorId(Integer authorId);
	
	@NonNull
	Book findBytitle(@NonNull String title);
	
}
