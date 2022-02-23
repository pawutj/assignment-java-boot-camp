package com.example.assign1.Order.Address;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


@Data
public class Address {

    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String email;
    private String name;
    private String address;
    private String zipCode;
    private String district;
    private String tel;
}
