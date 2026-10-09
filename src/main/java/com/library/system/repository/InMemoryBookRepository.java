package com.library.system.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.library.system.Book;

public class InMemoryBookRepository implements BookRepository {
    private final Map<String, Book> store = new HashMap<>();

    @Override
    public void save(Book book) {
        store.put(book.isbn(), store.getOrDefault(book.isbn(), book));
    }

    @Override 
    public Optional<Book> findByIsbn(String isbn) {
        return Optional.ofNullable(store.get(isbn));
    }

    @Override
    public List<Book> findByAuthor(String author) {
        return store.values().stream()
                .filter(book -> book.author().equalsIgnoreCase(author))
                .toList();
    }

    @Override 
    public List<Book> findByTitle(String title) {
        return store.values().stream()
                .filter(book -> book.title().toLowerCase().contains(title.toLowerCase()))
                .toList();
    }

    @Override
    public List<Book> findAll() {
        return Collections.unmodifiableList(new ArrayList<>(store.values()));
    }
}
