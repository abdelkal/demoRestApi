package be.unit.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Customer_Order")
public class Order {

    @Id
    private long id;

    private int trackingNumber;

    private double totalPrice;

    @ManyToOne
    private Customer customer;

    public Order() {
    }

    public Order(int id, int trackingNumber, double totalPrice, Customer customer) {
        this.id = id;
        this.trackingNumber = trackingNumber;
        this.totalPrice = totalPrice;
        this.customer = customer;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getTrackingNumber() {
        return trackingNumber;
    }

    public void setTrackingNumber(int trackingNumber) {
        this.trackingNumber = trackingNumber;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
