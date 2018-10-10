package sut.sa.g15.entity;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class Gender {
    @Id
    @SequenceGenerator(name = "gender_seq",sequenceName = "gender_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "gender_seq")
    @Column(name = "GENDER_ID")
    private @NonNull Long genderID;

    private @NonNull String genderType;

    public Gender() {
    }

    public Gender(String genderType) {
        this.genderType = genderType;
    }
}
