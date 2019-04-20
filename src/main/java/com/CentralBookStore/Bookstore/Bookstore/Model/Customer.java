package com.CentralBookStore.Bookstore.Bookstore.Model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(nullable = false, length=100)
    private String name;
    @NotNull
    @Email
    @Column(nullable = false, length=50)
    private String email;
    @NotNull
    @Column(nullable = false, length=50)
    private String password;
    @OneToMany
    private List<CustomerBook> customerBooks;
}

