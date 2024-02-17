package by.javagury.spring.mapper;

import by.javagury.spring.database.entity.Company;
import by.javagury.spring.dto.CompanyDto;
import by.javagury.spring.mapper.interfaces.CompanyToDtoMapper;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Component
@ToString
public class CompanyToDto {

    public CompanyDto mapFrom(Company company){
        return CompanyToDtoMapper.INSTANCE.fromCompanyToDto(company);
    }
}
