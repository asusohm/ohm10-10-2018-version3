package sut.sa.g15.entity;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter @Setter
public class Passport {
    @Id
    @Column(name = "PASSPORT_NUMBER")
    private @NonNull Long passportNumber;
    @Temporal(TemporalType.DATE)
    private @NonNull Date pass;

    @ManyToOne
    @JoinColumn(name = "USER_PROFILE_ID")
    private UserProfile userProfile;
    public Passport() {
    }

    public Passport(Long passportNumber, Date pass, UserProfile userProfile) {
        this.passportNumber = passportNumber;
        this.pass = pass;
        this.userProfile = userProfile;
    }
}
