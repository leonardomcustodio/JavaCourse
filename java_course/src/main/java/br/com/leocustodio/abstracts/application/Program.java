package br.com.leocustodio.abstracts.application;

import br.com.leocustodio.abstracts.entities.Company;
import br.com.leocustodio.abstracts.entities.Individual;
import br.com.leocustodio.abstracts.entities.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Person> list = new ArrayList<>();

        System.out.print("Enter the number of tax players: ");
        int numTax = sc.nextInt();

        for (int i = 0; i < numTax; i++) {
            sc.nextLine();
            System.out.println("Tax payer #" + (i+1) + " data:");
            System.out.print("Individual or company (i/c): ");
            char personType = sc.next().charAt(0);
            sc.nextLine();
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Annual income: ");
            double annualIncome = sc.nextDouble();
            if (personType == 'i'){
                System.out.print("Health expenditures: ");
                double healthSpenditures = sc.nextDouble();
                Individual individual = new Individual(name, annualIncome, healthSpenditures);
                list.add(individual);
            } else if (personType == 'c'){
                System.out.print("Number of employees: ");
                int numEmployees = sc.nextInt();
                Company company = new Company(name, annualIncome, numEmployees);
                list.add(company);
            }
        }
        System.out.println();
        System.out.println("TAXES PAID:");
        double sumTax = 0.0;
        for (Person person : list){
            System.out.print(person.toString());
            sumTax += person.tax();
        }
        System.out.println();
        System.out.println("TOTAL TAXES: $ " + String.format("%.2f", sumTax));

    }
}
