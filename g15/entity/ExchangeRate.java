package sut.sa.g15.entity;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;
import java.util.Date;

@Entity
public class ExchangeRate {
    @Id
    @SequenceGenerator(name ="exchange_rate_seq",sequenceName = "exchange_rate_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "exchange_rate_seq")
    @Column(name = "EXCHANGE_RATE_ID")
    private @NonNull
    Long exchangeRateID;
    @Column(precision = 6, scale = 2)
    private @NonNull
    Double bankNotesSelling;
    @Column(precision = 6, scale = 2)
    private @NonNull
    Double bankNotesBuying;

    @Temporal(TemporalType.DATE)
    private @NonNull Date date;

    @ManyToOne
    @JoinColumn(name = "CURRENCY_CODE", nullable = false)
    private Currency currency;


    @ManyToOne
    @JoinColumn(name = "PERSONAL_USER", nullable = false)
    private Staff staff;

    public ExchangeRate() {
    }

    public ExchangeRate(Double bankNotesSelling, Double bankNotesBuying, Date date, Currency currency, Staff staff) {
        this.bankNotesSelling = bankNotesSelling;
        this.bankNotesBuying = bankNotesBuying;
        this.date = date;
        this.currency = currency;
        this.staff = staff;
    }

    public Long getExchangeRateID() {
        return exchangeRateID;
    }

    public void setExchangeRateID(Long exchangeRateID) {
        this.exchangeRateID = exchangeRateID;
    }

    public Double getBankNotesSelling() {
        return bankNotesSelling;
    }

    public void setBankNotesSelling(Double bankNotesSelling) {
        this.bankNotesSelling = bankNotesSelling;
    }

    public Double getBankNotesBuying() {
        return bankNotesBuying;
    }

    public void setBankNotesBuying(Double bankNotesBuying) {
        this.bankNotesBuying = bankNotesBuying;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }
}
