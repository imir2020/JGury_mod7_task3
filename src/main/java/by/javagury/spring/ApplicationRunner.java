package by.javagury.spring;


import by.javagury.spring.config.ApplicationConfiguration;
import by.javagury.spring.database.repository.pool.ConnectionPool;
import by.javagury.spring.service.CompanyService;
import by.javagury.spring.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
@ConfigurationPropertiesScan
public class ApplicationRunner {

    public static void main(String[] args) {
        var context = SpringApplication.run(ApplicationRunner.class, args);
       var result = context.getBean("companyService",CompanyService.class);

        System.out.println(result.findById(1));

        var userService = context.getBean("userService", UserService.class);
        System.out.println(userService.findById(2L));


    }
}
