package com.smit.advancedDataJpa;

import com.smit.advancedDataJpa.dto.ProductsInfo;
import com.smit.advancedDataJpa.entity.Product;
import com.smit.advancedDataJpa.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ProductsProjectionTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void testProducts(){
//        List<Product> productList = productRepository.findAll();
        List<ProductsInfo> productList = productRepository.getAllProductsInfo();
        for(ProductsInfo p : productList){
            System.out.println(p);
        }
    }

}
