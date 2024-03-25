package br.com.leocustodio.abstracts.entities;

public class Company extends Person{
    public Integer numEmployees;

    public Company() {

    }

    public Company(String name, Double annualIncome, Integer numEmployees) {
        super(name, annualIncome);
        this.numEmployees = numEmployees;
    }

    public Integer getNumEmployees() {
        return numEmployees;
    }

    public void setNumEmployees(Integer numEmployees) {
        this.numEmployees = numEmployees;
    }

    @Override
    public Double tax() {
        double tax;
        //double discountHealthSpending = 0.0;

        if (this.numEmployees > 10){
            tax = 0.14;
        } else {
            tax = 0.16;
        }
        return super.getAnnualIncome() * tax;
    }

    @Override
    public String toString() {
        return super.getName() + ": $ " + String.format("%.2f", tax()) + "\n";
    }
}
