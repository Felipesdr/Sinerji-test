package org.sinerj.entities.positions;

import org.sinerj.entities.employee.Employee;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Manager extends Position{
    public Manager(){
        super();
        baseSalary = 20000.00;
        yearBenefit = 3000.00;
    }
    @Override
    public Double calculateSalary(Employee employee, Integer year, Integer month) {
        LocalDate date = LocalDate.of(year, month, 01);
        Long yearsOfWork = ChronoUnit.YEARS.between(employee.getHiringDate(), date);
        return baseSalary + (yearBenefit * yearsOfWork);
    }

    @Override
    public Double calculateBenefits(Employee employee, Integer year, Integer month) {
        return 0.0;
    }
}
