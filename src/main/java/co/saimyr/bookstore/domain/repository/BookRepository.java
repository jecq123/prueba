package co.saimyr.bookstore.domain.repository;

import java.util.List;
import java.util.Optional;

import co.saimyr.bookstore.domain.BookDomain;
import co.saimyr.bookstore.domain.dto.BookDTO;
import co.saimyr.bookstore.persistence.entity.BookEntity;

public interface BookRepository {
	List<BookDomain> findAll();
	List<BookDomain> findByAuthor(String author);
	List<BookDomain> findByPublisher(String publisher);
	BookDomain save(BookDomain b);
	boolean delete(BookDomain b);
	BookDomain findByIsbn(int isbn);
}
