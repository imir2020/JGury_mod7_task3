package by.javagury.spring.mapper.interfaces;

import by.javagury.spring.database.entity.Company;
import by.javagury.spring.database.entity.User;
import by.javagury.spring.dto.CompanyDto;
import by.javagury.spring.dto.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DtoToCompanyMapper {
   DtoToCompanyMapper INSTANCE = Mappers.getMapper(DtoToCompanyMapper.class);

   Company fromDtoToCompany(CompanyDto companyDto);
}
