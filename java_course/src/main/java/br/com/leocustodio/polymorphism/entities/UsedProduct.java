package br.com.leocustodio.polymorphism.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class UsedProduct extends Product{
    
    LocalDate manufactureDate;
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    @Override
    public String priceTag() {
        return getName() + " (used) $ " + String.format("%.2f", getPrice()) + " (Manufacture date: " + dtf.format(manufactureDate) + ")";
    }
    
}
