package com.library.jdbc.preparedstatement.serviceI;

import java.util.List;

import com.library.jdbc.preparedstatement.model.Book;


public interface BookServiceI {

    void addBook();

    Book getBookById();

    Book getBookByIsbn();

    List<Book> getAllBooks();

    void updateBook();

    void deleteBookById();

    void deleteBookByIsbn();

    void deleteAllBooks();
}
