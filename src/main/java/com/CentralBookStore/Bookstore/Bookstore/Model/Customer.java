package com.CentralBookStore.Bookstore.Bookstore.Model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @NotNull
    @Column(nullable = false, length=100)
    private String name;
    @NotNull
    @Column(nullable = false, length=100)
    private String email;
    @NotNull
    @Column(nullable = false, length=50)
    private String password;
//    @OneToMany(fetch = FetchType.EAGER)
//    private List<CustomerBook> customerBooks;

    public Customer(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }
}