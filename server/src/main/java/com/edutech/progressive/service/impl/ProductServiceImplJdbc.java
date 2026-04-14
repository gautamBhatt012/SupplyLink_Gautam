package com.edutech.progressive.service.impl;

<<<<<<< HEAD
public class ProductServiceImplJdbc  {

=======
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.edutech.progressive.dao.ProductDAO;
import com.edutech.progressive.entity.Product;
import com.edutech.progressive.service.ProductService;

public class ProductServiceImplJdbc implements ProductService 
{
    private ProductDAO productDAO;

    public ProductServiceImplJdbc(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    @Override
    public List<Product> getAllProducts() {
        try {
            return productDAO.getAllProducts();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    @Override
    public Product getProductById(int productId) {
        try {
            return productDAO.getProductById(productId);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int addProduct(Product product)  {
        try {
            return productDAO.addProduct(product);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public void updateProduct(Product product) {
        try {
            productDAO.updateProduct(product);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public void deleteProduct(int productId){
        try {
            productDAO.deleteProduct(productId);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
>>>>>>> 7b8b6b15b44f8033d0cf04f837bd056175fab3f8
}