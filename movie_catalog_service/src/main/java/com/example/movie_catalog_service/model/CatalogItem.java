package com.example.movie_catalog_service.model;

public class CatalogItem {

    private String name;
    private String desc;
    private int rate;

    public CatalogItem(String name, String desc, int rate) {
        this.name = name;
        this.desc = desc;
        this.rate = rate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }
}
