package dev.yonk.userservice.mapper;

import dev.yonk.userservice.ResponseObject.UserDto;
import dev.yonk.userservice.models.UserEntity;

public class UserMapper {

    public static UserDto mapToUserDto(UserEntity user){
        return UserDto.builder()
                .id(user.getId())
                .name(user.getName())
                .build();
    }
}
