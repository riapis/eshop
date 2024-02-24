package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Product;
import org.springframework.stereotype.Repository;
import id.ac.ui.cs.advprog.eshop.repository.ProductFinder;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Repository
public class ProductRepository implements ProductRepoInterface{
    private List<Product> productData = new ArrayList<>();
    private ProductFinder productFinder = new ProductFinder();

    public Product create(Product product){
        if(product.getProductQuantity() < 0){
            product.setProductQuantity(0);
        }
        productData.add(product);
        return product;
    }

    public Product delete(Product product){
        productData.remove(product);
        return product;
    }

    public Product findById(String id){
        return productFinder.findById(id, productData);
    }


    public Product edit(Product updatedProduct){
        if(updatedProduct.getProductQuantity() < 0){
            updatedProduct.setProductQuantity(0);
        }
        for (int i = 0; i < productData.size(); i++) {
            Product product = productData.get(i);
            if(product.getProductId().equals(updatedProduct.getProductId())){
                productData.set(i, updatedProduct);
                return updatedProduct;
            }
        }
        return null;
    }

    public Iterator<Product> findAll(){
        return productFinder.findAll(productData);
    }
}