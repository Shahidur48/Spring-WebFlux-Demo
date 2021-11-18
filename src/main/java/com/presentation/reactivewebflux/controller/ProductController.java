package com.presentation.reactivewebflux.controller;

import com.presentation.reactivewebflux.DTO.ProductDTO;
import com.presentation.reactivewebflux.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
    @RequestMapping("/products")
    public class ProductController {

        @Autowired
        private ProductService service;

        @GetMapping
        public Flux<ProductDTO> getProducts() {
            return service.getProducts();
        }

        @GetMapping(value = "delay", produces= MediaType.APPLICATION_STREAM_JSON_VALUE)
        public Flux<ProductDTO> getProductsDelay() {
            return service.getProductsDelay();
        }

        @GetMapping("/{id}")
        public Mono<ProductDTO> getProduct(@PathVariable String id) {
            return service.getProduct(id);
        }
//
//        @GetMapping("/product-range")
//        public Flux<ProductDto> getProductBetweenRange(@RequestParam("min") double min, @RequestParam("max") double max) {
//            return service.getProductInRange(min, max);
//        }

        @PostMapping
        public Mono<ProductDTO> saveProduct(@RequestBody Mono<ProductDTO> productDtoMono) {
            System.out.println("controller method called ...");
            return service.saveProduct(productDtoMono);
        }

        @PutMapping("/update/{id}")
        public Mono<ProductDTO> updateProduct(@RequestBody Mono<ProductDTO> productDtoMono, @PathVariable String id) {
            return service.updateProduct(productDtoMono, id);
        }



        @DeleteMapping("/delete/{id}")
        public Mono<Void> deleteProduct(@PathVariable String id) {
            return service.deleteProduct(id);
        }
    }

