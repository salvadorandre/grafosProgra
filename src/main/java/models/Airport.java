package models;

public class Airport {
    public String code;
    public String city;
    public String country;

    public Airport(String code, String city, String country) {
        this.code = code;
        this.city = city;
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Airport)) return false;
        Airport other = (Airport) o;
        return this.code.equals(other.code);
    }

    @Override
    public int hashCode() {
        return code.hashCode();
    }

    @Override
    public String toString() {
        return code + " (" + city + ", " + country + ")";
    }
}