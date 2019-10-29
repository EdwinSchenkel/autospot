package Models;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "cars", schema = "autospot", catalog = "")
public class Cars {
    private int id;
    private String brand;
    private String type;
    private String color;
    private String varnish;
    private Date buildYear;
    private Date lastCheckup;
    private int gearAmount;
    private BigDecimal engineCapacity;
    private int cylinders;
    private BigDecimal emptyWeight;
    private String drive;
    private int doorAmount;
    private String consumption;
    private String fuelType;
    private int mileage;
    private String options;
    private int customerId;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "brand")
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Column(name = "color")
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Column(name = "varnish")
    public String getVarnish() {
        return varnish;
    }

    public void setVarnish(String varnish) {
        this.varnish = varnish;
    }

    @Column(name = "buildYear")
    public Date getBuildYear() {
        return buildYear;
    }

    public void setBuildYear(Date buildYear) {
        this.buildYear = buildYear;
    }

    @Column(name = "lastCheckup")
    public Date getLastCheckup() {
        return lastCheckup;
    }

    public void setLastCheckup(Date lastCheckup) {
        this.lastCheckup = lastCheckup;
    }

    @Column(name = "gearAmount")
    public int getGearAmount() {
        return gearAmount;
    }

    public void setGearAmount(int gearAmount) {
        this.gearAmount = gearAmount;
    }

    @Column(name = "engineCapacity")
    public BigDecimal getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(BigDecimal engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    @Column(name = "cylinders")
    public int getCylinders() {
        return cylinders;
    }

    public void setCylinders(int cylinders) {
        this.cylinders = cylinders;
    }

    @Column(name = "emptyWeight")
    public BigDecimal getEmptyWeight() {
        return emptyWeight;
    }

    public void setEmptyWeight(BigDecimal emptyWeight) {
        this.emptyWeight = emptyWeight;
    }

    @Column(name = "drive")
    public String getDrive() {
        return drive;
    }

    public void setDrive(String drive) {
        this.drive = drive;
    }

    @Column(name = "doorAmount")
    public int getDoorAmount() {
        return doorAmount;
    }

    public void setDoorAmount(int doorAmount) {
        this.doorAmount = doorAmount;
    }

    @Column(name = "consumption")
    public String getConsumption() {
        return consumption;
    }

    public void setConsumption(String consumption) {
        this.consumption = consumption;
    }

    @Column(name = "fuelType")
    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    @Column(name = "mileage")
    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    @Column(name = "options")
    public String getOptions() {
        return options;
    }

    public void setOptions(String options) {
        this.options = options;
    }

    @Column(name = "customerId")
    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int CustomerId) {
        this.customerId = CustomerId;
    }

    @OneToMany(mappedBy = "cars", cascade=CascadeType.ALL)
    private Set<Listings> listings;

    public Set<Listings> listings() {
        return this.listings;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cars that = (Cars) o;

        if (id != that.id) return false;
        if (gearAmount != that.gearAmount) return false;
        if (cylinders != that.cylinders) return false;
        if (doorAmount != that.doorAmount) return false;
        if (mileage != that.mileage) return false;
        if (brand != null ? !brand.equals(that.brand) : that.brand != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (color != null ? !color.equals(that.color) : that.color != null) return false;
        if (varnish != null ? !varnish.equals(that.varnish) : that.varnish != null) return false;
        if (buildYear != null ? !buildYear.equals(that.buildYear) : that.buildYear != null) return false;
        if (lastCheckup != null ? !lastCheckup.equals(that.lastCheckup) : that.lastCheckup != null) return false;
        if (engineCapacity != null ? !engineCapacity.equals(that.engineCapacity) : that.engineCapacity != null)
            return false;
        if (emptyWeight != null ? !emptyWeight.equals(that.emptyWeight) : that.emptyWeight != null) return false;
        if (drive != null ? !drive.equals(that.drive) : that.drive != null) return false;
        if (consumption != null ? !consumption.equals(that.consumption) : that.consumption != null) return false;
        if (fuelType != null ? !fuelType.equals(that.fuelType) : that.fuelType != null) return false;
        if (options != null ? !options.equals(that.options) : that.options != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (brand != null ? brand.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (color != null ? color.hashCode() : 0);
        result = 31 * result + (varnish != null ? varnish.hashCode() : 0);
        result = 31 * result + (buildYear != null ? buildYear.hashCode() : 0);
        result = 31 * result + (lastCheckup != null ? lastCheckup.hashCode() : 0);
        result = 31 * result + gearAmount;
        result = 31 * result + (engineCapacity != null ? engineCapacity.hashCode() : 0);
        result = 31 * result + cylinders;
        result = 31 * result + (emptyWeight != null ? emptyWeight.hashCode() : 0);
        result = 31 * result + (drive != null ? drive.hashCode() : 0);
        result = 31 * result + doorAmount;
        result = 31 * result + (consumption != null ? consumption.hashCode() : 0);
        result = 31 * result + (fuelType != null ? fuelType.hashCode() : 0);
        result = 31 * result + mileage;
        result = 31 * result + (options != null ? options.hashCode() : 0);
        return result;
    }
}
