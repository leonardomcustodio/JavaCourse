package br.com.leocustodio.composition.cart.entities;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    private List<Product> product = new ArrayList<Product>();

    public void addProduct(Product product){
        this.product.add(product);
    }

    public void removeProduct(Product product){
        this.product.remove(product);
    }

    public Double cartTotal(){
        double sum = 0.0;
        for(Product prod : product){
            sum += prod.getPrice() * prod.getQuantity();
        }
        return sum;
    }

}

