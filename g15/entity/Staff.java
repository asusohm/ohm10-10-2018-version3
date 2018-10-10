package sut.sa.g15.entity;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;


@Entity
public class Staff {
    @Id
    @Column(name = "PERSONAL_USER")
    private @NonNull
    String personalUser;
    private @NonNull
    String personalPass;
    private @NonNull
    String personalName;

    @ManyToOne
    @JoinColumn(name = "POSITION_ID", nullable = false)
    private Position position;

    @ManyToOne
    @JoinColumn(name = "SERVICE_CENTER_ID",nullable = false)
    private ServiceCenter serviceCenter;

    public Staff() {
    }

    public Staff(String personalUser, String personalPass, String personalName, Position position, ServiceCenter serviceCenter) {
        this.personalUser = personalUser;
        this.personalPass = personalPass;
        this.personalName = personalName;
        this.position = position;
        this.serviceCenter = serviceCenter;
    }

    public String getPersonalUser() {
        return personalUser;
    }

    public void setPersonalUser(String personalUser) {
        this.personalUser = personalUser;
    }

    public String getPersonalPass() {
        return personalPass;
    }

    public void setPersonalPass(String personalPass) {
        this.personalPass = personalPass;
    }

    public String getPersonalName() {
        return personalName;
    }

    public void setPersonalName(String personalName) {
        this.personalName = personalName;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public ServiceCenter getServiceCenter() {
        return serviceCenter;
    }

    public void setServiceCenter(ServiceCenter serviceCenter) {
        this.serviceCenter = serviceCenter;
    }
}
