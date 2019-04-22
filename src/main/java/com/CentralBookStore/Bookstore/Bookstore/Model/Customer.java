package com.CentralBookStore.Bookstore.Bookstore.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
//@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @NotNull
    @Column(nullable = false, length=100)
    private String name;
    @NotNull
    @Column(nullable = false, unique=true, length=100)
    private String email;
    @NotNull
    @Column(nullable = false, length=50)
    private String password;
    @OneToMany(
            mappedBy = "customer",
            cascade = {CascadeType.PERSIST, CascadeType.MERGE},
            orphanRemoval = true)
    @JsonIgnore
    private Set<CustomerBook> customerBooks;

    public Customer(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public void setId(UUID uuid) {
        this.id = uuid;
    }
}