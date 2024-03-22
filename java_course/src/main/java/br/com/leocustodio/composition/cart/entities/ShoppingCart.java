package br.com.leocustodio.composition.cart.entities;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    private static List<Product> product = new ArrayList<Product>();

    public static List<Product> getProduct() {
        return product;
    }

    public static void addProduct(Product prod){
        product.add(prod);
    }

    public static Double cartTotal(){
        double sum = 0.0;
        for(Product prod : product){
            sum += prod.getPrice() * prod.getQuantity();
        }
        return sum;
    }

 

 

}

