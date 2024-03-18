package br.com.leocustodio.composition;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        Client client;
        List<OrderItem> listOrderItem = new ArrayList<>();
        Order order;

        System.out.println("ENTER CLIENT DATA");
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("Birth date (yyyy-MM-dd): ");
        String birthDateString = sc.nextLine();
        //TemporalAccessor birthDateString2 = dtf1.parse(birthDateString);
        //LocalDate birthDate = LocalDate.from(birthDateString2);
        LocalDate birthDate = LocalDate.parse(birthDateString);
        client = new Client(name, email, birthDate);
        System.out.println("Enter order data: ");
        System.out.print("Status: ");
        String status = sc.nextLine();

        System.out.print("How many items to this order? ");
        int numItems = sc.nextInt();
        for (int i = 0; i < numItems; i++) {
            sc.nextLine();
            System.out.printf("Enter #%d item data %n", (i+1));
            Order.addItem();
//            System.out.print("Product name: ");
//            String prodName = sc.nextLine();
//            System.out.print("Product price: ");
//            double prodPrice = sc.nextDouble();
//            sc.nextLine();
//            System.out.print("Quantity: ");
//            int prodQuantity = sc.nextInt();
//            Product prod = new Product(prodName, prodPrice);
//            OrderItem orderAux = new OrderItem(prodQuantity, prod);
//            listOrderItem.add(orderAux);
        }

        order = new Order(LocalDateTime.now(), OrderStatus.valueOf(status), client, listOrderItem);
        System.out.println();
        System.out.println(order);

        //Adding more items
        System.out.println();
        System.out.println("Do you want to add one more product (s/n): ");
        char choice;
        choice = sc.next().charAt(0);
        while (choice == 's'){
            sc.nextLine();
            System.out.println("Enter new item data");
            Order.addItem();
            System.out.println("Do you want to add one more product (s/n): ");
            choice = sc.next().charAt(0);
        }




        sc.close();
        











    }
}
