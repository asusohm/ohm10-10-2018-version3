package sut.sa.g15.entity;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter

public class UserProfile {
    @Id
    @SequenceGenerator(name = "user_profile_seq",sequenceName = "user_profile_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "user_profile_seq")
    private @NonNull Long userProfileID;

    private @NonNull String name;
    private @NonNull String email;

    @ManyToOne
    @JoinColumn(name = "COUNTRY_CODE")
    private Country country;

    @ManyToOne
    @JoinColumn(name = "GENDER_ID")
    private Gender gender;

    @OneToOne
    private Members members;
    public UserProfile() {
    }

    public UserProfile(String name, String email, Country country, Gender gender, Members members) {
        this.name = name;
        this.email = email;
        this.country = country;
        this.gender = gender;
        this.members = members;
    }
}
