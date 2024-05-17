package org.sinerj.entities.positions;

import org.sinerj.entities.employee.Employee;

import java.time.LocalDate;

public class Sale {

    private Employee seller;
    private Double value;
    private LocalDate date;

    public Sale() {
    }

    public Sale(Employee seller, Double value, LocalDate date) {
        this.seller = seller;
        this.value = value;
        this.date = date;
    }

    public Employee getSeller() {
        return seller;
    }

    public void setSeller(Employee seller) {
        this.seller = seller;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
