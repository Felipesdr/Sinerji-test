package org.sinerj.entities.employee;

import org.sinerj.entities.positions.Position;
import org.sinerj.entities.positions.Sale;
import org.sinerj.entities.positions.Seller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Employee {
    private String name;
    private Position position;
    private LocalDate hiringDate;
    private Double salary;
    private Double benefits;

    List<Sale> saleList = new ArrayList<>();

    public Employee() {
    }

    public Employee(String name, Position position, LocalDate hiringDate) {
        this.name = name;
        this.position = position;
        this.hiringDate = hiringDate;
        this.salary = position.calculateSalary(this, LocalDate.now());
        this.benefits = position.calculateBenefits(this, LocalDate.now());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public LocalDate getHiringDate() {
        return hiringDate;
    }

    public void setHiringDate(LocalDate hiringDate) {
        this.hiringDate = hiringDate;
    }

    public Double getSalary() {
        return salary;
    }

    public List<Sale> getSaleList() {
        if(position.getClass() == Seller.class) return saleList;
        return null;
    }
}
