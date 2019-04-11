package com.CentralBookStore.Bookstore.Bookstore.Model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

@Entity
public class Order {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    Customer customer;
    private Set<BookItem> booksItems;
    private BigDecimal pst;
    private BigDecimal gst;
    private BigDecimal total;
    private ORDER_STATUS status;
    private PAYMENT_METHOD payment;
    private Date orderDate;


}

