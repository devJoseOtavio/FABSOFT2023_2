package FABSOFT20232.FABSOFT2023.model;

import java.math.BigDecimal;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, 
        length = 1000)
    private String name;

    private BigDecimal value;

    //ProductType ProductType;
}
