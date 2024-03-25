package br.com.leocustodio.abstracts.entities;

public class Individual extends Person {
    private Double healthSpending;

    public Individual() {

    }

    public Individual(String name, Double annualIncome, Double healthSpending) {
        super(name, annualIncome);
        this.healthSpending = healthSpending;
    }

    public Double getHealthSpending() {
        return healthSpending;
    }

    public void setHealthSpending(Double healthSpending) {
        this.healthSpending = healthSpending;
    }

    @Override
    public Double tax() {
        double tax;
        double discountHealthSpending = 0.0;

        if (super.getAnnualIncome() < 20000){
            tax = 0.15;
        } else {
            tax = 0.25;
        }

        if (this.healthSpending > 0){
            discountHealthSpending = this.healthSpending - (this.healthSpending * 0.5);
        } else {
            discountHealthSpending = 0.0;
        }

        return super.getAnnualIncome() * tax - discountHealthSpending;
    }

    @Override
    public String toString() {
        return super.getName() + ": $ " + String.format("%.2f", tax()) + "\n";
    }
}
