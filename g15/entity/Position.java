package sut.sa.g15.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter

public class Position {
    @Id
    @SequenceGenerator(name = "position_seq",sequenceName = "position_seq" )
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "position_seq")
    @Column(name = "POSITION_ID")
    private @NonNull
    Long positionID;
    private @NonNull
    String positionName;
    private @NonNull
    String positionSymbol;

    public Position() {
    }

    public Position(String positionName, String positionSymbol) {
        this.positionName = positionName;
        this.positionSymbol = positionSymbol;
    }
}
