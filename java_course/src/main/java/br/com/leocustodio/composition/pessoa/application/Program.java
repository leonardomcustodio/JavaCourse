package br.com.leocustodio.composition.pessoa.application;

import br.com.leocustodio.composition.pessoa.entities.Address;
import br.com.leocustodio.composition.pessoa.entities.Person;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        //Enter data
        Scanner sc = new Scanner(System.in);
        System.out.println("---------------------");
        System.out.println("COSTUMER REGISTRATION");
        System.out.println("---------------------");
        System.out.println();
        System.out.print("Enter client first name: ");
        String firstName = sc.nextLine();
        System.out.print("Enter client last name: ");
        String lastName = sc.nextLine();
        System.out.print("Enter client full adress: ");

        Address address = new Address(sc.nextLine());

        Person person = new Person(firstName, lastName, address);

        System.out.println(person);

        sc.close();
    }
}
