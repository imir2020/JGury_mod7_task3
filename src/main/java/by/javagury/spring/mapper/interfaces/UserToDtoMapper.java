package by.javagury.spring.mapper.interfaces;

import by.javagury.spring.database.entity.User;
import by.javagury.spring.dto.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserToDtoMapper {
    UserToDtoMapper INSTANCE = Mappers.getMapper(UserToDtoMapper.class);

    UserDto fromUserToDto(User user);
}
