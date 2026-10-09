package com.library.system;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LoanTest {

    private Loan loan;

    @BeforeEach
    void setUp() {
        Book book = new Book("WS001", "Macbeth", "William Shakespeare");
        BookCopy copy = new BookCopy("WSC001", book);
        Member member = new Member("JD001", "John Doe");
        loan = new Loan("JDL001", copy, member, LocalDate.of(2024, 6, 1));
    }

    @Test
    void dueDateIsFourteenDaysAfterBorrowing() {
        assertEquals(LocalDate.of(2024, 6, 15), loan.getDueOn());
    }

    @Test
    void newLoanIsNotReturned() {
        assertFalse(loan.isReturned());
    }

    @Test
    void loanIsMarkedAsReturned() {
        loan.markReturned(LocalDate.of(2024, 6, 15));
        assertTrue(loan.isReturned());
    }

    @Test
    void returnedLoanTwice() {
        loan.markReturned(LocalDate.of(2024, 6, 15));
        assertTrue(loan.isReturned());

        assertThrows(
                IllegalStateException.class,
                () -> loan.markReturned(LocalDate.of(2024, 6, 16)));
    }
}
