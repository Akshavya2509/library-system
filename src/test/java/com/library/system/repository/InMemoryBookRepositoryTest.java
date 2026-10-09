package com.library.system.repository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import com.library.system.Book;

public class InMemoryBookRepositoryTest {

    InMemoryBookRepository bookRepository;

    @BeforeEach
    public void setup() {
        bookRepository = new InMemoryBookRepository();
        Book book1 = new Book("1234567890", "The Great Gatsby", "F. Scott Fitzgerald");
        Book book2 = new Book("0987654321", "To Kill a Mockingbird", "Harper Lee");
        Book book3 = new Book("1122334455", "1984", "George Orwell");
        bookRepository.save(book1);
        bookRepository.save(book2);
        bookRepository.save(book3);
    }

    @ParameterizedTest
    @CsvSource({
            "1234567890, The Great Gatsby",
            "0987654321, To Kill a Mockingbird",
            "1122334455, 1984"
    })
    public void testSaveAndFindByIsbn(String isbn, String title) {
        assertEquals(title, bookRepository.findByIsbn(isbn).get().title());
    }

    @ParameterizedTest
    @ValueSource(strings = { "0000000000", "1111111111", "2222222222" })
    public void invalidISBNReturnsEmpty(String isbn) {
        assertFalse(bookRepository.findByIsbn(isbn).isPresent());
    }

    @ParameterizedTest
    @ValueSource(strings = { "F. Scott Fitzgerald", "Harper Lee", "George Orwell" })
    public void testFindByAuthor(String author) {
        assertEquals(1, bookRepository.findByAuthor(author).size());
    }

    @ParameterizedTest
    @ValueSource(strings = { "the great gatsby", "THE GREAT GATSBY", "Great Gatsby" })
    void findByTitleIsCaseInsensitive(String title) {
        assertEquals(1, bookRepository.findByTitle(title).size());
    }

    @Test
    public void testFindAll() {
        List<Book> books = bookRepository.findAll();
        assertEquals(3, books.size());

        assertThrows(UnsupportedOperationException.class,
                () -> books.add(new Book("5566778899", "Brave New World", "Aldous Huxley")));
    }
}
