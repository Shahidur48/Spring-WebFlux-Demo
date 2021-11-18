package com.presentation.reactivewebflux.service;

import com.presentation.reactivewebflux.DTO.ProductDTO;
import com.presentation.reactivewebflux.repository.ProductRepository;
import com.presentation.reactivewebflux.utils.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Range;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;


    public Flux<ProductDTO> getProducts(){
        return repository.findAll().map(AppUtils::entityToDto);
    }

    public Mono<ProductDTO> getProduct(String id){
        return repository.findById(id).map(AppUtils::entityToDto);
    }


    public Flux<ProductDTO> getProductsDelay() {
        return repository.findAll().map(AppUtils::entityToDto)
                .delayElements(Duration.ofSeconds(1))
                .log();
    }

//    public Flux<ProductDTO> getProductInRange(double min,double max){
//        return repository.findByPriceBetween(Range.closed(min,max));
//    }

    public Mono<ProductDTO> saveProduct(Mono<ProductDTO> productDtoMono){
        System.out.println("service method called ...");
        return  productDtoMono.map(AppUtils::dtoToEntity)
                .flatMap(repository::insert)
                .map(AppUtils::entityToDto);
    }

    public Mono<ProductDTO> updateProduct(Mono<ProductDTO> productDtoMono,String id){
        return repository.findById(id)
                .flatMap(p->productDtoMono.map(AppUtils::dtoToEntity)
                        .doOnNext(e->e.setId(id)))
                .flatMap(repository::save)
                .map(AppUtils::entityToDto);

    }

    public Mono<Void> deleteProduct(String id){
        return repository.deleteById(id);
    }
}
