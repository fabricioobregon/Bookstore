package com.CentralBookStore.Bookstore.Bookstore.Model;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Inheritance(
        strategy = InheritanceType.JOINED
)
public class CustomerBook extends Book{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    private String lastPage;
    @Temporal( TemporalType.TIMESTAMP )
    private Date lastTimeModified;

    public CustomerBook(){
        super();
    }
}

