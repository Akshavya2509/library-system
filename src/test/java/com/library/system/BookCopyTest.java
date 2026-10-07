package com.library.system;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class BookCopyTest {

    private final Book book = new Book("1234567890", "Book Title", "Author Name");

    @Test
    void newCopyIsAvailable() {
        BookCopy copy = new BookCopy("copy1", book);
        assertEquals(CopyStatus.AVAILABLE, copy.getStatus());
    }

    @Test
    void borrowedCopyHasBorrowedStatus() {
        BookCopy copy = new BookCopy("copy1", book);
        copy.markBorrowed();
        assertEquals(CopyStatus.BORROWED, copy.getStatus());
    }

    @Test
    void copiesWithDifferentIdsAreNotEqual() {
        BookCopy copy1 = new BookCopy("copy1", book);
        BookCopy copy2 = new BookCopy("copy2", book);
        assertNotEquals(copy1, copy2);
    }

    @Test
    void copiesWithSameIdAreEqual() {
        BookCopy copy1 = new BookCopy("copy1", book);
        BookCopy copy2 = new BookCopy("copy1", book);
        assertEquals(copy1, copy2);
    }

    @Test 
    void copiesWithSameIdHaveSameHashCode() {
        Set<BookCopy> set = new HashSet<>();
        BookCopy copy = new BookCopy("copy1", book);
        set.add(copy);
        assertTrue(set.contains(copy));
        
        copy.markBorrowed();
        assertTrue(set.contains(copy));
    }
}