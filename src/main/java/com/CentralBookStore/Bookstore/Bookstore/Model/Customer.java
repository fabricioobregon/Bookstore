package com.CentralBookStore.Bookstore.Bookstore.Model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
public class Customer {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String password;
    private String address;


}

