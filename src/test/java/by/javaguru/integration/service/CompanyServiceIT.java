package by.javaguru.integration.service;


import by.javagury.spring.config.DatabaseProperties;
import by.javagury.spring.dto.CompanyDto;
import by.javagury.spring.service.CompanyService;
import by.javaguru.annotation.IT;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestConstructor;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


@IT
@RequiredArgsConstructor
public class CompanyServiceIT {
    private static final Integer COMPANY_ID = 1;
    private static final String COMPANY_NAME = "Google";

    private final CompanyService companyService;

    @Test
    void findById() {
        var actualResult = companyService.findById(COMPANY_ID);
        System.out.println(actualResult);

        assertTrue(actualResult.isPresent());

        var expectedResult = CompanyDto.builder()
                .id(COMPANY_ID)
                .name(COMPANY_NAME)
                .locales(Map.of(
                        "en", "Google description",
                        "ru", "Google описание"
                ))
                .build();
        actualResult.ifPresent(actual -> assertEquals(expectedResult, actual));
       }
}
