package com.library.jdbc.preparedstatement.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.library.jdbc.preparedstatement.daoI.BookDaoI;
import com.library.jdbc.preparedstatement.model.Book;
import com.library.jdbc.preparedstatement.util.DatabaseConnection;

public class BookDaoImpl implements BookDaoI {

	@Override
	public void addBook(Book book) {
		String query = "INSERT INTO books (isbn, title, author, publisher, quantity) VALUES (?, ?, ?, ?, ?)";
		try (Connection connection = DatabaseConnection.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			preparedStatement.setString(1, book.getIsbn());
			preparedStatement.setString(2, book.getTitle());
			preparedStatement.setString(3, book.getAuthor());
			preparedStatement.setString(4, book.getPublisher());
			preparedStatement.setInt(5, book.getQuantity());
			preparedStatement.executeUpdate();
			System.out.println(String.format(
					"\nBook added successfully! \nISBN: %s\nTitle: %s\nAuthor: %s\nPublisher: %s\nQuantity: %d",
					book.getIsbn(), book.getTitle(), book.getAuthor(), book.getPublisher(), book.getQuantity()));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Book getBookById(int id) {
		String query = "SELECT * FROM books WHERE id = ?";
		try (Connection connection = DatabaseConnection.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				Book book = new Book();
				book.setId(resultSet.getInt("id"));
				book.setIsbn(resultSet.getString("isbn"));
				book.setTitle(resultSet.getString("title"));
				book.setAuthor(resultSet.getString("author"));
				book.setPublisher(resultSet.getString("publisher"));
				return book;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Book getBookByIsbn(String isbn) {
		String query = "SELECT * FROM books WHERE isbn = ?";
		try (Connection connection = DatabaseConnection.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			preparedStatement.setString(1, isbn);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				Book book = new Book();
				book.setId(resultSet.getInt("id"));
				book.setIsbn(resultSet.getString("isbn"));
				book.setTitle(resultSet.getString("title"));
				book.setAuthor(resultSet.getString("author"));
				book.setPublisher(resultSet.getString("publisher"));
				return book;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Book> getAllBooks() {
		List<Book> books = new ArrayList<>();
		String query = "SELECT * FROM books";
		try (Connection connection = DatabaseConnection.getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(query)) {

			while (resultSet.next()) {
				Book book = new Book();
				book.setId(resultSet.getInt("id"));
				book.setIsbn(resultSet.getString("isbn"));
				book.setTitle(resultSet.getString("title"));
				book.setAuthor(resultSet.getString("author"));
				book.setPublisher(resultSet.getString("publisher"));
				book.setQuantity(resultSet.getInt("quantity"));
				books.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return books;
	}

	@Override
	public void updateBook(Book book) {
		String query = "UPDATE books SET isbn = ?, title = ?, author = ?, publisher = ?, quantity = ? WHERE id = ?";

		try (Connection connection = DatabaseConnection.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query)) {

			// Set the parameters for the prepared statement
			preparedStatement.setString(1, book.getIsbn());
			preparedStatement.setString(2, book.getTitle());
			preparedStatement.setString(3, book.getAuthor());
			preparedStatement.setString(4, book.getPublisher());
			preparedStatement.setInt(5, book.getQuantity());
			preparedStatement.setInt(6, book.getId()); // Set the book ID to locate the record to be updated

			// Execute the update
			int rowsAffected = preparedStatement.executeUpdate();

			if (rowsAffected > 0) {
				// Success message
				System.out.println(String.format(
						"\nBook updated successfully! \nID: %d\nISBN: %s\nNew Title: %s\nNew Author: %s\nNew Publisher: %s\nNew Quantity: %d",
						book.getId(), book.getIsbn(), book.getTitle(), book.getAuthor(), book.getPublisher(),
						book.getQuantity()));
			} else {
				System.out.println("No book found with ID: " + book.getId());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteBookById(int id) {
		String query = "DELETE FROM books WHERE id = ?";
		try (Connection connection = DatabaseConnection.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
			System.out.println("Book deleted successfully!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteBookByIsbn(String isbn) {
		String query = "DELETE FROM books WHERE isbn = ?";
		try (Connection connection = DatabaseConnection.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			preparedStatement.setString(1, isbn);
			preparedStatement.executeUpdate();
			System.out.println("Book deleted successfully!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteAllBooks() {
		String query = "DELETE FROM books";
		try (Connection connection = DatabaseConnection.getConnection();
				Statement statement = connection.createStatement()) {
			statement.executeUpdate(query);
			System.out.println("All books deleted successfully!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
