package com.smit.advancedDataJpa.repository;

import com.smit.advancedDataJpa.entity.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByTitle(String pepsi, Pageable pageable);

    List<Product> findByCreatedAtAfter(LocalDateTime after);

    List<Product> findByQuantityAndPrice(int i, BigDecimal bigDecimal);

    List<Product> findByQuantityOrPrice(int i, BigDecimal bigDecimal);

    List<Product> findByQuantityGreaterThanAndPriceLessThan(int i, int i1);

    List<Product> findByQuantityGreaterThanOrPriceLessThan(int i, int i1);

    List<Product> findByTitleLike(String s);

    List<Product> findByTitleContainingIgnoreCase(String title, Pageable pageable);

//    Optional<Product> findByTitleAndPrice(String laysChips, BigDecimal bigDecimal);

    @Query("select e from Product e where e.title=?1 and e.price=?2")
    Optional<Product> findByTitleAndPrice(String title, BigDecimal price);

    List<Product> findByOrderByPrice();

    List<Product> findBy(Sort sort);
}
