package com.ojieabujoel.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "branches")
@Getter
@Setter
public class Branch {

    public Branch(){
    }

    public Branch(String name, Long code, String address, String city, String email, long phone_number,
                  int head_office, int reg_off_flag, int swift_bicc) {
        this.name = name;
        this.code = code;
        this.address = address;
        this.city = city;
        this.email = email;
        this.phone_number = phone_number;
        this.head_office = head_office;
        this.reg_off_flag = reg_off_flag;
        this.swift_bicc = swift_bicc;
    }
    @Column(name = "NAME")
    private String name;
@Id
    @Column(name = "CODE")
    private Long code;
    @Column( name = "ADDRESS")
    private String address;
    @Column(name ="CITY")
    private String city;
    @Column (name = "EMAIL_ADDRESS")
    private String email;
    @Column(name = "PHONE_NUMBER")
    private long phone_number;
    @Column(name = "HEAD_OFFICE_FLAG")
    private int head_office;
    @Column(name = "REGIONAL_OFFICE_FLAG")
    private int reg_off_flag;
    @Column(name = "SWIFT_BICCODE")
    private int swift_bicc;

    @Override
    public String toString() {
        return "Branch{" + "name='" + name + '\'' + ", code=" + code + ", address='" + address + '\'' +
                ", city='" + city + '\'' + ", email='" + email + '\'' + ", phone_number=" + phone_number +
                ", head_office=" + head_office + ", reg_off_flag=" + reg_off_flag + ", swift_bicc="
                + swift_bicc +
                '}';
    }

}
