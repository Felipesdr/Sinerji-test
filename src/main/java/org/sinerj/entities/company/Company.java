package org.sinerj.entities.company;

import org.sinerj.entities.employee.Employee;
import org.sinerj.entities.positions.Seller;
import org.sinerj.entities.sale.Sale;
import org.sinerj.exceptions.ValidationException;

import java.util.Comparator;
import java.util.List;

public class Company {
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

    public static Double calculateTotalPaymentForMonthToEmployeesWithBenefits(List<Employee> employees, Integer year, Integer month){
        validadeListOnlyEmployeesWithBenefits(employees, year, month);

        Double totalSalary = calculateTotalSalaryForMonth(employees, year, month);
        Double totalBenefits = calculateTotalBenefitsForMonth(employees, year, month);

        return totalSalary + totalBenefits;
    }


    public static Employee findHighestPaidEmployee(List<Employee> employees, Integer year, Integer month){
        Comparator<Employee> comparator = Comparator.comparing(e -> e.calculateSalary(year, month) + e.calculateBenefits(year, month));

        return employees.stream().max(comparator).orElse(null);
    }

    public static Employee findHighestPaidEmployeeWithBenefits(List<Employee> employees, Integer year, Integer month){
        validadeListOnlyEmployeesWithBenefits(employees, year, month);

        Comparator<Employee> comparator = Comparator.comparing(e -> e.calculateBenefits(year, month));

        return employees.stream().max(comparator).orElse(null);
    }

    public static  Employee findTopSellerByMonth(List<Employee> sellers, Integer year, Integer month){
        for (Employee e: sellers){
            if (!e.getPosition().getClass().equals(Seller.class)){
                throw new ValidationException("Esse metodo aceita apenas vendedores");
            }
        }

        Comparator<Employee> comparator = Comparator.comparing(e -> e.getSaleList().stream().
                filter(s -> s.getDate().getYear() == year && s.getDate().getMonthValue() == month)
                .mapToDouble(Sale::getValue)
                .sum());

        return sellers.stream().max(comparator).orElse(null);
    }

    private static void validadeListOnlyEmployeesWithBenefits(List<Employee> employees, Integer year, Integer month){
        for(Employee e: employees) {
            if (e.calculateBenefits(year, month) == 0)
                throw new ValidationException("Esse método só aceita funcionários com benefícios.");
        }
    }

}
