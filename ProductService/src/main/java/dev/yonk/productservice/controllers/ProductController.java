package dev.yonk.productservice.controllers;

import dev.yonk.productservice.mapper.ProductMapper;
import dev.yonk.productservice.models.Product;
import dev.yonk.productservice.responseObject.ProductDto;
import dev.yonk.productservice.responseObject.ResponseDto;
import dev.yonk.productservice.responseObject.UserDto;
import dev.yonk.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDto> getProductByIds(@PathVariable Long id) {
        ResponseDto responseDto = productService.getProductById(id);
        return new ResponseEntity<>(responseDto, HttpStatus.FOUND);
    }


}
