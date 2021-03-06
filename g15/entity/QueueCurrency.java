package sut.sa.g15.entity;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
public class QueueCurrency implements Serializable {

    @Id
    @SequenceGenerator(name = "queue_curr_seq",sequenceName = "queue_curr_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "queue_curr_seq")
    @Column(name = "QUEUE_CURRENCY_ID")
    private @NonNull Long queueCurrencyID;


    @ManyToOne
    @JoinColumn(name ="QUEUE_ID")
    private Queue queue;


    @ManyToOne
    @JoinColumn(name = "CURRENCY_CODE")
    private  Currency currency;

    @ManyToOne
    @JoinColumn(name ="TYPE_ID")
    private  CurrencyType currencyType;

    public QueueCurrency() {
    }

    public QueueCurrency(Queue queue, Currency currency, CurrencyType currencyType) {
        this.queue = queue;
        this.currency = currency;
        this.currencyType = currencyType;
    }
}
