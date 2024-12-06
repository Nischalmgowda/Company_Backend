package com.example.company.Company.Inter;

import com.example.company.Company.Entiry.Company;

import java.util.List;

public interface CompanyInter {
    List<Company> getAllcompanies();
    Company getAllById(long id);
    boolean updateCompany(Company company,long id);
    Company AddCompany(Company company);
    void deleteCompany(long id);

}
