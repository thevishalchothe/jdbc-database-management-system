package com.product.jdbc.callablestatement.ui;

import java.util.Scanner;

import com.product.jdbc.callablestatement.daoImpl.ProductDaoImpl;
import com.product.jdbc.callablestatement.serviceI.ProductServiceI;
import com.product.jdbc.callablestatement.serviceImpl.ProductServiceImpl;

public class MainApplication {

    private final ProductServiceI productServiceI;

    // Constructor Injection
    public MainApplication(ProductServiceI productServiceI) {
        this.productServiceI = productServiceI; // Dependency injected through constructor
    }

    public static void main(String[] args) {
        // Initialize necessary services and DAOs
        ProductServiceI productServiceI = new ProductServiceImpl(new ProductDaoImpl());

        System.out.println("Product Management System using JDBC CRUD with CallableStatement");

        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("\nProduct Management System");
            System.out.println("1. Add Product");
            System.out.println("2. Get Product by ID");
            System.out.println("3. Get Product by SKU");
            System.out.println("4. Get All Products");
            System.out.println("5. Update Product");
            System.out.println("6. Delete Product by ID");
            System.out.println("7. Delete Product by SKU");
            System.out.println("8. Delete All Products");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    productServiceI.addProduct();
                    break;

                case 2:
                    productServiceI.getProductById();
                    break;

                case 3:
                    productServiceI.getProductBySku();
                    break;

                case 4:
                    productServiceI.getAllProducts();
                    break;

                case 5:
                    productServiceI.updateProduct();
                    break;

                case 6:
                    productServiceI.deleteProductById();
                    break;

                case 7:
                    productServiceI.deleteProductBySku();
                    break;

                case 8:
                    productServiceI.deleteAllProducts();
                    break;

                case 9:
                    System.exit(0);

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
