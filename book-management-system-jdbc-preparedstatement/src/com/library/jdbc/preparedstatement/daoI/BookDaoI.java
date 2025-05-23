package com.library.jdbc.preparedstatement.daoI;

import java.util.List;

import com.library.jdbc.preparedstatement.model.Book;


public interface BookDaoI {

    void addBook(Book book);

    Book getBookById(int id);

    Book getBookByIsbn(String isbn);

    List<Book> getAllBooks();

    void updateBook(Book book);

    void deleteBookById(int id);

    void deleteBookByIsbn(String isbn);

    void deleteAllBooks();
}
