package sut.sa.g15.entity;

import lombok.NonNull;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Withdraw implements Serializable {

    @Id
    @SequenceGenerator(name = "withdraw_seq",sequenceName = "withdraw_seq")
    @Column(name = "WITHDRAW_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "withdraw_seq")
    private @NonNull
    Long withdrawID;
    private @NonNull
    Double withdrawAmount;


    public Withdraw() {
    }

    public Withdraw(double withdrawAmount) {
        this.withdrawAmount = withdrawAmount;
    }

    public Long getWithdrawID() {
        return withdrawID;
    }

    public void setWithdrawID(Long withdrawID) {
        this.withdrawID = withdrawID;
    }

    public double getWithdrawAmount() {
        return withdrawAmount;
    }

    public void setWithdrawAmount(Double withdrawAmount) {
        this.withdrawAmount = withdrawAmount;
    }
}
