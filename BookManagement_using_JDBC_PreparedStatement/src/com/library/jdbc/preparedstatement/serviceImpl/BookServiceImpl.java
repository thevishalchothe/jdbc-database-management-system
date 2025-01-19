package com.library.jdbc.preparedstatement.serviceImpl;

import java.util.List;
import java.util.Scanner;

import com.library.jdbc.preparedstatement.daoI.BookDaoI;
import com.library.jdbc.preparedstatement.model.Book;
import com.library.jdbc.preparedstatement.serviceI.BookServiceI;

public class BookServiceImpl implements BookServiceI {

	private final BookDaoI bookDaoI;

	// Constructor injection (Preferred approach for loose coupling)
	public BookServiceImpl(BookDaoI bookDaoI) {
		this.bookDaoI = bookDaoI;
	}

	Scanner scanner = new Scanner(System.in);

	@Override
	public void addBook() {
		System.out.print("Enter book ISBN: ");
		String isbn = scanner.next();
		System.out.print("Enter book title: ");
		String title = scanner.next();
		System.out.print("Enter author: ");
		String author = scanner.next();
		System.out.print("Enter publisher: ");
		String publisher = scanner.next();
		System.out.print("Enter quantity: ");
		int quantity = scanner.nextInt();

		Book book = new Book();
		book.setIsbn(isbn);
		book.setTitle(title);
		book.setAuthor(author);
		book.setPublisher(publisher);
		book.setQuantity(quantity);

		bookDaoI.addBook(book);
	}

	@Override
	public Book getBookById() {
		System.out.print("Enter book ID: ");
		int id = scanner.nextInt();
		return bookDaoI.getBookById(id);
	}

	@Override
	public Book getBookByIsbn() {
		System.out.print("Enter book ISBN: ");
		String isbn = scanner.next();
		return bookDaoI.getBookByIsbn(isbn);
	}

	@Override
	public List<Book> getAllBooks() {
		// Fetch all books from the DAO
		List<Book> books = bookDaoI.getAllBooks();

		// Print all books for debugging
		if (books.isEmpty()) {
			System.out.println("No books found.");
		} else {
			System.out.println("All Books Details are as below: ");
			for (Book book : books) {
				System.out.println(String.format(
					    "Book ID: %d | ISBN: %s | Title: %s | Author: %s | Publisher: %s | Quantity: %d",
					    book.getId(),
					    book.getIsbn(),
					    book.getTitle(),
					    book.getAuthor(),
					    book.getPublisher(),
					    book.getQuantity()
					));
			}
		}

		return books;
	}

	@Override
	public void updateBook() {
		// Take user input for updating the book
		System.out.print("Enter book ID to update: ");
		int updateId = scanner.nextInt();
		System.out.print("Enter new ISBN: ");
		String newIsbn = scanner.next();
		System.out.print("Enter new title: ");
		String newTitle = scanner.next();
		System.out.print("Enter new author: ");
		String newAuthor = scanner.next();
		System.out.print("Enter new publisher: ");
		String newPublisher = scanner.next();
		System.out.print("Enter new quantity: ");
		int newQuantity = scanner.nextInt();

		// Create a new Book object with the updated information
		Book updateBook = new Book();
		updateBook.setId(updateId);
		updateBook.setIsbn(newIsbn);
		updateBook.setTitle(newTitle);
		updateBook.setAuthor(newAuthor);
		updateBook.setPublisher(newPublisher);
		updateBook.setQuantity(newQuantity);

		// Call the DAO method to update the book in the database
		bookDaoI.updateBook(updateBook);
	}

	@Override
	public void deleteBookById() {
		System.out.print("Enter book ID to delete: ");
		int deleteId = scanner.nextInt();
		bookDaoI.deleteBookById(deleteId);
	}

	@Override
	public void deleteBookByIsbn() {
		System.out.print("Enter book ISBN to delete: ");
		String deleteIsbn = scanner.next();
		bookDaoI.deleteBookByIsbn(deleteIsbn);
	}

	@Override
	public void deleteAllBooks() {
		bookDaoI.deleteAllBooks();
	}
}
