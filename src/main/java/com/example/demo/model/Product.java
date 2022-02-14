package com.example.demo.model;

import com.example.demo.constant.ProductState;

import javax.persistence.*;
import java.time.Instant;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private Double price;

    @Column
    private  String name;

    @Column
    private String image;

    @Column
    private Long created;

    @Column
    private ProductState state;

    @PrePersist
    private void init(){
        this.created = Instant.now().toEpochMilli();
        this.state = ProductState.ACTIVE;
    }

    public Product() {
    }

    public Product(Long id, Double price, String name, String image, Long created, ProductState state) {
        this.id = id;
        this.price = price;
        this.name = name;
        this.image = image;
        this.created = created;
        this.state = state;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Long getCreated() {
        return created;
    }

    public void setCreated(Long created) {
        this.created = created;
    }

    public ProductState getState() { return state; }

    public void setState(ProductState state) { this.state = state; }
}
