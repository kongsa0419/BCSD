package service;

import domain.Product;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ProductService {

//    List<Product> getProducts();

    String getName();

    List<Product> getProducts();

    Product getProduct(int id);

    int insertProduct(Product pd);

    int updateProduct(Product pd);

    int deleteProduct(int id);
}
