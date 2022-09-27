package repository;

import exception.CompanyAlreadyExistsException;
import exception.CompanyNotFoundException;
import model.Address;
import model.Company;

import java.io.*;

public class MemoryListCompanyRepository implements FileCompanyRepository {

    public MemoryListCompanyRepository(String[] companiesNames) {
        this.writeCompanyToFile(false, companiesNames);
    }

    @Override
    public Company findCompany(int index) {
        try (BufferedReader br = new BufferedReader(new FileReader(FileCompanyRepository.companiesFile))) {
            String line;
            for (int lineIndex = 0; (line = br.readLine()) != null; lineIndex++) {
                if (lineIndex == index)
                    return new Company(line, new Address());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Company findCompany(String name) throws CompanyNotFoundException {
        try (BufferedReader br = new BufferedReader(new FileReader(FileCompanyRepository.companiesFile))) {
            String line;
            while((line = br.readLine()) != null) {
                if (line.equals(name))
                    return new Company(name, new Address());
            }
            throw new CompanyNotFoundException("Company " + name + " doesn't exist.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void addCompany(String name) throws CompanyAlreadyExistsException {
        try (BufferedReader br = new BufferedReader(new FileReader(FileCompanyRepository.companiesFile));
             BufferedWriter bw = new BufferedWriter(new FileWriter(FileCompanyRepository.companiesFile, true))) {

            String line;
            while ((line = br.readLine()) != null) {
                if (line.equals(name))
                    throw new CompanyAlreadyExistsException("Company: " + name + " already exists");
            }

            br.close();
            bw.write(name);
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateCompany(String prevName, String oldName) {
        this.overWriteCompanyToFile(prevName, oldName);
    }

    @Override
    public void deleteCompany(int index) {
        Company c = this.findCompany(index);
        if (c == null)
            return;
        this.overWriteCompanyToFile(c.getName(), "");
    }

    private void writeCompanyToFile(boolean append, String ... companiesName) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FileCompanyRepository.companiesFile, append))) {
            for (String str: companiesName) {
                bw.write(str);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void overWriteCompanyToFile(String prevCompanyName, String newCompanyCame) {
        try (BufferedReader br = new BufferedReader(new FileReader(FileCompanyRepository.companiesFile))) {
            String line;
            StringBuilder updatedFileContent = new StringBuilder();
            while ((line = br.readLine()) != null) {
                if (line.equals(prevCompanyName)) {
                    line = newCompanyCame;
                    if (newCompanyCame.length() > 0)
                        updatedFileContent.append(line + "\n");
                } else
                    updatedFileContent.append(line + "\n");
            }
            br.close();
            FileOutputStream fos = new FileOutputStream(FileCompanyRepository.companiesFile);
            fos.write(updatedFileContent.toString().getBytes());
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
