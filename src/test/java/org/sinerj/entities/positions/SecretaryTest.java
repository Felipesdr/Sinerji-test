package org.sinerj.entities.positions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.sinerj.entities.employee.Employee;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class SecretaryTest {
    private Employee employee1;
    private Employee employee2;
    @BeforeEach
    void setUp() {
        employee1 = new Employee("Jorge Carvalho", new Secretary(), LocalDate.of(2018, 1, 1));
        employee2 = new Employee("Marina Souza", new Secretary(), LocalDate.of(2015, 12, 1));
    }

    @Test
    void calculateSalary() {
        assertEquals(11000, employee1.calculateSalary(2022,4));
        assertEquals(13000, employee2.calculateSalary(2022,4));
    }

    @Test
    void calculateBenefits() {
        assertEquals(2200, employee1.calculateBenefits(2022,4));
        assertEquals(2600, employee1.calculateBenefits(2024,4));
//
    }
}