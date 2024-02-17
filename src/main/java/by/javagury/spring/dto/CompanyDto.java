package by.javagury.spring.dto;

import lombok.Builder;
import lombok.Value;
import java.util.Map;

@Value
@Builder

public class CompanyDto{
    Integer id;
    String name;
    Map<String,String> locales;
}
