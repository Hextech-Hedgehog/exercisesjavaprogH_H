package be.abis.courseadmin.repository;

import be.abis.courseadmin.model.Company;
import java.util.Arrays;

public class MemoryArrayCompanyRepository implements CompanyRepository {

    private Company[] companies = new Company[5];
    private Company[] companies2 = new Company[5];

    public MemoryArrayCompanyRepository(String[] companiesNames) {
        long start, finish, timeElapsed;
        start = System.nanoTime();
        this.companies = Arrays.stream(companiesNames).map(Company::new).toArray(Company[]::new);
        finish = System.nanoTime();
        timeElapsed = finish - start;
        System.out.println(timeElapsed);

        start = System.nanoTime();
        for (int index = 0; index < companiesNames.length; index++) {
            this.companies2[index] = new Company(companiesNames[index]);
        }
        finish = System.nanoTime();
        timeElapsed = finish - start;
        System.out.println(timeElapsed);
    }

    @Override
    public Company findCompany(int id) {
        return this.companies[id];
    }

    @Override
    public Company findCompany(String name) {
        long start, finish, timeElapsed;
        start = System.nanoTime();
        Company res = Arrays.stream(this.companies).filter(s -> s.getName().equals(name)).findFirst().get();
        finish = System.nanoTime();
        timeElapsed = finish - start;
        System.out.println(timeElapsed);
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
}
