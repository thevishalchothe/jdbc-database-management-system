package com.library.jdbc.preparedstatement.ui;

import java.util.Scanner;

import com.library.jdbc.preparedstatement.daoImpl.BookDaoImpl;
import com.library.jdbc.preparedstatement.serviceI.BookServiceI;
import com.library.jdbc.preparedstatement.serviceImpl.BookServiceImpl;

public class MainApplication {

	private final BookServiceI bookServiceI;

	// Constructor Injection
	public MainApplication(BookServiceI bookServiceI) {
		this.bookServiceI = bookServiceI; // Dependency injected through constructor
	}

	public static void main(String[] args) {
		// Initialize necessary services and DAOs
		BookServiceI bookServiceI = new BookServiceImpl(new BookDaoImpl());

		System.out.println("Library Book Management System using JDBC CRUD with PreparedStatement");

		while (true) {
			Scanner scanner = new Scanner(System.in);
			System.out.println("\nLibrary Book Management System");
			System.out.println("1. Add Book");
			System.out.println("2. Get Book by ID");
			System.out.println("3. Get Book by ISBN");
			System.out.println("4. Get All Books");
			System.out.println("5. Update Book");
			System.out.println("6. Delete Book by ID");
			System.out.println("7. Delete Book by ISBN");
			System.out.println("8. Delete All Books");
			System.out.println("9. Exit");
			System.out.print("Enter your choice: ");

			int choice = scanner.nextInt();

			switch (choice) {
			case 1:
				bookServiceI.addBook();
				break;

			case 2:
				bookServiceI.getBookById();
				break;

			case 3:
				bookServiceI.getBookByIsbn();
				break;

			case 4:
				bookServiceI.getAllBooks();
				break;

			case 5:
				bookServiceI.updateBook();
				break;

			case 6:
				bookServiceI.deleteBookById();
				break;

			case 7:
				bookServiceI.deleteBookByIsbn();
				break;

			case 8:
				bookServiceI.deleteAllBooks();
				break;

			case 9:
				System.exit(0);

			default:
				System.out.println("Invalid choice! Please try again.");
			}
		}
	}
}
