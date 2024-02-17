package by.javaguru.unit;

import by.javagury.spring.database.entity.Company;
import by.javagury.spring.database.repository.CompanyRepository;
import by.javagury.spring.listener.EntityEvent;
import by.javagury.spring.mapper.CompanyToDto;
import by.javagury.spring.service.CompanyService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.context.ApplicationEventPublisher;

import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;


@ExtendWith(MockitoExtension.class)
class CompanyServiceTest {
    private static final Integer COMPANY_ID = 1;
    private static final String COMPANY_NAME = "Google";

    @Mock
    private CompanyRepository companyRepository;
    @Mock
    private ApplicationEventPublisher eventPublisher;
    @Mock
    private CompanyToDto companyToDto;
    @InjectMocks
    private CompanyService companyService;

    @Test
    void findById() {
        Mockito.doReturn(Optional.of(Company.builder()
                        .id(COMPANY_ID)
                        .name(COMPANY_NAME)
                        .locales(Map.of(
                                "en", "Google description",
                                "ru", "Google описание"
                        ))
                        .build()))
                .when(companyRepository).findById(COMPANY_ID);

        /*
        Здесь метод возвращает пустое значение
         */
        var actualResult = companyService.findById(COMPANY_ID);
        System.out.println(actualResult + " It is actual");
        assertTrue(actualResult.isPresent());


        var expectedResult = Optional.ofNullable(Company.builder()
                .id(COMPANY_ID)
                .name(COMPANY_NAME)
                .locales(Map.of(
                        "en", "Google description",
                        "ru", "Google описание"
                ))
                .build());

        System.out.println(expectedResult + " expectedResult");
        actualResult.ifPresent(actual -> assertEquals(expectedResult.get(), actual));
        verify(companyService).findById(COMPANY_ID);
        verify(eventPublisher).publishEvent(any(EntityEvent.class));
    }
}