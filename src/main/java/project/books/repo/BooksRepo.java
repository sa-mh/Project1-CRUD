package project.books.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import project.books.bookProperties.Book;

public interface BooksRepo extends JpaRepository<Book, Long> {

}
