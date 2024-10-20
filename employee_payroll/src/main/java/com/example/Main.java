package com.example;

import java.util.ArrayList;

//Bussiness Logic
abstract class Employee {
    int id;
    String name;

    public Employee(int id, String name) {
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
    public String toString() {
        return "                    | Name : " + name + "\n                    | Id : " + id + "\n                    | Salary : " + calculateSalary()+"\n                    --------------------";
    }
}

class FullTimeEmployee extends Employee {
    private double monthlySalary;

    public FullTimeEmployee(int id, String name, double monthlySalary) {
        super(id, name);
        this.monthlySalary = monthlySalary;
    }

    @Override
    public double calculateSalary() {
        return monthlySalary;
    }

}

class PartTimeEmployee extends Employee {

    private int hoursWork;
    private double hourlyRate;

    public PartTimeEmployee(int id, String name, int hoursWork, double hourlyRate) {
        super(id, name);
        this.hoursWork = hoursWork;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculateSalary() {
        return hourlyRate * hoursWork;
    }

}

class PayrollSystem {
    private ArrayList<Employee> employeeList;

    public PayrollSystem() {
        employeeList = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employeeList.add(employee);
    }

    public void removeEmployee(int id) {
        Employee employeeToBeRemoved = null;
        for (Employee employee : employeeList) {
            if (employee.getId() == id) {
                employeeToBeRemoved = employee;
                break;
            }
        }
        if (employeeToBeRemoved != null) {
            System.out.print("\n                                    *** "+employeeToBeRemoved.name+" resigned***\n\n");
            employeeList.remove(employeeToBeRemoved);
            System.out.println();
        }
    }

    public void displayEmployees() {
        for (Employee employee : employeeList) {
            System.out.println(employee);
        }
    }
}

// Client logic
public class Main {
    public static void main(String[] args) {
        PayrollSystem payrollSystem = new PayrollSystem();
        FullTimeEmployee emp1 = new FullTimeEmployee(1, "Rakshitha", 70000.0);
        PartTimeEmployee emp2 = new PartTimeEmployee(2, "Lavish", 15, 1000);

        payrollSystem.addEmployee(emp1);
        payrollSystem.addEmployee(emp2);

        System.out.println("                                        Employee Details\n                                        ---------------");
        payrollSystem.displayEmployees();

        //System.out.println("--------------------Removing Employess-------------------- ");
        payrollSystem.removeEmployee(2);

        System.out.println("                                        Employee Details\n                                        ---------------");
        payrollSystem.displayEmployees();

    }
}