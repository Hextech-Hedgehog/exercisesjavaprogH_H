package be.abis.acc.model;

public class Address {

    private String street;
    private String number;
    private String zipcode;
    private String town;
    private String country;
    private String countryCode;

    public Address(String street, String number, String zipcode, String town, String country, String countryCode) {
        this.street = street;
        this.number = number;
        this.zipcode = zipcode;
        this.town = town;
        this.country = country;
        this.countryCode = countryCode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public void printInfo() {
        System.out.println(this.street + " " + this.number + " " + this.zipcode + " " + this.town + " " + this.country);
    }
}
