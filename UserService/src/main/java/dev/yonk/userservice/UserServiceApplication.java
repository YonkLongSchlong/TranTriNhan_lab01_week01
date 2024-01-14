package dev.yonk.userservice;

import dev.yonk.userservice.models.UserEntity;
import dev.yonk.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.Set;

@SpringBootApplication
public class UserServiceApplication implements CommandLineRunner {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceApplication(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(UserServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        UserEntity user = new UserEntity(1L, "John Cena", 1L);
        userRepository.save(user);
        System.out.println(user);
    }

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
