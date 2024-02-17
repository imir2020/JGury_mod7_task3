package by.javagury.spring.mapper;

import by.javagury.spring.database.entity.User;
import by.javagury.spring.dto.UserDto;
import by.javagury.spring.mapper.interfaces.UserToDtoMapper;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Component
@ToString
public class UserToDto {

    public UserDto mapFrom(User user){
        return UserToDtoMapper.INSTANCE.fromUserToDto(user);
    }
}
