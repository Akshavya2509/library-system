package com.library.system.repository;

import java.util.List;
import java.util.Optional;

import com.library.system.Book;

public interface BookRepository {
    void save(Book book);
    Optional<Book> findByIsbn(String isbn);
    List<Book> findByAuthor(String author);
    List<Book> findByTitle(String title);
    List<Book> findAll();
}
