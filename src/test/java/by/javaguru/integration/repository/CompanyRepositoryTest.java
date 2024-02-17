package by.javaguru.integration.repository;

import by.javagury.spring.database.entity.Company;
import by.javagury.spring.database.repository.CompanyRepository;
import by.javaguru.annotation.IT;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Map;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.InstanceOfAssertFactories.OPTIONAL;
import static org.junit.jupiter.api.Assertions.*;

@IT
@RequiredArgsConstructor
public class CompanyRepositoryTest {

    private static final Integer APPLE_ID = 5;
    private final EntityManager entityManager;
    private final CompanyRepository companyRepository;

    @Test
    void findById() {
        var company = entityManager.find(Company.class, 1);
        assertNotNull(company);
        assertThat(company.getLocales()).hasSize(2);
    }

    @Test
    void save() {
        var company = Company.builder()
                .name("Apple1")
                .locales(Map.of(
                        "ru", "Apple описание",
                        "en", "Apple description"
                ))
                .build();
        entityManager.persist(company);
        assertNotNull(company.getId());
    }

    @Test
    void updateName() {
        Integer id = 1;
        String newName = "Yandex";
        companyRepository.updateCompanyNameById(newName, id);
        var findResultById = companyRepository.findById(id);
        assertEquals(newName, findResultById.get().getName());
    }

    @Test
    void deleteCompanyByName() {
        companyRepository.deleteCompanyByNameIgnoreCaseLike("a%");
        var expected = companyRepository.findById(3);
        assertTrue(expected.isEmpty());
    }
}
