package com.smit.advancedDataJpa.controller;

import com.smit.advancedDataJpa.entity.Product;
import com.smit.advancedDataJpa.repository.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/products")
public class ProductController {

    private ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    private final int PAGE_SIZE = 5;

//    @GetMapping
//    public List<Product> getAllProducts(@RequestParam (defaultValue = "id") String sortBy){
//        return productRepository.findBy(Sort.by(sortBy, "price", "quantity"));
//    }

    @GetMapping
    public List<Product> getAllProducts(
            @RequestParam(defaultValue = "") String title,
            @RequestParam (defaultValue = "id") String sortBy,
            @RequestParam (defaultValue = "0") Integer pageNumber){

        return productRepository.findByTitleContainingIgnoreCase(
            title,
            PageRequest.of(pageNumber, PAGE_SIZE, Sort.by(sortBy))

        );


//        return productRepository.findBy(Sort.by(Sort.Direction.DESC, sortBy, "price", "quantity"));
//        return productRepository.findBy(Sort.by(
//                Sort.Order.desc(sortBy),
//                Sort.Order.asc("price"),
//                Sort.Order.asc("quantity"),
//                Sort.Order.asc("title")
//        ));
    }

//    @GetMapping
//    public List<Product> getAllProducts(
//            @RequestParam (defaultValue = "id") String sortBy,
//            @RequestParam (defaultValue = "0 ") Integer pageNumber){
//        Pageable pageable = PageRequest.of(
//                pageNumber,
//                PAGE_SIZE,
//                Sort.by(sortBy)
//                );
//        return productRepository.findAll(pageable).getContent();
//    }

    @GetMapping(path = "/{id}")
    public Optional<Product> getProductsById(@PathVariable("id") Long id){
        return productRepository.findById(id);
    }



}
