package com.example.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Bet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double cote;

    public Bet() {
    }

    public Bet(Long id, String name, Double cote) {
        this.id = id;
        this.name = name;
        this.cote = cote;
    }

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

    public Double getCote() {
        return cote;
    }

    public void setCote(Double cote) {
        this.cote = cote;
    }
}
