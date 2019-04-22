package com.CentralBookStore.Bookstore.Bookstore.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED) //Table inherited from Book
public class CustomerBook extends Book{

//    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customerbook_generator")
//    @SequenceGenerator(name = "customerbook_generator", sequenceName = "customerbook_sequence", allocationSize = 1)
//    private Long id;
    @NonNull
    private int lastPage;
    @Temporal( TemporalType.TIMESTAMP )
    @CreationTimestamp
    private Date lastTimeModified;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="customer_id")
    private Customer customer;
    @Temporal(TemporalType.TIMESTAMP)
    private Date startTime;

    public CustomerBook(String title, String description, String imageUrl, String isbn, String edition, String year, Set<Author> authors, int lastPage, Customer customer) {
        this.title = title;
        this.description = description;
        this.imageUrl = imageUrl;
        this.isbn = isbn;
        this.edition = edition;
        this.year = year;
        this.authors = authors;
        this.lastPage = 0;
        this.customer = customer;
        this.lastTimeModified = new Timestamp(new Date().getTime());
        this.startTime = new Timestamp(new Date().getTime());

    }

    public void setLastPage(int lastPage) {
        this.lastPage = lastPage;
        this.lastTimeModified = new Timestamp(new Date().getTime());
    }


}

