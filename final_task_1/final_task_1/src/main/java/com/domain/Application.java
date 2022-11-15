package com.domain;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "application")
public class Application {
    @Id
    @Column(name = "id_of_leave")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_of_employee")
    private Employee id_of_employee;

    private LocalDate fromdate;
    private LocalDate toDate;
    private int totalDays;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Employee getId_of_employee() {
        return id_of_employee;
    }

    public void setId_of_employee(Employee id_of_employee) {
        this.id_of_employee = id_of_employee;
    }

    public LocalDate getFromdate() {
        return fromdate;
    }

    public void setFromdate(LocalDate fromdate) {
        this.fromdate = fromdate;
    }

    public LocalDate getToDate() {
        return toDate;
    }

    public void setToDate(LocalDate toDate) {
        this.toDate = toDate;
    }

    public int getTotalDays() {
        return totalDays;
    }

    public void setTotalDays(int totalDays) {
        this.totalDays = totalDays;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    private String reason;
}
