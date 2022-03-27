package co.saimyr.bookstore.domain.service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import co.saimyr.bookstore.domain.BookDomain;
import co.saimyr.bookstore.domain.dto.BookDTO;
import co.saimyr.bookstore.domain.exception.BookNotFoundException;
import co.saimyr.bookstore.domain.repository.BookRepository;
import static co.saimyr.bookstore.domain.validator.ArgumentsValidator.validateListNotEmpty;
import static co.saimyr.bookstore.domain.validator.ArgumentsValidator.validateNotNull;
import co.saimyr.bookstore.persistence.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
	@Autowired
	private BookRepository bookRepository;
	@Autowired
	private BookMapper bookMapper;

	public List<BookDTO> getAll() {
		String message= "No se encontraron libros";
		List<BookDomain> booksDomain=bookRepository.findAll().stream().sorted(Comparator.comparing(BookDomain::getName)).collect(Collectors.toList());
		validateListNotEmpty(booksDomain,message);
		return bookMapper.domainListToDTO(booksDomain);
	}
	public List<BookDTO> getAllByAuthor(String author) {
		String message= "No se encontraron libros del autor "+ author;
		List<BookDomain> booksDomain =bookRepository.findByAuthor(author);
		validateListNotEmpty(booksDomain,message);
		return bookMapper.domainListToDTO(booksDomain);
	}
	public List<BookDTO> getAllByPublisher(String publisher) {
		String message= "No se encontraron libros de la editorial "+ publisher;
		List<BookDomain> booksDomain =bookRepository.findByPublisher(publisher);
		validateListNotEmpty(booksDomain,message);
		return bookMapper.domainListToDTO(booksDomain);
	}
	public BookDTO newBook(BookDTO b) {
		BookDomain bookDomain=bookRepository.save(bookMapper.bookDTOToDomain(b));
		return bookMapper.bookDomainToDTO(bookDomain);
	}
	public  BookDTO getByIsbn(int isbn){
		String message= "No se encontraron libros con el isbn " + isbn;
		BookDomain bookDomain=bookRepository.findByIsbn(isbn);
		validateNotNull(bookDomain,message);
		return bookMapper.bookDomainToDTO(bookDomain);
	}
	public void deleteByIsbn(int isbn)
	{
		String message= "No se encontraron libros con el isbn " + isbn;
		BookDomain bookDomain=bookRepository.findByIsbn(isbn);
		validateNotNull(bookDomain,message);
		bookRepository.delete(bookDomain);
	}
}
