package test.springweb.entity;

import javax.persistence.*;

@Entity
@Table(name = "order")
public class order {
    @Id
    private int id2;

    @ManyToOne
    @JoinColumn(name = "CustomerID")
    private customer customer;
    private int id;

}
