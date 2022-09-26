package service;

import model.Company;
import repository.MemoryListCompanyRepository;

import java.util.Comparator;

public class AbisCompanyService implements CompanyService {

    private MemoryListCompanyRepository mlcr = new MemoryListCompanyRepository(new String[]{"Oracle", "Nintendo", "Windows", "Google", "ABIS"});
    public static Comparator<Company> compareByName = Comparator.comparing(Company::getName);

    @Override
    public void sortAllCompaniesByName() {
        mlcr.getCompanies().sort(compareByName);
    }

    public void sortAllCompaniesByNumber() {
        mlcr.getCompanies().sort(new Comparator<Company>() {
            @Override
            public int compare(Company o1, Company o2) {
                if (o1.getCompanyNumber() < o2.getCompanyNumber())
                    return 1;
                else if (o1.getCompanyNumber() > o2.getCompanyNumber())
                    return -1;
                return 0;
            }
        });
    }

    public MemoryListCompanyRepository getMlcr() {
        return mlcr;
    }
}
