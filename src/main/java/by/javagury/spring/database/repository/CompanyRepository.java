package by.javagury.spring.database.repository;

import by.javagury.spring.database.entity.Company;
import by.javagury.spring.database.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import java.util.Optional;


public interface CompanyRepository extends JpaRepository<Company, Integer> {

    Optional<Company> findById(Integer companyId);

    @Modifying
    @Query("""
            update Company c
            set c.name = :companyName
            where c.id= :id """)
    void updateCompanyNameById(String companyName, Integer id);


//    @Query("""
//            delete Company c
//            where c.name =: A%
//
//            """)
    void deleteCompanyByNameIgnoreCaseLike(String firstSymbol);


}
