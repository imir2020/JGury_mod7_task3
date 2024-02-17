package by.javagury.spring.service;

import by.javagury.spring.database.entity.Company;
import by.javagury.spring.database.repository.CompanyRepository;
import by.javagury.spring.dto.CompanyDto;
import by.javagury.spring.listener.AccessType;
import by.javagury.spring.listener.EntityEvent;
import by.javagury.spring.mapper.CompanyToDto;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
@ToString
@Data
public class CompanyService {

    private final CompanyRepository companyRepository;
    private final CompanyToDto companyToDto;
    private final ApplicationEventPublisher applicationEventPublisher;


    public Optional<CompanyDto> findById(Integer id) {
        return companyRepository.findById(id).map(entity ->{
            applicationEventPublisher.publishEvent(new EntityEvent(entity, AccessType.READ));
            return companyToDto.mapFrom(entity);
        });
    }
}