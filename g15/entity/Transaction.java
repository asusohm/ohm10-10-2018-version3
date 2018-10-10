package sut.sa.g15.entity;


import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Transaction {
    @Id
    @SequenceGenerator(name = "transaction_seq",sequenceName = "transaction_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "transaction_seq")
    @Column(name = "TRANSACTION_ID")
    private @NonNull
    Long transactionID;

    @Temporal(TemporalType.TIMESTAMP)
    private @NonNull
    Date transactionDate;


    @ManyToOne
    @JoinColumn(name = "DEPOSIT_ID", nullable = false)
    private Deposit deposit;


    @ManyToOne
    @JoinColumn(name = "WITHDRAW_ID", nullable = false)
    private Withdraw withdraw;

    @ManyToOne
    @JoinColumn(name = "CURRENCY_CODE", nullable = false)
    private Currency currency;

    @ManyToOne
    @JoinColumn(name = "PERSONAL_USER", nullable = false)
    private Staff staff;

    @ManyToOne
    @JoinColumn(name = "SERVICE_CENTER_ID", nullable = false)
    private ServiceCenter serviceCenter;

    @ManyToOne
    @JoinColumn(name = "BALANCE_ID", nullable = false)
    private Balance balance;


    public Transaction() {
    }

    public Transaction(Date transactionDate, Deposit deposit, Withdraw withdraw, Currency currency, Staff staff, ServiceCenter serviceCenter, Balance balance) {
        this.transactionDate = transactionDate;
        this.deposit = deposit;
        this.withdraw = withdraw;
        this.currency = currency;
        this.staff = staff;
        this.serviceCenter = serviceCenter;
        this.balance = balance;
    }

    public Long getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(Long transactionID) {
        this.transactionID = transactionID;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public Deposit getDeposit() {
        return deposit;
    }

    public void setDeposit(Deposit deposit) {
        this.deposit = deposit;
    }

    public Withdraw getWithdraw() {
        return withdraw;
    }

    public void setWithdraw(Withdraw withdraw) {
        this.withdraw = withdraw;
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

    public ServiceCenter getServiceCenter() {
        return serviceCenter;
    }

    public void setServiceCenter(ServiceCenter serviceCenter) {
        this.serviceCenter = serviceCenter;
    }

    public Balance getBalance() {
        return balance;
    }

    public void setBalance(Balance balance) {
        this.balance = balance;
    }
}