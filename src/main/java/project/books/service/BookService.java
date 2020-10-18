package project.books.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.books.bookProperties.Book;
import project.books.exceptions.BookNotFound;
import project.books.repo.BooksRepo;

@Service
public class BookService {

	@Autowired
	private BooksRepo repo;

	public BookService(BooksRepo repo) {
		super();
		this.repo = repo;
	}

	public String test() {
		return "Testing";
	}

	public Book addBook(Book book) {
		return this.repo.save(book);
	}

	public Book updateBook(Book book, Long id) {
		Book oldBook = this.repo.findById(id).orElseThrow(() -> new BookNotFound());

		oldBook.setAuthor(book.getAuthor());
		oldBook.setTitle(book.getTitle());
		oldBook.setGenre(book.getGenre());
		oldBook.setStatus(book.getStatus());
		oldBook.setPages(book.getPages());
		oldBook.setRating(book.getRating());
		oldBook.setIsbn(book.getIsbn());
		oldBook.setCoverURL(book.getCoverURL());

		return this.repo.save(oldBook);
	}

	public boolean deleteBook(Long id) {
		this.repo.deleteById(id);
		return !this.repo.existsById(id);
	}

	public List<Book> getBooks() {
		return this.repo.findAll();
	}

	public Book findBookByID(Long id) {
		return this.repo.findById(id).orElseThrow(BookNotFound::new);
	}
}
