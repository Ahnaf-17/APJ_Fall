package com.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlEnum;
import java.time.LocalDate;


@Entity
    @Table(name = "employee")
    public class Employee {

        @Id
        @Column(name = "id_of_employee")
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @NotNull
        @Column(name = "first_name")
        private String firstname;

        @NotNull
        @Column(name = "last_name")
        private String lastname;

;       @NotNull
        @Column(name = "gender")
        private String gender;

        @NotNull
        @Column(name = "email")
        private String email;

        @XmlEnum
        enum EmployeeStatus{
            Active, Inactive
        }
        @XmlEnum
        enum Gender{
            MALE,FEMALE
        }

    public String getFirstname() {
        return firstname;
    }

    public LocalDate getJoiningdate() {
        return joiningdate;
    }

    public void setJoiningdate(LocalDate joiningdate) {
        this.joiningdate = joiningdate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public Long getId() {
        return id;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @NotNull
        @Column(name = "joining_date")
        private LocalDate joiningdate;


    }


