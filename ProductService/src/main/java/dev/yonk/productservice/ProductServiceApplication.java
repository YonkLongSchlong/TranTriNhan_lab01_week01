package dev.yonk.productservice;

import dev.yonk.productservice.models.Product;
import dev.yonk.productservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

// THIS SERVICE IS RUNNING ON PORT 8081
@SpringBootApplication
public class ProductServiceApplication implements CommandLineRunner {

    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceApplication(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(ProductServiceApplication.class, args);
    }

    @Override
    public void run(String... args){
        Product product1 = new Product(
                1L,
                "You can't see me t-shirt",
                200,
                1L
        );
////        Product product2 = new Product(
////                2L,
////                "You can't see me headband",
////                100,
////                1L
////        );
//        List<Product> productList = new ArrayList<>();
//        productList.add(product1);
//        productList.add(product2);
        productRepository.save(product1);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
