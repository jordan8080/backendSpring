package com.example.demo.entities;

import jakarta.persistence.*;

@Entity
public class Bet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "cote1")
    private Double cote1;

    @Column(name = "cote2")
    private Double cote2;

    @Column(name = "cote3")
    private Double cote3;

    public Bet() {
    }

    public Bet(String name, Double cote1, Double cote2, Double cote3) {
        this.name = name;
        this.cote1 = cote1;
        this.cote2 = cote2;
        this.cote3 = cote3;
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

    public Double getCote1() {
        return cote1;
    }

    public void setCote1(Double cote1) {
        this.cote1 = cote1;
    }

    public Double getCote2() {
        return cote2;
    }

    public void setCote2(Double cote2) {
        this.cote2 = cote2;
    }

    public Double getCote3() {
        return cote3;
    }

    public void setCote3(Double cote3) {
        this.cote3 = cote3;
    }

    // toString()
    @Override
    public String toString() {
        return "Bet{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cote1=" + cote1 +
                ", cote2=" + cote2 +
                ", cote3=" + cote3 +
                '}';
    }
}
