package com.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "type")
public class LeaveType {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_of_leave")
    private Application id_of_leave;

    @ManyToOne
    @JoinColumn(name = "id_of_leave")
    private String category;

    public String getCategory() {
        return category.toString();
    }

    public int getTotaldays() {
        return totaldays;
    }

    public void setTotaldays(int totaldays) {
        this.totaldays = totaldays;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @NotNull
    @Column(name = "total_days")
    private int totaldays;

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }
}
