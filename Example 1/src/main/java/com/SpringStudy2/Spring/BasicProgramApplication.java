package com.SpringStudy2.Spring;

import com.SpringStudy2.Spring.Models.Laptop;
import com.SpringStudy2.Spring.Service.ServiceLayer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.sql.SQLException;
import java.util.Scanner;

@SpringBootApplication
public class BasicProgramApplication {

	public static void main(String[] args) throws SQLException {

		ApplicationContext context = SpringApplication.run(BasicProgramApplication.class, args);
        Scanner sc  = new Scanner(System.in);
        ServiceLayer serviceLayer = context.getBean(ServiceLayer.class);
        System.out.print("Enter the number of laptops need to be entered: ");
        int numberOfLaptops = sc.nextInt();
        int i = 1;
        while (i <= numberOfLaptops) {
            Laptop lap = CreateLaptop(context, sc);
            serviceLayer.CheckLap(lap);
            i++;
        }
        sc.close();
	}

    private static Laptop CreateLaptop(ApplicationContext context, Scanner sc) {

        Laptop lap1=context.getBean(Laptop.class);
        System.out.println("Enter Laptop ID: ");
        lap1.setLapID(sc.nextInt());
        sc.nextLine();
        System.out.println("Enter Laptop Name: ");
        lap1.setLapName(sc.nextLine());
        System.out.println("Enter Laptop Processor: ");
        lap1.setLapProcessor(sc.nextLine());
        System.out.println("Enter Laptop Hard Disk: ");
        lap1.setLapHardDisk(sc.nextInt());
        sc.nextLine();
        System.out.println("Enter Laptop Keyboard: ");
        lap1.setLapKeyboard(sc.nextLine());
        lap1.printDetails();
        return lap1;
    }

}
