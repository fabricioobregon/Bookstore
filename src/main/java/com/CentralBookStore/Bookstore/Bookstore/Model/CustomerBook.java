package com.CentralBookStore.Bookstore.Bookstore.Model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Inheritance(strategy = InheritanceType.JOINED) //Table inherited from Book
public class CustomerBook extends Book{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customerbook_generator")
    @SequenceGenerator(name = "customerbook_generator", sequenceName = "customerbook_sequence", allocationSize = 1)
    private Long id;
    @NonNull
    private int lastPage=0;
    @Temporal( TemporalType.TIMESTAMP )
    @CreationTimestamp
    private Date lastTimeModified;
    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name="customer_id")
//    @JsonIgnore
    private Customer customer;

    @Temporal(TemporalType.TIMESTAMP)
    private Date startTime;

    public CustomerBook(){
        super();
    }
}

