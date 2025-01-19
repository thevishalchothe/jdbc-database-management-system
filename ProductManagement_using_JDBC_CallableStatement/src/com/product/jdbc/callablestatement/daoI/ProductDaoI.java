package com.product.jdbc.callablestatement.daoI;

import java.util.List;

import com.product.jdbc.callablestatement.model.Product;

public interface ProductDaoI {

    void addProduct(Product product);

    Product getProductById(int id);

    Product getProductBySku(String sku);

    List<Product> getAllProducts();

    void updateProduct(Product product);

    void deleteProductById(int id);

    void deleteProductBySku(String sku);

    void deleteAllProducts();
}
