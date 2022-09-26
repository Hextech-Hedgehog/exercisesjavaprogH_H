package repository;

import exception.CompanyNotFoundException;
import model.Address;
import model.Company;

import java.util.Arrays;

public class MemoryArrayCompanyRepository implements CompanyRepository {

    private Company[] companies = new Company[5];

    public MemoryArrayCompanyRepository(String[] companiesNames) {
        //long start, finish, timeElapsed;
        //start = System.nanoTime();
        //this.companies = Arrays.stream(companiesNames).map(Company::new).toArray(Company[]::new);
        for (int index = 0; index < this.companies.length; index++) {
            this.companies[index] = new Company(companiesNames[index], new Address("", "", "", "", "", ""));
        }
        /*finish = System.nanoTime();
        timeElapsed = finish - start;
        System.out.println(timeElapsed);*/

        /*start = System.nanoTime();
        for (int index = 0; index < companiesNames.length; index++) {
            this.companies2[index] = new Company(companiesNames[index]);
        }
        finish = System.nanoTime();
        timeElapsed = finish - start;
        System.out.println(timeElapsed);*/
    }

    @Override
    public Company findCompany(int index) {
        return this.companies[index];
    }

    @Override
    public Company findCompany(String name) throws CompanyNotFoundException {
        //long start, finish, timeElapsed;
        //start = System.nanoTime();
        Company res = Arrays.stream(this.companies).filter(s -> s.getName().equals(name)).findFirst().orElse(null);
        if (res == null) {
            throw new CompanyNotFoundException("Company " + name + " not found.");
        }
        /*finish = System.nanoTime();
        timeElapsed = finish - start;
        System.out.println(timeElapsed);*/
        return res;
    }

    @Override
    public void addCompany(Company c) {

    }

    @Override
    public void updateCompany(Company c) {

    }

    @Override
    public void deleteCompany(int id) {

    }

    public Company[] getCompanies() {
        return companies;
    }
}
