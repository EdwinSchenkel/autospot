package Models;

import javax.persistence.Embeddable;

@Embeddable
public class Address {
    private String address;
    private String zipcode;
    private String city;
    private String country;

    public Address() {

    }

    public Address(String adres, String postcode, String stad, String land) {
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

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
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
