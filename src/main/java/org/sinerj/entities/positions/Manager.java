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
    public Double calculateSalary(Employee employee, LocalDate date) {
        Long yearsOfWork = ChronoUnit.YEARS.between(employee.getHiringDate(), date);
        return baseSalary + (yearBenefit * yearsOfWork);
    }

    @Override
    public Double calculateBenefits(Employee employee, LocalDate date) {
        return 0.0;
    }
}
