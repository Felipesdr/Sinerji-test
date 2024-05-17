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
    @BeforeEach
    void setUp(){
        seller = new Seller();
        employee1 = new Employee("Ana Silva", seller, LocalDate.of(2021, 12, 01));
        Sale sale1 = new Sale(employee1, 42000.0, LocalDate.of(2021, 12, 03));
        Sale sale2 = new Sale(employee1, 10000.0, LocalDate.of(2021, 12, 04));
        Sale sale3 = new Sale(employee1, 20000.0, LocalDate.of(2022, 1, 01));
        Sale sale4 = new Sale(employee1, 20000.0, LocalDate.of(2022, 01, 01));
        employee1.makeSale(sale1);
        employee1.makeSale(sale2);
        employee1.makeSale(sale3);
        employee1.makeSale(sale4);
    }
    @Test
    void calculateSalary() {
        assertEquals(12000.0, employee1.calculateSalary(2021, 12));
        assertEquals(13800.0, employee1.calculateSalary(2022, 12));
    }

    @Test
    void calculateBenefits() {
        assertEquals(15600.0, employee1.calculateBenefits(2021, 12));
        assertEquals(12000.0, employee1.calculateBenefits(2022, 01));
    }
}