package sut.sa.g15.entity;

import lombok.NonNull;

import javax.persistence.*;

@Entity
public class Deposit {
    @Id
    @SequenceGenerator(name = "deposit_seq",sequenceName ="deposit_seq" )
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "deposit_seq")
    @Column(name = "DEPOSIT_ID")
    private @NonNull
    Long dopositID;
    private @NonNull
    Double depositAmount;

    public Deposit() {
    }

    public Deposit(double depositAmount) {
        this.depositAmount = depositAmount;
    }

    public Long getDopositID() {
        return dopositID;
    }

    public void setDopositID(Long dopositID) {
        this.dopositID = dopositID;
    }

    public double getDepositAmount() {
        return depositAmount;
    }

    public void setDepositAmount(double depositAmount) {
        this.depositAmount = depositAmount;
    }
}
