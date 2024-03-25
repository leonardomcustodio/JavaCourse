package br.com.leocustodio.polymorphism.application;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.leocustodio.polymorphism.entities.ImportedProduct;
import br.com.leocustodio.polymorphism.entities.Product;
import br.com.leocustodio.polymorphism.entities.UsedProduct;



public class Program {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        List<Product> list = new ArrayList<>();

        System.out.print("Enter the number of products: ");
        int numProd = sc.nextInt();

        for (int i = 0; i < numProd; i++) {
            System.out.println("Product #" + (i+1) + " data:");
            System.out.print("Common, used or imported (c/u/i)? ");
            char ch = sc.next().charAt(0);
            sc.nextLine();
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Price: ");
            double price = sc.nextDouble();
            if (ch == 'c'){
                Product prod = new Product(name, price); 
                list.add(prod);
            } else if (ch == 'u'){
                System.out.print("Manufacture date: ");
                LocalDate date = LocalDate.parse(sc.next());
                Product prod = new UsedProduct(name, price, date);
                list.add(prod);
            }else {
                System.out.print("Customs fee: ");
                double fee = sc.nextDouble();
                Product prod = new ImportedProduct(name, price, fee);
                list.add(prod);
            }
        }

        for (Product prod : list) {
            prod.priceTag();
            System.out.println();
        }
    }
}
