package br.com.leocustodio.abstracts.entities;

public abstract class Person {
    private String name;
    private Double annualIncome;

    public Person(){

    }

    public Person(String name, Double annualIncome) {
        this.name = name;
        this.annualIncome = annualIncome;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAnnualIncome(Double annualIncome) {
        this.annualIncome = annualIncome;
    }

    public String getName() {
        return name;
    }

    public Double getAnnualIncome() {
        return annualIncome;
    }

    public Double tax(){
        return 10.0;
    }

    @Override
    public String toString() {
        return "";
    }
}
