package com.sap.training.models;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "USER")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    @NotNull
    private int id;

    @Column(name = "NAME")
    @NotBlank
    private String name;

    @Column(name = "EMAIL")
    @NotBlank
    private String email;

    @Size(min = 6, message = "At least 6 caracters needed")
    @Column(name = "PASS")
    private String password;

    @Size(min = 6, message = "At least 6 caracters needed")
    @Column(name = "PASS_CONFIRM")
    private String passwordConfirm;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column(name = "DOB")
    private String dateOfBirth;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordConfirm() {
        return this.passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    public String getDateOfBirth() {
        return this.dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
