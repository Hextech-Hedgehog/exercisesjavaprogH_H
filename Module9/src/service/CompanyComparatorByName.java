package service;

import model.Company;

import java.util.Comparator;

public class CompanyComparatorByName implements Comparator<Company> {
    @Override
    public int compare(Company o1, Company o2) {
        return o1.getName().compareToIgnoreCase(o2.getName());
    }
}
