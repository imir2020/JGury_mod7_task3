package by.javagury.spring.database.repository;


import by.javagury.spring.database.entity.Role;
import by.javagury.spring.database.entity.User;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;


import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findById(Long id);

    Optional<User> findByUsername(String username);

    User save(User user);

    List<User> findAllByRoleAndBirthDateBetween(Role role, LocalDate after, LocalDate before);

    List<User> findTop4By(Sort sort);

    List<User> findAllByRole(Role role, PageRequest pageRequest);
}
