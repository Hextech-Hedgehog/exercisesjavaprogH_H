package repository;

import exception.CompanyNotFoundException;
import model.Address;
import model.Company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MemoryListCompanyRepository implements CompanyRepository {
    private List<Company> companies;

    public MemoryListCompanyRepository(String[] companiesNames) {
        this.companies = Arrays.stream(companiesNames).map(s -> new Company(s, new Address())).collect(Collectors.toList());
    }

    @Override
    public Company findCompany(int index) {
        return this.companies.get(index);
    }

    @Override
    public Company findCompany(String name) throws CompanyNotFoundException {
        Company res = this.companies.stream().filter(s -> s.getName().equals(name)).findFirst().orElse(null);
        if (res == null) {
            throw new CompanyNotFoundException("Company " + name + " not found.");
        }
        return res;
    }

    @Override
    public void addCompany(Company c) {
        this.companies.add(c);
    }

    @Override
    public void updateCompany(Company c) {
        int index = this.companies.indexOf(c);
        this.companies.set(index, c);
    }

    @Override
    public void deleteCompany(int index) {
        this.companies.remove(index);
    }

    public List<Company> getCompanies() {
        return this.companies;
    }
}
