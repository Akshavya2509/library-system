package com.library.system;

import java.time.LocalDate;

public class Loan {
    private final String loanId;
    private final BookCopy copy;
    private final Member member;
    private final LocalDate loanDate;
    private final LocalDate dueOn;
    private LocalDate returnDate;

    public Loan (String loanId, BookCopy copy, Member member, LocalDate borrowedOn) {
        this.loanId = loanId;
        this.copy = copy;
        this.member = member;
        this.loanDate = borrowedOn;
        this.dueOn = borrowedOn.plusDays(14); // Assuming a 2-week loan period
    }

    public String getLoanId() {
        return loanId;
    }

    public BookCopy getCopy() {
        return copy;
    }

    public Member getMember() {
        return member;
    }

    public LocalDate getLoanDate() {
        return loanDate;
    }

    public LocalDate getDueOn() {
        return dueOn;
    }

    public boolean isReturned() {
        return returnDate != null;
    }

    public void markReturned (LocalDate returnDate) {
        if(isReturned()) {
            throw new IllegalStateException("Loan " + loanId + " has already been returned");
        }
        this.returnDate = returnDate;
    }
}
