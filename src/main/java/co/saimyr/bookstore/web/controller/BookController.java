package co.saimyr.bookstore.web.controller;

import java.util.List;

import co.saimyr.bookstore.domain.dto.BookDTO;
import co.saimyr.bookstore.web.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import co.saimyr.bookstore.domain.service.BookService;

@RestController
@RequestMapping("/api/books")
@CrossOrigin(origins = "*", maxAge = 3600)
public class BookController {
	@Autowired
	private BookService bookService;
	
	@GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<BookDTO> getAll() {
		return bookService.getAll();
	}
	
	@GetMapping(value = "/author/{author}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<BookDTO> getByAuthor(@PathVariable("author") String author) {
		return bookService.getAllByAuthor(author);
	}

	@GetMapping(value = "/publisher/{publisher}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<BookDTO> getByPublisher(@PathVariable("publisher") String publisher) {
		return bookService.getAllByPublisher(publisher);
	}
	
	@PostMapping(value = "/new", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public BookDTO newBook(@RequestBody BookDTO b) {
		return bookService.newBook(b);
	}

	@DeleteMapping("/isbn/{isbn}")
	public ResponseEntity<Response> deleteByIsbn(@PathVariable("isbn") int isbn){
		bookService.deleteByIsbn(isbn);
		String message="Se ha borrado el libro con codigo "+ isbn +" satisfactoriamente";
		Response response=new Response();
		response.setMessage(message);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
