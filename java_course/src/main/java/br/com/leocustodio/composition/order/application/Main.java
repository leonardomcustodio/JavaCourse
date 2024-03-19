package br.com.leocustodio.composition.order.application;

import br.com.leocustodio.composition.order.entities.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Client client;

        //Create client
        System.out.println("ENTER CLIENT DATA");
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("Birth date (DD/MM/YYYY): ");
        LocalDate birthDateString = LocalDate.from(dtf1.parse(sc.nextLine()));
        client = new Client(name, email, birthDateString);

        //Create order
        System.out.println("Enter order data: ");
        System.out.print("Status: ");
        OrderStatus status = OrderStatus.valueOf(sc.nextLine());
        Order order = new Order(LocalDateTime.now(), status, client);

        //Create items
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

            Product product = new Product(prodName, prodPrice);

            //Creating orderItem and add to order list
            OrderItem item = new OrderItem(prodQuantity, prodPrice, product);
            order.addItem(item);
        }

        System.out.println();
        System.out.println(order);

        sc.close();

    }
}
