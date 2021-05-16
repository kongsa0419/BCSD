package serviceImpl;

import domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.ProductMapper;
import service.ProductService;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper mProductMapper;

    @Override
    public String getName() {
        return mProductMapper.getName();
    }

    @Override
    public List<Product> getProducts() {
        return mProductMapper.getProducts();
    }

    @Override
    public Product getProduct(int id) {
        return mProductMapper.getProduct(id);
    }

    @Override
    public int insertProduct(Product pd) {
        return mProductMapper.insertProduct(pd);
    }

    @Override
    public int updateProduct(Product pd) {
        return mProductMapper.updateProduct(pd);
    }

    @Override
    public int deleteProduct(int id) {
        return mProductMapper.deleteProduct(id);
    }
}
