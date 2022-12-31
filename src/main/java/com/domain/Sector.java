package com.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "taxarea")
public class Sector {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Column(name = "bsal")
    private double bsal;

    @NotNull
    @Column(name = "hRent")
    private double hRent;

    @NotNull
    @Column(name = "medical")
    private double medical;

    @NotNull
    @Column(name = "conv")
    private double conv;

    @NotNull
    @Column(name = "bonus")
    private double bonus;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getBsal() {
        return bsal;
    }

    public void setBsal(double bsal) {
        this.bsal = bsal;
    }

    public double gethRent() {
        return hRent;
    }

    public void sethRent(double hRent) {
        this.hRent = hRent;
    }

    public double getMedical() {
        return medical;
    }

    public void setMedical(double medical) {
        this.medical = medical;
    }

    public double getConv() {
        return conv;
    }

    public void setConv(double conv) {
        this.conv = conv;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @NotNull
    @Column(name = "category")
    private String category;
}
