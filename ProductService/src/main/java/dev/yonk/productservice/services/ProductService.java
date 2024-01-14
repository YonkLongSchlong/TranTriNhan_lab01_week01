package dev.yonk.productservice.services;

import dev.yonk.productservice.exceptions.ProductNotFoundException;
import dev.yonk.productservice.mapper.ProductMapper;
import dev.yonk.productservice.models.Product;
import dev.yonk.productservice.repository.ProductRepository;
import dev.yonk.productservice.responseObject.ProductDto;
import dev.yonk.productservice.responseObject.ResponseDto;
import dev.yonk.productservice.responseObject.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final RestTemplate restTemplate;

    @Autowired
    public ProductService(ProductRepository productRepository, RestTemplate restTemplate) {
        this.productRepository = productRepository;
        this.restTemplate = restTemplate;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public ResponseDto getProductById(Long id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException("Product not found"));
        ProductDto productDto = ProductMapper.mapToProductResponse(product);
        UserDto userDto = (restTemplate.getForObject("http://localhost:8080/users/1",UserDto.class));
        return new ResponseDto(productDto, userDto);
    }
}
