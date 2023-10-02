package FABSOFT20232.FABSOFT2023.service;

import java.util.List;
import FABSOFT20232.FABSOFT2023.model.Product;

public interface ProductService {
    List<Product> getAll();

    void save(Product product);

    void delete(Product product);
}
