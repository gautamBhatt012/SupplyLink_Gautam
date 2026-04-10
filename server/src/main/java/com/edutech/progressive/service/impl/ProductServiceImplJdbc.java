package com.edutech.progressive.service.impl;

import java.util.List;

import com.edutech.progressive.dao.ProductDAO;
import com.edutech.progressive.entity.Product;

public class ProductServiceImplJdbc  {

    private ProductDAO productDAO;
    
    public ProductServiceImplJdbc(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    public List<Product> getAllProducts(){
        return productDAO.getAllProducts();
    }

    public Product getProductById(int productId){
        return productDAO.getProductById(productId);
    }

    public int addProduct(Product product) {
       return productDAO.addProduct(product);
    }

    public void updateProduct(Product product) {
        productDAO.updateProduct(product);
    }

    public void deleteProduct(int productId) {
        productDAO.deleteProduct(productId);
    }
}