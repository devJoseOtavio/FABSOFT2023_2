package FABSOFT20232.FABSOFT2023.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import FABSOFT20232.FABSOFT2023.model.Product;
import FABSOFT20232.FABSOFT2023.repository.ProductRepository;
import FABSOFT20232.FABSOFT2023.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository repository;
    @Override
    public List<Product> getAll() {
        return repository.findAll();
    }
    @Override
    public void save(Product product) {
        repository.save(product);
    }

    @Override
    public void delete(Product product) {
        repository.delete(product);
    }
}
