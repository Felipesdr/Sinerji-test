package org.sinerj.entities.positions;

import org.sinerj.entities.employee.Employee;
import org.sinerj.entities.positions.Position;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.temporal.ChronoUnit;

public class Secretary extends Position {

    private Double percentageOfSalaryBonus;
    public Secretary(){
        super();
        baseSalary = 7000.00;
        yearBenefit = 1000.00;
        percentageOfSalaryBonus = 0.2;
    }

    @Override
    public Double calculateSalary(Employee employee, Integer year, Integer month) {
        LocalDate date = LocalDate.of(year, month, 01);
        Long yearsOfWork = ChronoUnit.YEARS.between(employee.getHiringDate(), date);
        return baseSalary + (yearBenefit * yearsOfWork);
    }

    @Override
    public Double calculateBenefits(Employee employee, Integer year, Integer month) {
        return calculateSalary(employee, year, month) * percentageOfSalaryBonus;
    }
}
