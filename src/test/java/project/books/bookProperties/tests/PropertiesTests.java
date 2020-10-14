package project.books.bookProperties.tests;

import org.junit.jupiter.api.Test;

import project.books.bookProperties.Book;

class PropertiesTests {

	@Test
	void testBookGetsSets() {
		Book book = new Book("Title", "Author", "Story", "read", 5, 5);
		book.setTitle("the title");
		System.out.println(book.getTitle());
		book.setAuthor("writer");
		System.out.println(book.getAuthor());
		book.setGenre("Scary");
		System.out.println(book.getGenre());
		book.setStatus("reading");
		System.out.println(book.getStatus());
		book.setPages(100);
		System.out.println(book.getPages());
		book.setRating(2);
		System.out.println(book.getRating());
	}

}
