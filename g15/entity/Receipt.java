package sut.sa.g15.entity;
import javax.persistence.*;
import lombok.*;

import java.sql.Time;
import java.util.*;

@Entity  //บอกว่าเป็น class entity class ที่เก็บขอมูล
//@Data  // lombox จะสร้าง method getter setter ให้เอง
@Getter @Setter
public class Receipt {
    @Id  // บอกว่าเป็น  Primary  key
    @GeneratedValue   // Generate id เอง ตอน insert
    @Column(name = "RECEINT_ID")
    private @NonNull Long receiptID;
    @Temporal(TemporalType.TIMESTAMP)
    private @NonNull Date receiptDateTime;

    @ManyToOne
    @JoinColumn(name = "MERBER_USER", nullable=false)
    private Members members;

    @ManyToOne
    @JoinColumn(name = "PERSONEL_USER", nullable=false)
    private Staff staff;

    @ManyToOne
    @JoinColumn(name = "SERVICE_CENTER_ID", nullable=false)
    private ServiceCenter serviceCenter;


    public Receipt() {    }

    public Receipt(Date receiptDateTime, Members members, Staff staff, ServiceCenter serviceCenter) {
        this.receiptDateTime = receiptDateTime;
        this.members = members;
        this.staff = staff;
        this.serviceCenter = serviceCenter;
    }
}
