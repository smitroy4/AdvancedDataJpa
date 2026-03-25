package com.smit.advancedDataJpa;

import com.smit.advancedDataJpa.entity.Product;
import com.smit.advancedDataJpa.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Pageable;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class ApplicationTests {

    @Autowired
    ProductRepository productRepository;

	@Test
	void contextLoads() {
	}

//    1
    @Test
    void testRepository(){
        Product product = Product.builder()
                .sku("nestle234")
                .title("Nestle Chocolate")
                .price(BigDecimal.valueOf(125.78))
                .quantity(12)
                .build();

        Product savedProduct = productRepository.save(product);
        System.out.println(savedProduct);
    }
//    2
    @Test
    void getRepository(){
        List<Product> productList = productRepository.findAll();
        productList.forEach(product -> System.out.println(product));
    }

//    3
    @Test
    void getRepositoryByTitle(){
        List<Product> productList = productRepository.findByTitle("Pepsi", Pageable.unpaged());
        productList.forEach(System.out::println);
    }

//    4
    @Test
    void getRepositoryByTime(){
        List<Product> productByTime = productRepository.findByCreatedAtAfter(
                LocalDateTime.of(2024, 1, 1, 1, 0, 0)
        );
        productByTime.forEach(System.out::println);
    }

//    5
    @Test
    void getRepositoryByQtyAndPrice(){
        List<Product> productByQtyPrice = productRepository.findByQuantityAndPrice(4,BigDecimal.valueOf(10));
        productByQtyPrice.forEach(System.out::println);
    }

//    6
    @Test
    void getRepositoryByQtyOrPrice(){
        List<Product> productByQtyPrice = productRepository.findByQuantityOrPrice(20,BigDecimal.valueOf(30));
        productByQtyPrice.forEach(System.out::println);
    }

//    7
    @Test
    void getRepositoryQtyAndPriceFilters(){
        List<Product> productFilteredByQtyAndPrice = productRepository.findByQuantityGreaterThanOrPriceLessThan(4,20);
        productFilteredByQtyAndPrice.forEach(System.out::println);
    }

//    8
    @Test
    void getRepositoryByTitleLike(){
        List<Product> productByTitleLike = productRepository.findByTitleLike("%si%");
        productByTitleLike.forEach(System.out::println);
    }

//    9
    @Test
    void getRepositoryByContainingIgnoreCase(){
        List<Product> productByContainingIgnoreCase = productRepository.findByTitleContainingIgnoreCase("Choco", Pageable.unpaged());
        productByContainingIgnoreCase.forEach(System.out::println);
    }

//    10
    @Test
    void getSingleFromRepository(){
        Optional<Product> product = productRepository.findByTitleAndPrice("Lays Chips", BigDecimal.valueOf(15));
        product.ifPresent(System.out::println);

    }

}
