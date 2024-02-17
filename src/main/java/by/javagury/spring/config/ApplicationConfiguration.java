package by.javagury.spring.config;

import by.javagury.spring.database.repository.CompanyRepository;
import by.javagury.spring.database.repository.UserRepository;
import by.javagury.spring.mapper.CompanyToDto;
import by.javagury.spring.mapper.UserToDto;
import by.javagury.spring.service.CompanyService;
import by.javagury.spring.service.UserService;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ApplicationConfiguration {

    @Bean("companyService1")
    public CompanyService companyService(CompanyRepository companyRepository, CompanyToDto companyToDto,
                                         ApplicationEventPublisher applicationEventPublisher) {
        return new CompanyService(companyRepository, companyToDto, applicationEventPublisher);
    }

    @Bean("userService1")
    public UserService userService(UserToDto userToDto, UserRepository userRepository) {
        return new UserService(userToDto, userRepository);
    }
}
