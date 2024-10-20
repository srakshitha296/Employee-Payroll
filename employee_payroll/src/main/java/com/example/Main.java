package com.example;

abstract class Employee{
    int id;
    String name;

    public Employee(int id, String name){
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public abstract double calculateSalary();

    @Override
    public String toString(){
        return "Employee [Name : "+name+"\nId : "+id+"\nSalary : "+calculateSalary()+"]";
    }
}

class FullTimeEmployee extends Employee{
    private double monthlySalary;

    public FullTimeEmployee(int id, String name, double monthlySalary){
        super(id, name);
        this.monthlySalary = monthlySalary;
    }

    @Override
    public double calculateSalary() {
        return monthlySalary;
    }
    
}

class PartTimeEmployee extends Employee{

    private int hoursWork;
    private double hourlyRate;

    public PartTimeEmployee(int id, String name, int hoursWork, double hourlyRate) {
        super(id, name);
        this.hoursWork = hoursWork;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculateSalary() {
        return hourlyRate*hoursWork;
    }
    
}


public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}