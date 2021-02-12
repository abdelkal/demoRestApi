package be.unit.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Customer_Order")
public class Order {

    @Id
    private long id;

    private int trackingNumber;

    public Order() {
    }

    public Order(int id, int trackingNumber) {
        this.id = id;
        this.trackingNumber = trackingNumber;
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
}
