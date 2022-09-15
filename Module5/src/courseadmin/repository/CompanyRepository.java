package courseadmin.repository;

import exception.CompanyNotFoundException;
import model.Company;

public interface CompanyRepository {

    Company findCompany(int id);
    Company findCompany(String name) throws CompanyNotFoundException;
    void addCompany(Company c);
    void updateCompany(Company c);
    void deleteCompany(int id);

    default void printInfo() {
        System.out.println("hello");
    }

}
