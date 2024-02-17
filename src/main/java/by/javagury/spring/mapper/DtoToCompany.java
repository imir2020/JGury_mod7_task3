package by.javagury.spring.mapper;

import by.javagury.spring.database.entity.Company;
import by.javagury.spring.dto.CompanyDto;
import by.javagury.spring.mapper.interfaces.DtoToCompanyMapper;

public class DtoToCompany {

    public Company mapFrom(CompanyDto companyDto){
        return DtoToCompanyMapper.INSTANCE.fromDtoToCompany(companyDto);
    }
}
