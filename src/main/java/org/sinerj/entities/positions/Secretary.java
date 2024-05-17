package org.sinerj.entities.positions;

import org.sinerj.entities.employee.Employee;
import org.sinerj.entities.positions.Position;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Secretary extends Position {

    private Double percentageOfSalaryBonus;
    public Secretary(){
        super();
        baseSalary = 7000.00;
        yearBenefit = 1800.00;
        percentageOfSalaryBonus = 0.2;
    }

    @Override
    public Double calculateSalary(Employee employee, LocalDate date) {
        Long yearsOfWork = ChronoUnit.YEARS.between(employee.getHiringDate(), date);
        return baseSalary + (yearBenefit * yearsOfWork);
    }

    @Override
    public Double calculateBenefits(Employee employee, LocalDate date) {
        return baseSalary * percentageOfSalaryBonus;
    }
}
