package com.codegym.model;

public class Product {
    private int id;
    private String name;
    private float price;
    private String description;
    private String producer;

    public Product() {
    }

    public Product(int id, String name, String description, String producer) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.producer = producer;
    }

    public Product(int id, String name, float price, String description, String producer) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.producer = producer;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }
}
