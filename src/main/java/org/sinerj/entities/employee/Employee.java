package org.sinerj.entities.employee;

import org.sinerj.entities.positions.Position;
import org.sinerj.entities.sale.Sale;
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
        this.salary = position.calculateSalary(this, LocalDate.now().getYear(), LocalDate.now().getMonthValue());
        this.benefits = position.calculateBenefits(this, LocalDate.now().getYear(), LocalDate.now().getMonthValue());
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

    public Double calculateSalary(Integer year, Integer month){
        return position.calculateSalary(this, year, month);
    }

    public Double calculateBenefits(Integer year, Integer month){
        return position.calculateBenefits(this, year, month);
    }

    public List<Sale> getSaleList() {
        if(position.getClass() == Seller.class) return saleList;
        return null;
    }
    public void makeSale(Sale sale){
        if(position.getClass() == Seller.class) saleList.add(sale);
    }
}
