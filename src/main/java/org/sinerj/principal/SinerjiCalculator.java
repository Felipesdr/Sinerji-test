package org.sinerj.principal;

import org.sinerj.entities.employee.Employee;

import java.util.List;

public class SinerjiCalculator {
    public static Double calculateTotalSalaryForMonth(List<Employee> employees, Integer year, Integer month){
        return employees.stream()
                .mapToDouble(e-> e.calculateSalary(year, month))
                .sum();
    }

    public static Double calculateTotalBenefitsForMonth(List<Employee> employees, Integer year, Integer month){
        return employees.stream()
                .mapToDouble(e-> e.calculateBenefits(year, month))
                .sum();
    }








//    public Double calculateTotalPaymentForMonth(List<Employee> employees, Integer month, Integer Year){
//        return employees.stream()
//                .
//
//    }
}
