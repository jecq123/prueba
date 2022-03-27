package co.saimyr.bookstore.persistence;

import java.util.List;
import java.util.Optional;

import co.saimyr.bookstore.domain.BookDomain;
import co.saimyr.bookstore.persistence.entity.BookEntity;
import co.saimyr.bookstore.persistence.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.saimyr.bookstore.domain.repository.BookRepository;
import co.saimyr.bookstore.persistence.crud.CrudBookRepository;

@Repository
public class BookRepositoryImpl implements BookRepository {
	@Autowired
	private CrudBookRepository h2BookRepo;
	@Autowired
	private BookMapper bookMapper;

	@Override
	public List<BookDomain> findAll() {
		List<BookEntity> bookList= (List<BookEntity>) h2BookRepo.findAll();
		return bookMapper.entityListToDomain(bookList);
	}
	
	@Override
	public List<BookDomain> findByAuthor(String author) {
		List<BookEntity> bookList= h2BookRepo.findByAuthor(author);
		return bookMapper.entityListToDomain(bookList);
	}

	@Override
	public List<BookDomain> findByPublisher(String publisher) {
		List<BookEntity> bookList= h2BookRepo.findByPublisher(publisher);
		return bookMapper.entityListToDomain(bookList);
	}

	@Override
	public BookDomain save(BookDomain b) {
		BookEntity bookEntity= h2BookRepo.save(bookMapper.bookDomainToEntity(b));
		return bookMapper.bookEntityToDomain(bookEntity);
	}

	@Override
	public boolean delete(BookDomain b) {
		h2BookRepo.delete(bookMapper.bookDomainToEntity(b));
		return true;
	}

	@Override
	public BookDomain
	findByIsbn(int isbn) {
		Optional<BookEntity> bookEntity=h2BookRepo.findById(isbn);
		return bookMapper.bookEntityToDomain(bookEntity.orElse(null));
	}
}
