package com.cg.bankapp.practice;

import lombok.Data;

import java.util.List;

@Data
public class Employee {

    private String name;
    private String department;
    private int salary;
    private List<String> skills;

    public Employee(String name, String department, int salary, List<String> skills) {
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.skills = skills;
    }
    public Employee(String name, String department, int salary) {
        this(name,department,salary,List.of());
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                ", skills=" + skills +
                '}';
    }
}

record Student (String name, int age) {
}