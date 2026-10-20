package com.demo;

/**
 * Hello world!
 *
 */

import com.demo.product.config.AppConfig;
import com.demo.product.entity.Product;
import com.demo.product.service.ProductServiceImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class App 
{
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        ProductServiceImpl productService = context.getBean(ProductServiceImpl.class);

        Product p = new Product("Microservice Gateway", 149.99);
        productService.addProduct(p);

        System.out.println("Produit ajouté avec succès ! Total en base : " + productService.getAllProducts().size());

        context.close();
    }
}
