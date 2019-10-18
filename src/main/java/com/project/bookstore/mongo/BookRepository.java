package com.project.bookstore.mongo;

import com.project.bookstore.entity.BookEntity;
import org.springframework.data.repository.Repository;

import java.util.Optional;

public interface BookRepository extends Repository<BookEntity, String> {

    BookEntity save(BookEntity saved);
    Optional<BookEntity> findByTitle(String Title);
    Optional<BookEntity> findByIsbn(String isbn);
    Optional<BookEntity> findByAuthor(String Author);
}
