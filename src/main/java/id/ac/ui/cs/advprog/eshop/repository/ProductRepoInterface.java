package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Product;

import java.util.Iterator;

public interface ProductRepoInterface {
    Product create(Product product);

    Product delete(Product product);

    Product edit(Product updatedProduct);

    Product findById(String id);

    Iterator<Product> findAll();
}