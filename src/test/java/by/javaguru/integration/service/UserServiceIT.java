package by.javaguru.integration.service;

import by.javagury.spring.database.entity.Company;
import by.javagury.spring.database.entity.Role;
import by.javagury.spring.database.entity.User;
import by.javagury.spring.database.repository.UserRepository;
import by.javagury.spring.dto.CompanyDto;
import by.javagury.spring.dto.UserDto;
import by.javagury.spring.mapper.UserToDto;
import by.javagury.spring.service.UserService;
import by.javaguru.annotation.IT;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.TestConstructor;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@IT
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
@RequiredArgsConstructor
public class UserServiceIT {
    private static final Long USER_ID = 1L;
    private static final Integer COMPANY_ID = 1;
    private static final String COMPANY_NAME = "ivan555@gmail.com";

    private final UserService userService;


    @Test
    void test() {
        var user = User.builder()
                .username(COMPANY_NAME)
                .birthDate(LocalDate.parse("2003-03-30"))
                .firstname("Oleg")
                .role(Role.ADMIN)
                .build();
        userService.save(user);

        var actualResult = userService.findByUserName(COMPANY_NAME);
        System.out.println(actualResult + " is actual");

        assertTrue(actualResult.isPresent());

        var expectedResult = UserDto.builder()
                .username(COMPANY_NAME)
                .birthDate(LocalDate.parse("2003-03-30"))
                .firstname("Oleg")
                .role(String.valueOf(Role.ADMIN))
                        .build();
        actualResult.ifPresent(actual -> assertEquals(expectedResult.getUsername(), actual.getUsername()));

    }
}