package repository;

import domain.Product;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProductMapper {
//    List<Product> getProducts();

    String getName();

    List<Product> getProducts();

    Product getProduct(int id);

    int insertProduct(Product pd);

    int updateProduct(Product pd);

    int deleteProduct(int id);
}
