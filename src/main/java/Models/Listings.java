package Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.sql.Date;

@Entity
@Table(name = "listings")
public class Listings {
    private int id;
    private double price;
    private Date placementDate;
    private Date expirationDate;
    private int carId;

    public Listings(String s) {
    }

    public Listings() {

    }

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "price")
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Column(name = "placementDate")
    public Date getPlacementDate() {
        return placementDate;
    }

    public void setPlacementDate(Date placementDate) {
        this.placementDate = placementDate;
    }

    @Column(name = "expirationDate")
    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    @Column(name = "carId")
    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Listings that = (Listings) o;

        if (id != that.id) return false;
//        if (price != null ? !price.equals(that.price) : that.price != null) return false;
        if (placementDate != null ? !placementDate.equals(that.placementDate) : that.placementDate != null)
            return false;
        if (expirationDate != null ? !expirationDate.equals(that.expirationDate) : that.expirationDate != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
//        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (placementDate != null ? placementDate.hashCode() : 0);
        result = 31 * result + (expirationDate != null ? expirationDate.hashCode() : 0);
        return result;
    }
}
