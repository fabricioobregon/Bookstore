package com.CentralBookStore.Bookstore.Bookstore.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;


import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

import javax.validation.constraints.NotNull;
import java.util.*;

@Entity
@Data
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@Table(uniqueConstraints={  //Those need to be table fields, not model attributes
        @UniqueConstraint(columnNames = {"isbn", "customer_id"})},
        indexes = {@Index(name = "customer_index",  columnList="customer_id")} //For joint indexes add fields in columnList separated by comma
)
public class Book{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_generator")
    @SequenceGenerator(name = "book_generator", sequenceName = "book_sequence", allocationSize = 1)
    private Long id;
    @NonNull
    @Column(nullable = false, length = 100)
    public String title;
    @Column(nullable = true, length = 2000)
    public String description;
    @Column(nullable = true, length = 250)
    public String imageUrl;
    @Column(nullable = false, length = 13)
    public String isbn;
    @Column(nullable = true, length = 100) //100
    public String category;
    @Column(nullable = true, length = 100) //50
    public String publisher;
    @Column(nullable = true, length = 4) //4
    public String year;
    @Column(nullable = true, length = 4) //4
    public String pageCount;
    @Column(nullable = true, length = 4) //4
    public String lastPage;
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdate;
    //@JsonManagedReference //incompatible with  BookDTO Type
    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "book_author", joinColumns = @JoinColumn(name = "book_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "author_id", referencedColumnName = "id"))
    public Set<Author>  authors = new HashSet<>();
    @ManyToOne
    @NotNull
    @JsonIgnore
    private Customer customer;


    public Book(String title, String description, String imageUrl, String isbn, String category,String publisher,
                String year,String pageCount, String lastPage ,Set<Author>  authors, Customer customer){
        this.title = title;
        this.description = description;
        this.imageUrl = imageUrl;
        this.isbn = isbn;
        this.category = category;
        this.publisher = publisher;
        this.year = year;
        this.pageCount = pageCount;
        this.lastPage = lastPage;
        this.authors = authors;
        this.customer = customer;
    }

        public void setLastPage(String lastPage) {
        this.lastPage = lastPage;
        this.lastUpdate = new Timestamp(new Date().getTime());
    }

}

