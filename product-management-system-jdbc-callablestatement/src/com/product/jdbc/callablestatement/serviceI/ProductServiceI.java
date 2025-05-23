package com.product.jdbc.callablestatement.serviceI;

import java.util.List;

import com.product.jdbc.callablestatement.model.Product;

public interface ProductServiceI {

    void addProduct();

    Product getProductById();

    Product getProductBySku();

    List<Product> getAllProducts();

    void updateProduct();

    void deleteProductById();

    void deleteProductBySku();

    void deleteAllProducts();
}
