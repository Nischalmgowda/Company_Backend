package com.example.company.Company.Service;

import com.example.company.Company.Entiry.Company;
import com.example.company.Company.Inter.CompanyInter;
import com.example.company.Company.Repository.CompanyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyService implements CompanyInter {

    @Autowired
    CompanyRepo repo;
    @Override
    public List<Company> getAllcompanies() {
        return repo.findAll();
    }

    @Override
    public boolean updateCompany(Company company, long id) {
        Optional<Company> companyOptional = repo.findById(id);
        if (companyOptional.isPresent()) {
            Company update = companyOptional.get();
            update.setDescription(company.getDescription());
            update.setName(company.getName());
            update.setJobs(company.getJobs());
            repo.save(update);
            return true;
        } else {

            return false;
        }
    }

    @Override
    public Company AddCompany(Company company) {
       return repo.save(company);
    }

    @Override
    public void deleteCompany(long id) {
        repo.deleteById(id);
    }

    @Override
    public Company getAllById(long id) {
        return repo.findById(id).get();
    }
}
