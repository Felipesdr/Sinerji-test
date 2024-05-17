package org.sinerj.entities.positions;

import java.time.LocalDate;

public class Sale {

    private Seller seller;
    private Double value;
    private LocalDate date;

    public Sale() {
    }

    public Sale(Seller seller, Double value, LocalDate date) {
        this.seller = seller;
        this.value = value;
        this.date = date;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
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
