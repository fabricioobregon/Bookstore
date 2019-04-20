package com.CentralBookStore.Bookstore.Bookstore.Model;

import lombok.Data;
import lombok.NonNull;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Inheritance(strategy = InheritanceType.JOINED) //Table inherited from Book
public class CustomerBook extends Book{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    private String lastPage;
    @Temporal( TemporalType.TIMESTAMP )
    @CreationTimestamp
    private Date lastTimeModified;
    @ManyToOne
    private Customer customer;


    public CustomerBook(){
        super();
    }
}

