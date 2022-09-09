package com.mb.persistence.repositories;

import com.mb.persistence.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
