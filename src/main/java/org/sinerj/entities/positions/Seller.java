package org.sinerj.entities.positions;

import org.sinerj.entities.employee.Employee;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class Seller extends Position {

    private Double percentageOfTotalMonthlySales;
    public Seller(){
        super();
        baseSalary = 12000.00;
        yearBenefit = 1800.00;
        percentageOfTotalMonthlySales = 0.3;
    }

    @Override
    public Double calculateSalary(Employee employee, LocalDate date) {
        Long yearsOfWork = ChronoUnit.YEARS.between(employee.getHiringDate(), date);
        return baseSalary + (yearBenefit * yearsOfWork);
    }

    @Override
    public Double calculateBenefits(Employee employee, LocalDate date) {
        return calculateThisMonthTotalSales(employee.getSaleList(), date) * percentageOfTotalMonthlySales;
    }

    private Double calculateThisMonthTotalSales(List<Sale> sales, LocalDate date){
        return sales.stream().filter(sale -> sale.getDate().equals(sale.getDate().getYear() == date.getYear() && sale.getDate().getMonth() == date.getMonth()))
                .mapToDouble(Sale::getValue)
                .sum();
    }
}
