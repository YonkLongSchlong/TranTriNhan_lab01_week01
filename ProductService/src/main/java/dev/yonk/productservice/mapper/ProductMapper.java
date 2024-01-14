package dev.yonk.productservice.mapper;

import dev.yonk.productservice.models.Product;
import dev.yonk.productservice.responseObject.ProductDto;

public class ProductMapper {

    public static ProductDto mapToProductResponse(Product product) {
        return ProductDto.builder()
                .id(product.getId())
                .name(product.getName())
                .price(product.getPrice())
                .build();
    }
}
