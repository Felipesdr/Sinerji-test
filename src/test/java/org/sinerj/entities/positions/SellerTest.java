package org.sinerj.entities.positions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.sinerj.entities.employee.Employee;
import org.sinerj.entities.sale.Sale;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class SellerTest {
    private Seller seller;
    private Employee employee1;
    private Employee employee2;

    private Sale sale1;
    private Sale sale2;
    private Sale sale3;
    private Sale sale4;
    private Sale sale5;

    @BeforeEach
    void setUp(){
        seller = new Seller();
        employee1 = new Employee("Ana Silva", new Seller(), LocalDate.of(2021, 12, 01));
        employee2 = new Employee("João Mendes", new Seller(), LocalDate.of(2021, 12, 1));

        sale1 = new Sale(employee1, 5200.0, LocalDate.of(2021, 12, 3));
        sale2 = new Sale(employee1, 4000.0, LocalDate.of(2022, 1, 1));
        sale3 = new Sale(employee1, 4200.0, LocalDate.of(2022, 2, 1));
        sale4 = new Sale(employee1, 5850.0, LocalDate.of(2022, 3, 1));
        sale5 = new Sale(employee1, 7000.0, LocalDate.of(2022, 4, 1));

        employee1.makeSale(sale1);
        employee1.makeSale(sale2);
        employee1.makeSale(sale3);
        employee1.makeSale(sale4);
        employee1.makeSale(sale5);
    }
    @Test
    void calculateSalary() {
        assertEquals(12000.0, employee1.calculateSalary(2022, 4));
        assertEquals(12000.0, employee2.calculateSalary(2022, 4));

        assertEquals(13800.0, employee1.calculateSalary(2023, 4));
        assertEquals(15600.0, employee2.calculateSalary(2024, 4));
    }

    @Test
    void calculateBenefits() {
        assertEquals(2100.0, employee1.calculateBenefits(2022, 4));

        assertEquals(1755.0, employee1.calculateBenefits(2022, 3));
    }
}