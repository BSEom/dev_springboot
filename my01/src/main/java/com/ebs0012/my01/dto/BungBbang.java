package com.ebs0012.my01.dto;

import java.time.LocalDate;

public class BungBbang {

    private String flavor;
    private int price;
    private LocalDate since;

    public BungBbang(String flavor, int price, LocalDate since) {
        this.flavor = flavor;
        this.price = price;
        this.since = since;
    }

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public LocalDate getSince() {
        return since;
    }

    public void setSince(LocalDate since) {
        this.since = since;
    }

}
