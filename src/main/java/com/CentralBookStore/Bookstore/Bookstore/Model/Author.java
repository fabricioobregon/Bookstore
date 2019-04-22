package com.CentralBookStore.Bookstore.Bookstore.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.*;

@Entity
@Data
@NoArgsConstructor
public class Author{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "author_generator")
    @SequenceGenerator(name = "author_generator", sequenceName = "author_sequence", allocationSize = 1)
    private Long id;
    @Column(unique = true, length = 100)
    private String name;
    @Column(length = 100)
    private String description;
//    @JsonBackReference
//    Do not use mappedBy = "authors" with many to many
    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JsonIgnore
    private Set<Book> books = new HashSet<>();

    public Author(String name, String description) {
        this.name = name;
        this.description = description;
    }
}

