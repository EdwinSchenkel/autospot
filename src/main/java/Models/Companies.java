package Models;

import Interfaces.Address;

import javax.persistence.*;

@Entity
@Table(name = "companies")
public class Companies {
    private int id;
    private String name;
    private Address address;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public Address getAddress() { return address; }
    public void setAddress(Address address) { this.address = address; }
}
