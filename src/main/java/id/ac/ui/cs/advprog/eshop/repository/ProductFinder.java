package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Product;

import java.util.Iterator;
import java.util.List;

public class ProductFinder {
    public Product findById(String id, List<Product> productData){
        for(Product product : productData){
            if(product.getProductId().equals(id)){
                return product;
            }
        }
        return null;
    }

    public Iterator<Product> findAll(List<Product> productData){
        return productData.iterator();
    }
}