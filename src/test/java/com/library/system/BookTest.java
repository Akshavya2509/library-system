package com.library.system;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class BookTest {
    @Test
    void booksWithSameIsbnShouldBeEqual() {
        Book book1 = new Book("1234567890", "Book Title", "Author Name");
        Book book2 = new Book("1234567890", "Another Title", "Another Author");

        assertEquals(book1, book2);
    }

    @Test
    void equalBooksShouldCollapseInHashSet() {
        Set<Book> set = new HashSet<>();
        set.add(new Book("123", "Effective Java", "Joshua Bloch"));
        set.add(new Book("123", "Effective Java", "Joshua Bloch"));

        assertEquals(1, set.size());
    }
}
