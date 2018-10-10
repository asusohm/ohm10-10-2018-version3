package sut.sa.g15.entity;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class ReceiptCurrency {
    @Id
    @SequenceGenerator(name = "receipt_currency_seq",sequenceName = "receipt_currency_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "receipt_currency_seq")
    @Column(name = "JOIN_ID")
    private @NonNull Long joinID;
    private @NonNull Double amount;

    @ManyToOne
    @JoinColumn(name = "CURRENCY_CODE")
    private @NonNull Currency currency;

    @ManyToOne
    @JoinColumn(name = "RECEINT_ID")
    private @NonNull Receipt receipt;

    @ManyToOne
    @JoinColumn(name = "TYPE_ID")
    private @NonNull CurrencyType currencyType;

    public ReceiptCurrency() {
    }

    public ReceiptCurrency(Double amount, Currency currency, Receipt receipt, CurrencyType currencyType) {
        this.amount = amount;
        this.currency = currency;
        this.receipt = receipt;
        this.currencyType = currencyType;
    }
}
