package com.product.jdbc.callablestatement.serviceImpl;

import java.util.List;
import java.util.Scanner;

import com.product.jdbc.callablestatement.daoI.ProductDaoI;
import com.product.jdbc.callablestatement.model.Product;
import com.product.jdbc.callablestatement.serviceI.ProductServiceI;

public class ProductServiceImpl implements ProductServiceI {

    private final ProductDaoI productDaoI;

    // Constructor injection (Preferred approach for loose coupling)
    public ProductServiceImpl(ProductDaoI productDaoI) {
        this.productDaoI = productDaoI;
    }

    Scanner scanner = new Scanner(System.in);

    @Override
    public void addProduct() {
        System.out.print("Enter product SKU: ");
        String sku = scanner.next();
        System.out.print("Enter product name: ");
        String name = scanner.next();
        System.out.print("Enter product description: ");
        scanner.nextLine(); // Consume leftover newline
        String description = scanner.nextLine();
        System.out.print("Enter manufacturer: ");
        String manufacturer = scanner.next();
        System.out.print("Enter price: ");
        double price = scanner.nextDouble();
        System.out.print("Enter stock quantity: ");
        int quantity = scanner.nextInt();

        Product product = new Product();
        product.setSku(sku);
        product.setName(name);
        product.setDescription(description);
        product.setManufacturer(manufacturer);
        product.setPrice(price);
        product.setQuantity(quantity);

        productDaoI.addProduct(product);
    }

    @Override
    public Product getProductById() {
        System.out.print("Enter product ID: ");
        int id = scanner.nextInt();
        return productDaoI.getProductById(id);
    }

    @Override
    public Product getProductBySku() {
        System.out.print("Enter product SKU: ");
        String sku = scanner.next();
        return productDaoI.getProductBySku(sku);
    }

    @Override
    public List<Product> getAllProducts() {
        List<Product> products = productDaoI.getAllProducts();

        // Print all products for debugging
        if (products.isEmpty()) {
            System.out.println("\\nRetrieved but No products found.");
        } else {
            System.out.println("\\nRetrieved & All Products Details are as below: ");
            for (Product product : products) {
                System.out.println(String.format(
                        "Product ID: %d | SKU: %s | Name: %s | Description: %s | Manufacturer: %s | Price: %.2f | Quantity: %d",
                        product.getId(),
                        product.getSku(),
                        product.getName(),
                        product.getDescription(),
                        product.getManufacturer(),
                        product.getPrice(),
                        product.getQuantity()
                ));
            }
        }

        return products;
    }

    @Override
    public void updateProduct() {
        System.out.print("Enter product ID to update: ");
        int updateId = scanner.nextInt();
        System.out.print("Enter new SKU: ");
        String newSku = scanner.next();
        System.out.print("Enter new name: ");
        String newName = scanner.next();
        System.out.print("Enter new description: ");
        scanner.nextLine(); // Consume leftover newline
        String newDescription = scanner.nextLine();
        System.out.print("Enter new manufacturer: ");
        String newManufacturer = scanner.next();
        System.out.print("Enter new price: ");
        double newPrice = scanner.nextDouble();
        System.out.print("Enter new stock quantity: ");
        int newQuantity = scanner.nextInt();

        Product updateProduct = new Product();
        updateProduct.setId(updateId);
        updateProduct.setSku(newSku);
        updateProduct.setName(newName);
        updateProduct.setDescription(newDescription);
        updateProduct.setManufacturer(newManufacturer);
        updateProduct.setPrice(newPrice);
        updateProduct.setQuantity(newQuantity);

        productDaoI.updateProduct(updateProduct);
    }

    @Override
    public void deleteProductById() {
        System.out.print("Enter product ID to delete: ");
        int deleteId = scanner.nextInt();
        productDaoI.deleteProductById(deleteId);
    }

    @Override
    public void deleteProductBySku() {
        System.out.print("Enter product SKU to delete: ");
        String deleteSku = scanner.next();
        productDaoI.deleteProductBySku(deleteSku);
    }

    @Override
    public void deleteAllProducts() {
        productDaoI.deleteAllProducts();
    }
}
