package com.smit.advancedDataJpa.repository;

import com.smit.advancedDataJpa.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByTitle(String pepsi);

    List<Product> findByCreatedAtAfter(LocalDateTime after);

    List<Product> findByQuantityAndPrice(int i, BigDecimal bigDecimal);

    List<Product> findByQuantityOrPrice(int i, BigDecimal bigDecimal);
}
