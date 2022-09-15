package be.abis.courseadmin.test;

import be.abis.courseadmin.model.Company;
import be.abis.courseadmin.repository.MemoryArrayCompanyRepository;
import static org.junit.jupiter.api.Assertions.*;

class MemoryArrayCompanyRepositoryTest {

    @org.junit.jupiter.api.Test
    void testmacrConstructor() {
        MemoryArrayCompanyRepository macr = new MemoryArrayCompanyRepository(new String[]{"Oracle", "google", "Atlas", "dybex", "pathé", "Kazé"});
        assertEquals(5, macr.getCompanies().length);
    }

    @org.junit.jupiter.api.Test
    void findCompany() {
        MemoryArrayCompanyRepository macr = new MemoryArrayCompanyRepository(new String[]{"Oracle", "google", "Atlas", "dybex", "pathé"});
        assertEquals(new Company("Atlas").getName(), macr.findCompany("Atlas").getName());
    }

    @org.junit.jupiter.api.Test
    void testFindCompany() {
        MemoryArrayCompanyRepository macr = new MemoryArrayCompanyRepository(new String[]{"Oracle", "google", "Atlas", "dybex", "pathé"});
        assertEquals(new Company("Atlas").getName(), macr.findCompany(2).getName());
    }
}