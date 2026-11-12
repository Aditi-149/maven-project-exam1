package com.exmaple;


import java.util.HashMap;
import java.util.Map;

public class AddBook {

    private Map<Integer, Book> books = new HashMap<>();

    
    static class Book {
        int bookId;
        String title;
        boolean available;

        Book(int bookId, String title) {
            this.bookId = bookId;
            this.title = title;
            this.available = true;
        }
    }

   
    public void addBook(int bookId, String title) {
        if (books.containsKey(bookId)) {
            throw new IllegalArgumentException("Book ID already exists");
        }

        books.put(bookId, new Book(bookId, title));
    }

   
    public Book searchBook(int bookId) {
        return books.get(bookId);
    }

    
    public boolean issueBook(int bookId) {
        Book book = books.get(bookId);

        if (book == null) {
            return false;
        }

        if (!book.available) {
            return false;
        }

        book.available = false;
        return true;
    }

    
    public boolean returnBook(int bookId) {
        Book book = books.get(bookId);

        if (book == null || book.available) {
            return false;
        }

        book.available = true;
        return true;
    }

    
    public boolean isAvailable(int bookId) {
        Book book = books.get(bookId);
        return book != null && book.available;
    }
}
