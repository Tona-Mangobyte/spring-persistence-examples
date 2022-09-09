package com.mb.persistence;

import com.mb.persistence.models.Author;
import com.mb.persistence.models.Book;
import com.mb.persistence.repositories.AuthorRepository;
import com.mb.persistence.repositories.BookRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SimplePersistenceApplicationTests {

	@Autowired
	AuthorRepository authorRepository;

	@Autowired
	BookRepository bookRepository;

	@Test
	void contextLoads() {
		Assertions.assertEquals(1, 1);
	}


	@Test
	void insertAuthor() {
		Author author = new Author();
		author.setId(5L);
		author.setName("Anghel Leonard");
		author.setGenre("Simple");
		author.setAge(45);
		Book book = new Book();
		book.setTitle("Spring Persistence");
		book.setIsbn("ISBN-325-545-655");
		author.addBook(book);
		author = authorRepository.save(author);
		Assertions.assertEquals("Anghel Leonard", author.getName());
		Assertions.assertEquals(45, author.getAge());
	}

	@Test
	void insertBook() {
		Book book = new Book();
		book.setTitle("Spring Data JPA");
		book.setIsbn("ISBN-325-546-656");
		Author author = new Author();
		author.setId(5L);
		author.setName("Anghel Leonard");
		author.setGenre("Simple");
		author.setAge(45);
		book.setAuthor(author);
		book = bookRepository.save(book);
		Assertions.assertEquals("Spring Data JPA", book.getTitle());
		Assertions.assertEquals("ISBN-325-546-656", book.getIsbn());
	}
}
