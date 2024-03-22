package br.com.leocustodio.composition.cart.application;

import java.util.Random;
import java.util.Scanner;

import br.com.leocustodio.composition.cart.entities.Product;
import br.com.leocustodio.composition.cart.entities.ShoppingCart;

public class Program {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        @SuppressWarnings("unused")
        ShoppingCart cart = new ShoppingCart();

        System.out.println("-----------------");
        System.out.println("   ADD PRODUCT");
        System.out.println("-----------------");
        System.out.println();
        System.out.print("How many products do you want to add to cart? ");
        int numProd = sc.nextInt();

        collectInformation(numProd, sc);

        Random random = new Random();

        System.out.println();
        System.out.println("-------------------");
        System.out.println("   SHOPPING CART");
        System.out.println("-------------------");
        System.out.println();
        
        printListProducts();
        System.out.println();
        System.out.print("Do you want add more products? 0 to no, any number to add how many you need: ");
        numProd = sc.nextInt();

        if (numProd != 0){
            collectInformation(numProd, sc);
            printHeaderUpdated();
            printListProducts();
            System.out.println();
        } else {
            System.out.println();
            System.out.println("ORDER #" + random.nextInt(1000) + " IS COMPLETED");
            System.out.println();
        }

        sc.close();
        
    }

    static void collectInformation(int numProd, Scanner sc){
        for (int i = 0; i < numProd; i++) {
            sc.nextLine();
            System.out.println();
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Price: ");
            double price = sc.nextDouble();
            sc.nextLine();
            System.out.print("Quantity: ");
            int quantity = sc.nextInt();
            
            Product product = new Product(name, price, quantity);

            ShoppingCart.addProduct(product);
        }
        sc.nextLine();
    }

    static void printListProducts(){
        for (Product prod : ShoppingCart.getProduct()) {
            System.out.println(prod);            
        }
        System.out.println();
        System.out.println("CART TOTAL: $" + String.format("%.2f", ShoppingCart.cartTotal()));
    }

    static void printHeaderUpdated(){
        System.out.println();
        System.out.println("---------------------------");
        System.out.println("   SHOPPING CART UPDATED");
        System.out.println("---------------------------");
        System.out.println();
    }

}
