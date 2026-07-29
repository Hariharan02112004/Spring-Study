package com.SpringStudy2.Spring.CompanyDetails.Service;

import com.SpringStudy2.Spring.CompanyDetails.Model.Company;
import com.SpringStudy2.Spring.CompanyDetails.Repository.CompanyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {
    private CompanyRepo repo;

    public CompanyService(CompanyRepo repo) {
        this.repo = repo;
    }

    public void insertCom(Company company) {
        repo.save(company);
    }

    public List<Company> getAll() {
        return repo.findAll();
    }
}
