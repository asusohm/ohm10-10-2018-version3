package sut.sa.g15.entity;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;


@Entity
public class Country {
    @Id
    @Column(name = "COUNTRY_CODE")
    private @NonNull
    String countryCode;
    private @NonNull
    String countryName;

    @ManyToOne
    @JoinColumn(name = "CURRENCY_CODE", nullable = false)
    private Currency currency;

    public Country() {
    }

    public Country(String countryCode, String countryName, Currency currency) {
        this.countryCode = countryCode;
        this.countryName = countryName;
        this.currency = currency;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }
}
