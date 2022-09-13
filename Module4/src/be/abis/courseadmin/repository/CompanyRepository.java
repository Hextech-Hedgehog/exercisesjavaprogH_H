package be.abis.courseadmin.repository;

import be.abis.courseadmin.model.*;

public interface CompanyRepository {

    Company findCompany(int id);
    Company findCompany(String name);
    void addCompany(Company c);
    void updateCompany(Company c);
    void deleteCompany(int id);

    default void printInfo() {
        System.out.println("hello");
    }

}
