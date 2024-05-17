package org.sinerj.principal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.sinerj.entities.employee.Employee;
import org.sinerj.entities.positions.Manager;
import org.sinerj.entities.positions.Secretary;
import org.sinerj.entities.positions.Seller;
import org.sinerj.entities.sale.Sale;

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

    private Sale sale1;
    private Sale sale2;
    private Sale sale3;
    private Sale sale4;
    private Sale sale5;
    private Sale sale6;
    private Sale sale7;
    private Sale sale8;
    private Sale sale9;
    private Sale sale10;

    List<Employee> employees = new ArrayList<>();

    @BeforeEach
    void setUp(){
        employee1 = new Employee("Jorge Carvalho", new Secretary(), LocalDate.of(2018, 1, 1));
        employee2 = new Employee("Maria Souza", new Secretary(), LocalDate.of(2015, 12, 1));
        employee3 = new Employee("Ana Silva", new Seller(), LocalDate.of(2021, 12, 1));
        employee4 = new Employee("João Mendes", new Seller(), LocalDate.of(2021, 12, 1));
        employee5 = new Employee("Juliana Alves", new Manager(), LocalDate.of(2017, 7, 1));
        employee6 = new Employee("Ana Silva", new Manager(), LocalDate.of(2014, 3, 1));

        sale1 = new Sale(employee3, 5200.0, LocalDate.of(2021, 12, 3));
        sale2 = new Sale(employee3, 4000.0, LocalDate.of(2022, 1, 1));
        sale3 = new Sale(employee3, 4200.0, LocalDate.of(2022, 2, 1));
        sale4 = new Sale(employee3, 5850.0, LocalDate.of(2022, 3, 1));
        sale5 = new Sale(employee3, 7000.0, LocalDate.of(2022, 4, 1));
        sale6 = new Sale(employee4, 3400.0, LocalDate.of(2021, 12, 1));
        sale7 = new Sale(employee4, 7700.0, LocalDate.of(2021, 1, 1));
        sale8 = new Sale(employee4, 5000.0, LocalDate.of(2022, 2, 1));
        sale9 = new Sale(employee4, 5900.0, LocalDate.of(2022, 3, 1));
        sale10 = new Sale(employee4, 6500.0, LocalDate.of(2022, 4, 1));

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
}