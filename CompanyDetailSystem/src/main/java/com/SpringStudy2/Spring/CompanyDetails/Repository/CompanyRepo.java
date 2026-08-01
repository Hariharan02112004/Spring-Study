package com.SpringStudy2.Spring.CompanyDetails.Repository;

import com.SpringStudy2.Spring.CompanyDetails.Model.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CompanyRepo {
    private JdbcTemplate jdbc;

    public CompanyRepo(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public void save(Company company) {
        String query="insert into companytable(companyId, companyName, companyAddress, companyEmail, companyPhone) values(?,?,?,?,?)";
        int res = jdbc.update(query,company.getCompanyId(),company.getCompanyName(),company.getCompanyAddress(),company.getCompanyEmail(),company.getCompanyPhone());
        if(res>0){
            System.out.println("Added Successfully");
        }else{
            System.out.println("Added Failed");
        }
    }

    public List<Company> findAll() {
        String selQuery="select * from companytable";
        return jdbc.query(selQuery,(rs, rownum)->{
            Company comp=new Company();
            comp.setCompanyId(rs.getInt("companyId"));
            comp.setCompanyName(rs.getString("companyName"));
            comp.setCompanyAddress(rs.getString("companyAddress"));
            comp.setCompanyEmail(rs.getString("companyEmail"));
            comp.setCompanyPhone(rs.getString("companyPhone"));
            return comp;
        }
        );


    }
}
