package by.javaguru.integration.repository;

import by.javagury.spring.database.entity.Role;
import by.javagury.spring.database.entity.User;
import by.javagury.spring.database.repository.UserRepository;
import by.javaguru.annotation.IT;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@IT
@RequiredArgsConstructor
public class UserRepositoryTest {
    private static final Long USER_ID = 2L;
    private final UserRepository userRepository;

    @Test
    public void findById() {
        var user = userRepository.findById(USER_ID);
        assertNotNull(user);
    }

    @Test
    void findAllAdmin() {
        var usersList = userRepository.findAllByRoleAndBirthDateBetween(Role.ADMIN, LocalDate.parse("1980-01-01"),
                LocalDate.parse("1990-01-01"));
        assertTrue(usersList.size() > 0);
        assertThat(usersList).hasSize(1);
        System.out.println(usersList);
    }

    @Test
    void findUsers4ByWithSortByBirthdate() {
        var sortBy = Sort.sort(User.class);
        var sort = sortBy.by(User::getBirthDate).descending();

        var usersList = userRepository.findTop4By(sort);
        assertTrue(usersList.size() > 0);
        assertThat(usersList).hasSize(4);
        usersList.forEach(System.out::println);
    }

    @Test
    void findUsers4ByWithSortByBirthDateAndFirstNameAndLastName() {
        var sortBy = Sort.sort(User.class);
        var sort = sortBy.by(User::getBirthDate)
                .and(sortBy.by(User::getFirstname))
                .and(sortBy.by(User::getLastname))
                .descending();

        var usersList = userRepository.findTop4By(sort);
        assertTrue(usersList.size() > 0);
        assertThat(usersList).hasSize(4);
        usersList.forEach(System.out::println);
    }

    /**
      Три тестовых метода одного и того же метода findAllByRole(Role.ADMIN, pageable);
     */
    @Test
    public void checkRoleAmount() {
        var pageable = PageRequest.of(0, 2);

        var resultList = userRepository.findAllByRole(Role.ADMIN, pageable);
        assertTrue(resultList.size() > 0);
        assertThat(resultList).hasSize(1);
        resultList.forEach(System.out::println);
    }

    @Test
    public void checkRoleAmountAndSortByBirthdayDesc() {
        int actualSizeOfPage = 2;
        int expectedSizeOfResultList = 2;

        var sortBy = Sort.sort(User.class);
        var sort = sortBy.by(User::getBirthDate).descending();
        var pageable = PageRequest.of(0, actualSizeOfPage, sort);

        var resultList = userRepository.findAllByRole(Role.ADMIN, pageable);
        assertTrue(resultList.size() > 0);
        assertThat(resultList).hasSize(expectedSizeOfResultList);
        resultList.forEach(System.out::println);
    }

    @Test
    public void checkRoleAmountAndSortByBirthdayAndFirstNameAndLastNameDesc() {
        int actualSizeOfPage = 2;
        int expectedSizeOfResultList = 2;

        var sortBy = Sort.sort(User.class);
        var sort = sortBy.by(User::getBirthDate)
                .and(sortBy.by(User::getFirstname))
                .and(sortBy.by(User::getLastname))
                .descending();
        var pageable = PageRequest.of(0, actualSizeOfPage, sort);

        var resultList = userRepository.findAllByRole(Role.USER, pageable);
        assertTrue(resultList.size() > 0);
        assertThat(resultList).hasSize(expectedSizeOfResultList);
        resultList.forEach(System.out::println);
    }
}