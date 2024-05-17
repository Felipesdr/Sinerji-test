package org.sinerj.entities.positions;

import org.sinerj.entities.employee.Employee;

import java.time.LocalDate;

public abstract class Position {

    protected Double baseSalary;
    protected Double yearBenefit;


    public abstract  Double calculateSalary(Employee employee, Integer year, Integer month);

    public abstract Double calculateBenefits(Employee employee, Integer year, Integer month);

}
