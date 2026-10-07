package com.library.system;

public class Book {
    private final String isbn;
    private final String title;
    private final String author;

    public Book(String isbn, String title, String author) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
    }

    @Override 
    public boolean equals(Object o) {
        if(this == o) return true;
        if(!(o instanceof Book other)) return false;

        return isbn.equals(other.getIsbn());
    }

    @Override 
    public int hashCode() {
        return isbn.hashCode();
    }

    @Override 
    public String toString() {
        return "Book{" +
                "isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                '}';
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }
    
    public String getAuthor() {
        return author;
    }
}
