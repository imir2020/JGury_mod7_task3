package by.javagury.spring.mapper;

import by.javagury.spring.database.entity.User;
import by.javagury.spring.dto.UserDto;
import by.javagury.spring.mapper.interfaces.DtoToUserMapper;

public class DtoToUser {

    public User mapFrom(UserDto userDto){
        return DtoToUserMapper.INSTANCE.fromDtoToUser(userDto);
    }
}
