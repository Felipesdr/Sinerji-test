package org.sinerj.entities.positions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.sinerj.entities.employee.Employee;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ManagerTest {
    private Employee employee1;
    private Employee employee2;
    @BeforeEach
    void setUp() {
        employee1 = new Employee("Juliana Alves", new Manager(), LocalDate.of(2017, 7, 1));
        employee2 = new Employee("Bento Albino", new Manager(), LocalDate.of(2014, 3, 1));
    }

    @Test
    void calculateSalary() {
        assertEquals(32000, employee1.calculateSalary(2022,4));
        assertEquals(44000, employee2.calculateSalary(2022,4));
//        assertEquals(50000, employee2.calculateSalary(2022,4));
    }

    @Test
    void calculateBenefits() {
        assertEquals(0, employee1.calculateBenefits(2024,5));
    }
}