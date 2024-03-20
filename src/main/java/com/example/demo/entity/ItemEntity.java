package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name="Item")
public class ItemEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Column(name="ITEM_NAME", length=50, nullable=false, unique=false)
    private String name;

    @Column(name="ITEM_WEIGHT", nullable=false, unique=false)
    private double weight;
    
    @Column(name="ITEM_PRICE", nullable=false, unique=false)
    private double price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}