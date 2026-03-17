package com.smit.jpaPractice;

import com.smit.jpaPractice.entity.Product;
import com.smit.jpaPractice.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
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

}
