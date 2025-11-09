package com.company.payroll;
import com.company.hr.Employee;
public class Payroll {
    public void addBonus(Employee e) {
        e.setSalary(e.getSalary() + e.getSalary() * 0.1);
    }
}