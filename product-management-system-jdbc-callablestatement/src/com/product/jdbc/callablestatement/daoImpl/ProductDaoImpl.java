package com.product.jdbc.callablestatement.daoImpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.product.jdbc.callablestatement.daoI.ProductDaoI;
import com.product.jdbc.callablestatement.model.Product;
import com.product.jdbc.callablestatement.util.DatabaseConnection;

public class ProductDaoImpl implements ProductDaoI {

	@Override
	public void addProduct(Product product) {
		String query = "{CALL InsertProduct(?, ?, ?, ?, ?, ?)}"; // Stored procedure call

		try (Connection connection = DatabaseConnection.getConnection();
				CallableStatement callableStatement = connection.prepareCall(query)) {

			// Set the parameters for the stored procedure
			callableStatement.setString(1, product.getSku());
			callableStatement.setString(2, product.getName());
			callableStatement.setString(3, product.getDescription());
			callableStatement.setString(4, product.getManufacturer());
			callableStatement.setDouble(5, product.getPrice());
			callableStatement.setInt(6, product.getQuantity());

			// Execute the stored procedure
			callableStatement.execute();

			// Print all product details in one SOP
			System.out.println(String.format(
					"\nProduct Added: [ID: %d, SKU: %s, Name: %s, Description: %s, Manufacturer: %s, Price: %.2f, Quantity: %d]",
					product.getId(), product.getSku(), product.getName(), product.getDescription(),
					product.getManufacturer(), product.getPrice(), product.getQuantity()));

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Product getProductById(int id) {
		String query = "{CALL get_product_by_id(?)}";
		try (Connection connection = DatabaseConnection.getConnection();
				CallableStatement callableStatement = connection.prepareCall(query)) {

			callableStatement.setInt(1, id);

			ResultSet resultSet = callableStatement.executeQuery();
			if (resultSet.next()) {
				Product product = new Product();
				product.setId(resultSet.getInt("id"));
				product.setSku(resultSet.getString("sku"));
				product.setName(resultSet.getString("name"));
				product.setDescription(resultSet.getString("description"));
				product.setManufacturer(resultSet.getString("manufacturer"));
				product.setPrice(resultSet.getDouble("price"));
				product.setQuantity(resultSet.getInt("quantity"));

				// Print all product details in one SOP
				System.out.println(String.format(
						"\nRetrieved Product: [ID: %d, SKU: %s, Name: %s, Description: %s, Manufacturer: %s, Price: %.2f, Quantity: %d]",
						product.getId(), product.getSku(), product.getName(), product.getDescription(),
						product.getManufacturer(), product.getPrice(), product.getQuantity()));

				return product;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Product getProductBySku(String sku) {
		String query = "{CALL get_product_by_sku(?)}";
		try (Connection connection = DatabaseConnection.getConnection();
				CallableStatement callableStatement = connection.prepareCall(query)) {

			callableStatement.setString(1, sku);

			ResultSet resultSet = callableStatement.executeQuery();
			if (resultSet.next()) {
				Product product = new Product();
				product.setId(resultSet.getInt("id"));
				product.setSku(resultSet.getString("sku"));
				product.setName(resultSet.getString("name"));
				product.setDescription(resultSet.getString("description"));
				product.setManufacturer(resultSet.getString("manufacturer"));
				product.setPrice(resultSet.getDouble("price"));
				product.setQuantity(resultSet.getInt("quantity"));

				// Print all product details in one SOP
				System.out.println(String.format(
						"\nRetrieved Product by SKU: [ID: %d, SKU: %s, Name: %s, Description: %s, Manufacturer: %s, Price: %.2f, Quantity: %d]",
						product.getId(), product.getSku(), product.getName(), product.getDescription(),
						product.getManufacturer(), product.getPrice(), product.getQuantity()));

				return product;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Product> getAllProducts() {
		List<Product> products = new ArrayList<>();
		String query = "{CALL get_all_products()}";
		try (Connection connection = DatabaseConnection.getConnection();
				CallableStatement callableStatement = connection.prepareCall(query)) {

			ResultSet resultSet = callableStatement.executeQuery();
			while (resultSet.next()) {
				Product product = new Product();
				product.setId(resultSet.getInt("id"));
				product.setSku(resultSet.getString("sku"));
				product.setName(resultSet.getString("name"));
				product.setDescription(resultSet.getString("description"));
				product.setManufacturer(resultSet.getString("manufacturer"));
				product.setPrice(resultSet.getDouble("price"));
				product.setQuantity(resultSet.getInt("quantity"));
				products.add(product);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return products;
	}

	@Override
	public void updateProduct(Product product) {
		String query = "{CALL update_product(?, ?, ?, ?, ?, ?, ?)}";
		try (Connection connection = DatabaseConnection.getConnection();
				CallableStatement callableStatement = connection.prepareCall(query)) {

			callableStatement.setInt(1, product.getId());
			callableStatement.setString(2, product.getSku());
			callableStatement.setString(3, product.getName());
			callableStatement.setString(4, product.getDescription());
			callableStatement.setString(5, product.getManufacturer());
			callableStatement.setDouble(6, product.getPrice());
			callableStatement.setInt(7, product.getQuantity());

			callableStatement.executeUpdate();

			// Print updated product details in one SOP
			System.out.println(String.format(
					"\nUpdated Product: [ID: %d, SKU: %s, Name: %s, Description: %s, Manufacturer: %s, Price: %.2f, Quantity: %d]",
					product.getId(), product.getSku(), product.getName(), product.getDescription(),
					product.getManufacturer(), product.getPrice(), product.getQuantity()));

			System.out.println("Product updated successfully!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteProductById(int id) {
		String query = "{CALL delete_product_by_id(?)}";
		try (Connection connection = DatabaseConnection.getConnection();
				CallableStatement callableStatement = connection.prepareCall(query)) {

			callableStatement.setInt(1, id);
			callableStatement.execute();

			// Print a confirmation message
			System.out.println(String.format("\nProduct with ID: %d has been deleted successfully!", id));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteProductBySku(String sku) {
		String query = "{CALL delete_product_by_sku(?)}";
		try (Connection connection = DatabaseConnection.getConnection();
				CallableStatement callableStatement = connection.prepareCall(query)) {

			callableStatement.setString(1, sku);
			callableStatement.execute();

			// Print a confirmation message
			System.out.println(String.format("\nProduct with SKU: %s has been deleted successfully!", sku));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteAllProducts() {
		String query = "{CALL delete_all_products()}";
		try (Connection connection = DatabaseConnection.getConnection();
				CallableStatement callableStatement = connection.prepareCall(query)) {

			callableStatement.execute();

			// Print a confirmation message
			System.out.println("\nAll products have been deleted successfully!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
