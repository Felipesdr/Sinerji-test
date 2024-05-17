package org.sinerj.entities.positions;

import org.sinerj.entities.employee.Employee;
import org.sinerj.entities.sale.Sale;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
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
    public Double calculateSalary(Employee employee, Integer year, Integer month) {
        LocalDate date = LocalDate.of(year, month, 01);
        Long yearsOfWork = ChronoUnit.YEARS.between(employee.getHiringDate(), date);
        return baseSalary + (yearBenefit * yearsOfWork);
    }

    @Override
    public Double calculateBenefits(Employee employee, Integer year, Integer month) {
        LocalDate date = LocalDate.of(year, month, 01);
        return calculateThisMonthTotalSales(employee.getSaleList(), date) * percentageOfTotalMonthlySales;
    }

    private Double calculateThisMonthTotalSales(List<Sale> sales, LocalDate date){
        Double total = sales.stream().filter(sale -> sale.getDate().getYear() == date.getYear() && sale.getDate().getMonth() == date.getMonth())
                .mapToDouble(Sale::getValue)
                .sum();
        return total;
    }
}
