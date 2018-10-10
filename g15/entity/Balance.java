package sut.sa.g15.entity;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;

@Entity
public class Balance {

    @Id
    @SequenceGenerator(name = "balance_seq",sequenceName = "balance_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "balance_seq")
    @Column(name = "BALANCE_ID")
    private @NonNull Long balanceID;

    private @NonNull Double balanceAmount;

    @ManyToOne
    @JoinColumn(name = "SERVICE_CENTER_ID", nullable = false)
    private ServiceCenter serviceCenter;

    @ManyToOne
    @JoinColumn(name = "CURRENCY_ID", nullable = false)
    private Currency currency;

    public Balance() {
    }

    public Balance(Double balanceAmount, ServiceCenter serviceCenter, Currency currency) {
        this.balanceAmount = balanceAmount;
        this.serviceCenter = serviceCenter;
        this.currency = currency;
    }

    public Long getBalanceID() {
        return balanceID;
    }

    public void setBalanceID(Long balanceID) {
        this.balanceID = balanceID;
    }

    public Double getBalanceAmount() {
        return balanceAmount;
    }

    public void setBalanceAmount(Double balanceAmount) {
        this.balanceAmount = balanceAmount;
    }

    public ServiceCenter getServiceCenter() {
        return serviceCenter;
    }

    public void setServiceCenter(ServiceCenter serviceCenter) {
        this.serviceCenter = serviceCenter;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }
}
