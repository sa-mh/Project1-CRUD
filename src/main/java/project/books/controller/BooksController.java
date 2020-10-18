package project.books.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import project.books.bookProperties.Book;
import project.books.service.BookService;

@RestController
@CrossOrigin
public class BooksController {

	private BookService service;

	public BooksController(BookService service) {
		super();
		this.service = service;
	}

	@GetMapping("/")
	public String greeting() {
		return "Testing";
	}

	@PostMapping("/addbook")
	public ResponseEntity<Book> createDuck(@RequestBody Book book) {
		return new ResponseEntity<Book>(this.service.addBook(book), HttpStatus.CREATED);
	}

	@PutMapping("/updatebook")
	public ResponseEntity<Book> updateDuck(@RequestBody Book book, @PathParam("id") Long id) {
		return new ResponseEntity<Book>(this.service.updateBook(book, id), HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/remove/{id}")
	public ResponseEntity<Object> deleteDuck(@PathVariable Long id) {
		if (this.service.deleteBook(id)) {
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/getbooks")
	public ResponseEntity<List<Book>> getBooks() {
		return ResponseEntity.ok(this.service.getBooks());
	}

	@GetMapping("/getbook/{id}")
	public ResponseEntity<Book> getBook(@PathVariable Long id) {
		return ResponseEntity.ok(this.service.findBookByID(id));
	}

}
