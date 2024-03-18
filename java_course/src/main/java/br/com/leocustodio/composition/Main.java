package br.com.leocustodio.composition;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        Client client;
        OrderStatus orderStatus = OrderStatus.PENDING_PAYMENT;
        List<OrderItem> listOrderItem = new ArrayList<>();
        Order order;

        System.out.println("Enter client data: ");
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
            System.out.print("Product name: ");
            String prodName = sc.nextLine();
            System.out.print("Product price: ");
            double prodPrice = sc.nextDouble();
            sc.nextLine();
            System.out.print("Quantity: ");
            int prodQuantity = sc.nextInt();
            sc.nextLine();
            Product prod = new Product(prodName, prodPrice);
            OrderItem orderAux = new OrderItem(prodQuantity, prod);
            listOrderItem.add(orderAux);
        }

        order = new Order(LocalDateTime.now(), orderStatus, client, listOrderItem);











    }
}
