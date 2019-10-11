package Interfaces;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address {
    private String address;
    private String zipcode;
    private String city;
    private String country;

    public Address()
    {

    }

    public Address(String adres, String postcode, String stad, String land)
    {
        this.address = adres;
        this.zipcode = postcode;
        this.city = stad;
        this.country = land;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostalCode() {
        return zipcode;
    }

    public void setPostalCode(String postalCode) {
        this.zipcode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
