package org.sinerj.principal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.sinerj.entities.employee.Employee;
import org.sinerj.entities.positions.Manager;
import org.sinerj.entities.positions.Secretary;
import org.sinerj.entities.positions.Seller;
import org.sinerj.entities.sale.Sale;
import org.sinerj.exceptions.ValidationException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SinerjiCalculatorTest {

    private Employee employee1;
    private Employee employee2;
    private Employee employee3;
    private Employee employee4;
    private Employee employee5;
    private Employee employee6;

    List<Employee> employees = new ArrayList<>();

    @BeforeEach
    void setUp(){
        employee1 = new Employee("Jorge Carvalho", new Secretary(), LocalDate.of(2018, 1, 1));
        employee2 = new Employee("Maria Souza", new Secretary(), LocalDate.of(2015, 12, 1));
        employee3 = new Employee("Ana Silva", new Seller(), LocalDate.of(2021, 12, 1));
        employee4 = new Employee("João Mendes", new Seller(), LocalDate.of(2021, 12, 1));
        employee5 = new Employee("Juliana Alves", new Manager(), LocalDate.of(2017, 7, 1));
        employee6 = new Employee("Bento Albino", new Manager(), LocalDate.of(2014, 3, 1));

        Sale sale1 = new Sale(employee3, 5200.0, LocalDate.of(2021, 12, 3));
        Sale sale2 = new Sale(employee3, 4000.0, LocalDate.of(2022, 1, 1));
        Sale sale3 = new Sale(employee3, 4200.0, LocalDate.of(2022, 2, 1));
        Sale sale4 = new Sale(employee3, 5850.0, LocalDate.of(2022, 3, 1));
        Sale sale5 = new Sale(employee3, 7000.0, LocalDate.of(2022, 4, 1));
        Sale sale6 = new Sale(employee4, 3400.0, LocalDate.of(2021, 12, 1));
        Sale sale7 = new Sale(employee4, 7700.0, LocalDate.of(2022, 1, 1));
        Sale sale8 = new Sale(employee4, 5000.0, LocalDate.of(2022, 2, 1));
        Sale sale9 = new Sale(employee4, 5900.0, LocalDate.of(2022, 3, 1));
        Sale sale10 = new Sale(employee4, 6500.0, LocalDate.of(2022, 4, 1));

        employee3.makeSale(sale1);
        employee3.makeSale(sale2);
        employee3.makeSale(sale3);
        employee3.makeSale(sale4);
        employee3.makeSale(sale5);
        employee4.makeSale(sale6);
        employee4.makeSale(sale7);
        employee4.makeSale(sale8);
        employee4.makeSale(sale9);
        employee4.makeSale(sale10);

        employees = List.of(employee1, employee2, employee3, employee4, employee5, employee6);
    }

    @Test
    void calculateTotalSalaryForMonth() {
        assertEquals(124000.0, SinerjiCalculator.calculateTotalSalaryForMonth(employees, 2022, 4));
    }

    @Test
    void calculateTotalBenefitsForMonth(){
        assertEquals(8850.0, SinerjiCalculator.calculateTotalBenefitsForMonth(employees, 2022, 4));
    }

    @Test
    void calculateTotalPaymentForMonthToEmployeesWithBenefitsError(){
        assertThrows(ValidationException.class, ()-> SinerjiCalculator.calculateTotalPaymentForMonthToEmployeesWithBenefits(employees, 2022, 4));
    }

    @Test
    void calculateTotalPaymentForMonthToEmployeesWithBenefitsSuccess(){
        List<Employee> onlyEmployeesWithBenefits = List.of(employee1, employee2, employee3);

        assertEquals(42900.0, SinerjiCalculator.calculateTotalPaymentForMonthToEmployeesWithBenefits(onlyEmployeesWithBenefits, 2022, 4));
    }

    @Test
    void findHighestPaidEmployee(){
        assertEquals("Bento Albino", SinerjiCalculator.findHighestPaidEmployee(employees, 2022, 4).getName());
    }

    @Test
    void findHighestPaidEmployeeWithBenefitsError(){
        assertThrows(ValidationException.class, ()-> SinerjiCalculator.findHighestPaidEmployeeWithBenefits(employees, 2022, 4));
    }

    @Test
    void findHighestPaidEmployeeWithBenefitsSuccess(){
        List<Employee> onlyEmployeesWithBenefits = List.of(employee1, employee2, employee3);

        assertEquals("Maria Souza", SinerjiCalculator.findHighestPaidEmployeeWithBenefits(onlyEmployeesWithBenefits, 2022, 4).getName());
    }

    @Test
    void findTopSellerByMonthError(){
        assertThrows(ValidationException.class, ()-> SinerjiCalculator.findTopSellerByMonth(employees, 2022, 4));
    }

    @Test
    void findTopSellerByMonthSuccess(){
        List<Employee> sellers = List.of(employee3, employee4);

        assertEquals("Ana Silva", SinerjiCalculator.findTopSellerByMonth(sellers, 2022, 4).getName());
        assertEquals("João Mendes", SinerjiCalculator.findTopSellerByMonth(sellers, 2022, 3).getName());
        assertEquals("João Mendes", SinerjiCalculator.findTopSellerByMonth(sellers, 2022, 2).getName());
        assertEquals("João Mendes", SinerjiCalculator.findTopSellerByMonth(sellers, 2022, 1).getName());
        assertEquals("Ana Silva", SinerjiCalculator.findTopSellerByMonth(sellers, 2021, 12).getName());
    }






}