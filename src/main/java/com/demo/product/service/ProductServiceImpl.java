package com.demo.product.service;


import com.demo.product.dao.IDao;
import com.demo.product.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class ProductServiceImpl {

    @Autowired
    private IDao<Product> productDao;

    @Transactional
    public void addProduct(Product product) {
        if (product.getPrice() < 0) {
            throw new IllegalArgumentException("Le prix ne peut pas être négatif");
        }
        productDao.save(product);
    }

    @Transactional(readOnly = true)
    public List<Product> getAllProducts() {
        return productDao.findAll();
    }
}