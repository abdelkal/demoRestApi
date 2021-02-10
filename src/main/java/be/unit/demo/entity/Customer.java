package be.unit.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Customer {

    @Id
    private int id;

    private String firtsName;

    private String lastName;

    private Date birthDate;

    public Customer() {
    }

    public Customer(int id, String firtsName, String lastName, Date birthDate) {
        this.id = id;
        this.firtsName = firtsName;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirtsName() {
        return firtsName;
    }

    public void setFirtsName(String firtsName) {
        this.firtsName = firtsName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
}
