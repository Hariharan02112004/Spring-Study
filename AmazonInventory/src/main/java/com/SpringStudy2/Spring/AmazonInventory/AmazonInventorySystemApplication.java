package com.SpringStudy2.Spring.AmazonInventory;

import com.SpringStudy2.Spring.AmazonInventory.Model.Items;
import com.SpringStudy2.Spring.AmazonInventory.Service.ItemServices;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class AmazonInventorySystemApplication {

	public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(AmazonInventorySystemApplication.class, args);
        Scanner sc = new Scanner(System.in);
        ItemServices itemServices=context.getBean(ItemServices.class);
        System.out.println("Enter the number of items need to be added: ");
        int count = sc.nextInt();
        int counter=1;
        while(counter<=count){
            Items item=context.getBean(Items.class);
            System.out.print("Enter the Batch number of the item : ");
            item.setItemNo(sc.nextInt());
            sc.nextLine();
            System.out.print("Enter the name of the item : ");
            item.setItemName(sc.nextLine());
            System.out.println("Enter the description of the item : ");
            item.setItemDescription(sc.nextLine());
            System.out.println("Enter the price of the item : ");
            item.setItemPrice(sc.nextDouble());
            sc.nextLine();
            itemServices.InsertItem(item);
            counter++;
        }
        System.out.println("Printing All items.........");
        List<Items> ls = itemServices.getAll();
        System.out.println(ls);
        sc.close();
	}

}




