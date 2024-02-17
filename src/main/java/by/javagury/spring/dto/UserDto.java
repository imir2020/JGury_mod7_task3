package by.javagury.spring.dto;

import by.javagury.spring.database.entity.Company;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Value;
import org.springframework.stereotype.Component;

import java.time.LocalDate;


@Value
@Builder
public class UserDto {
    Long id;
    String username;
    LocalDate birthDate;
    String firstname;
    String lastname;
    String role;
    Integer companyId;
}
