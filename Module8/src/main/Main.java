package main;

import enumm.Gender;
import exception.CompanyAlreadyExistsException;
import exception.CompanyNotFoundException;
import model.*;
import repository.CourseParticipant;
import repository.MemoryListCompanyRepository;
import utils.DateUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
        MemoryListCompanyRepository mlcr = new MemoryListCompanyRepository(new String[]{"Oracle", "Google", "Atlas", "Manpower", "Nintendo", "Solarcity"});
        System.out.println(mlcr.findCompany(0));
        try {
            System.out.println(mlcr.findCompany("Atlas"));
            mlcr.addCompany("Sony");
            mlcr.addCompany("Oracle");
            System.out.println(mlcr.findCompany("Gloggle"));
        } catch (CompanyAlreadyExistsException | CompanyNotFoundException e) {
            System.out.println(e.getMessage());
        }

        mlcr.deleteCompany(0);
        mlcr.updateCompany("Google", "Microsoft");

    }

}
