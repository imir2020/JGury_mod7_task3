package by.javagury.spring.service;


import by.javagury.spring.database.entity.User;
import by.javagury.spring.database.repository.UserRepository;
import by.javagury.spring.dto.UserDto;
import by.javagury.spring.mapper.UserToDto;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@ToString
public class UserService {
    private final UserToDto userToDto;
    private final UserRepository userRepository;

    public Optional<UserDto> findById(Long id){
        return userRepository.findById(id).map(userToDto::mapFrom);
    }

    public void save(User user) {
        userRepository.save(user);
    }

    public Optional<UserDto> findByUserName(String username) {
        return userRepository.findByUsername(username).map(userToDto::mapFrom);
    }
}
