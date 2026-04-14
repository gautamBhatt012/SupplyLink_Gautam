package com.edutech.progressive.dao;

import com.edutech.progressive.entity.Product;

<<<<<<< HEAD
import java.util.List;

public interface ProductDAO {
    int addProduct(Product product);
    Product getProductById(int productId);
    void updateProduct(Product product);
    void deleteProduct(int productId);
    List<Product> getAllProducts();
=======
import java.sql.SQLException;
import java.util.List;

public interface ProductDAO {
    int addProduct(Product product) throws SQLException;
    Product getProductById(int productId) throws SQLException;
    void updateProduct(Product product) throws SQLException;
    void deleteProduct(int productId) throws SQLException;
    List<Product> getAllProducts() throws SQLException;
>>>>>>> 7b8b6b15b44f8033d0cf04f837bd056175fab3f8
}