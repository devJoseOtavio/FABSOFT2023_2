package FABSOFT20232.FABSOFT2023.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import FABSOFT20232.FABSOFT2023.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    
}
