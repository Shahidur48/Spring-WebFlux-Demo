package com.presentation.reactivewebflux.utils;

import com.presentation.reactivewebflux.DTO.ProductDTO;
import com.presentation.reactivewebflux.model.Product;
import org.springframework.beans.BeanUtils;

public class AppUtils {
    public static ProductDTO entityToDto(Product product) {
        ProductDTO productDto = new ProductDTO();
        BeanUtils.copyProperties(product, productDto);
        return productDto;
    }

    public static Product dtoToEntity(ProductDTO productDto) {
        Product product = new Product();
        BeanUtils.copyProperties(productDto, product);
        return product;
    }
}
