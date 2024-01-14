package dev.yonk.userservice.services;

import dev.yonk.userservice.ResponseObject.ProductDto;
import dev.yonk.userservice.ResponseObject.ResponseDto;
import dev.yonk.userservice.ResponseObject.UserDto;
import dev.yonk.userservice.exceptions.UserNotFoundException;
import dev.yonk.userservice.mapper.UserMapper;
import dev.yonk.userservice.models.UserEntity;
import dev.yonk.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;
import java.util.Set;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final RestTemplate restTemplate;

    @Autowired
    public UserService(UserRepository userRepository, RestTemplate restTemplate) {
        this.userRepository = userRepository;
        this.restTemplate = restTemplate;
    }

    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    public UserEntity getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found"));
//        UserDto userDto = UserMapper.mapToUserDto(user);
//        return new ResponseDto(userDto,productDto);
    }
}
