package com.smit.advancedDataJpa;

import com.smit.advancedDataJpa.entity.Product;
import com.smit.advancedDataJpa.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
class ApplicationTests {

    @Autowired
    ProductRepository productRepository;

	@Test
	void contextLoads() {
	}

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

    @Test
    void getRepository(){
        List<Product> productList = productRepository.findAll();
        productList.stream().forEach(product -> System.out.println(product));
    }

    @Test
    void getRepositoryByTitle(){
        List<Product> productList = productRepository.findByTitle("Pepsi");
        productList.stream().forEach(product -> System.out.println(product));
    }

    @Test
    void getRepositoryByTime(){
        List<Product> productByTime = productRepository.findByCreatedAtAfter(
                LocalDateTime.of(2024, 1, 1, 1, 0, 0)
        );
        System.out.println(productByTime);
    }

    @Test
    void getRepositoryByQtyAndPrice(){
        List<Product> productByQtyPrice = productRepository.findByQuantityAndPrice(4,BigDecimal.valueOf(10));
        System.out.println(productByQtyPrice);
    }

    @Test
    void getRepositoryByQtyOrPrice(){
        List<Product> productByQtyPrice = productRepository.findByQuantityOrPrice(20,BigDecimal.valueOf(30));
        System.out.println(productByQtyPrice);
    }


}
