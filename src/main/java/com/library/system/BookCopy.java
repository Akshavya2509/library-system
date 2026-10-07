package com.library.system;

public class BookCopy {
    private final String copyId;
    private final Book book;
    private CopyStatus status;

    public BookCopy(String copyId, Book book) {
        this.copyId = copyId;
        this.book = book;

        this.status = CopyStatus.AVAILABLE;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;

        return o instanceof BookCopy other && copyId.equals(other.getCopyId());
    }

    @Override
    public int hashCode() {
        return copyId.hashCode();
    }

    @Override
    public String toString() {
        return "BookCopy{" +
                "copyId='" + copyId + '\'' +
                ", book=" + book +
                ", status=" + status +
                '}';
    }
    
    public String getCopyId() {
        return copyId;
    }

    public Book getBook() {
        return book;
    }

    public CopyStatus getStatus() {
        return status;
    }

    public void markBorrowed() {
        this.status = CopyStatus.BORROWED;
    }

    public void markAvailable() {
        this.status = CopyStatus.AVAILABLE;
    }
}
