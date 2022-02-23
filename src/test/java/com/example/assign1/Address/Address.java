package com.example.assign1.Address;

import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity
public class Address {
    private String email;
    private String name;
    private String address;
    private String zipCode;
    private String district;
    private String tel;
}
