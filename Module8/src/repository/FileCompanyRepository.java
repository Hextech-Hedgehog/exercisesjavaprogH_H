package repository;

import exception.CompanyAlreadyExistsException;
import exception.CompanyNotFoundException;
import model.Company;

import java.io.File;

public interface FileCompanyRepository {

    File companiesFile = new File("C:\\Users\\Duser\\Documents\\companies.txt");


    Company findCompany(int index);
    Company findCompany(String name) throws CompanyNotFoundException;
    void addCompany(String name) throws CompanyAlreadyExistsException;
    void updateCompany(String prevName, String newName);
    void deleteCompany(int id);

    default void printInfo() {
        System.out.println("hello");
    }

}
