package com.CentralBookStore.Bookstore.Bookstore.Model;

import lombok.*;

import javax.persistence.*;
import java.util.*;

@Entity
@Data
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class Book{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_generator")
    @SequenceGenerator(name = "book_generator", sequenceName = "book_sequence", allocationSize = 1)
    private Long id;
    @NonNull
    @Column(nullable = false, length = 100)
    public String title;
    @Column(nullable = true, length = 200)
    public String description;
    @Column(nullable = true, length = 250)
    public String imageUrl;
    @Column(nullable = false, unique = true)
    public String isbn;
    @Column(nullable = true, length = 3) //4
    public String edition;
    @Column(nullable = true, length = 4) //4
    public String year;
    //@JsonManagedReference //incompatible with  BookDTO Type
    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "book_author", joinColumns = @JoinColumn(name = "book_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "author_id", referencedColumnName = "id"))
    public Set<Author>  authors = new HashSet<>();


    public Book(String title, String description, String imageUrl, String isbn, String edition,
                String year, Set<Author>  authors){
        this.title = title;
        this.description = description;
        this.imageUrl = imageUrl;
        this.isbn = isbn;
        this.edition = edition;
        this.year = year;
        this.authors = authors;
    }
}

