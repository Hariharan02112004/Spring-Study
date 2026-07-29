package com.SpringStudy2.Spring.CompanyDetails;

import com.SpringStudy2.Spring.CompanyDetails.Model.Company;
import com.SpringStudy2.Spring.CompanyDetails.Service.CompanyService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class CompanyDetailsApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(CompanyDetailsApplication.class, args);
        Scanner sc = new Scanner(System.in);
        CompanyService comSer = context.getBean(CompanyService.class);
        System.out.print("Enter the number of companies need to be entered: ");
        int n = sc.nextInt();
        int counter = 1;
        while(counter <= n) {
                Company com = new Company();
                System.out.print("Enter the Company id : ");
                com.setCompanyId(sc.nextInt());
                sc.nextLine();
                System.out.print("Enter the name of the company: ");
                com.setCompanyName(sc.nextLine());
                System.out.print("Enter the company's address : ");
                com.setCompanyAddress(sc.nextLine());
                System.out.print("Enter the company's E-mail address : ");
                com.setCompanyEmail(sc.nextLine());
                System.out.print("Enter the company's Phone number : ");
                com.setCompanyPhone(sc.nextLine());
                comSer.insertCom(com);
                counter++;
        }
        List<Company> allCom = comSer.getAll();
        System.out.println(allCom);
        sc.close();
	}

}
