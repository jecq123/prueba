package co.saimyr.bookstore.persistence.crud;

import java.util.List;

import co.saimyr.bookstore.persistence.entity.BookEntity;
import org.springframework.data.repository.CrudRepository;

public interface CrudBookRepository extends CrudRepository<BookEntity, Integer> {
	List<BookEntity> findByAuthor(String author);
	List<BookEntity> findByPublisher(String publisher);
}
