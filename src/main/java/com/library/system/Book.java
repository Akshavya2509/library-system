package com.library.system;

public record Book (String isbn, String title, String author) {
    @Override
    public boolean equals(Object o) {
        if(this == o) return true;

        return o instanceof Book other && isbn.equals(other.isbn);
    }

    @Override 
    public int hashCode() {
        return isbn.hashCode();
    }
}
