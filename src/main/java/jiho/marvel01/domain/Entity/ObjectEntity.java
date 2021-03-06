package jiho.marvel01.domain.Entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "object")
public class ObjectEntity {

    public ObjectEntity() {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long oid;

    @Column(name = "type")
    private String type;

    @Column(name = "oName")
    private String oName;

    @Column(name = "purpose")
    private String purpose;

    @Column(name = "oGroup")
    private String oGroup;

    @Column(name = "part1")
    private String part1;

    @Column(name = "part2")
    private String part2;

    @Column(name = "IP")
    private String IP;

    @Column(name = "location")
    private String location;

    @Builder
    public ObjectEntity(Long oid, String type, String oName , String purpose , String oGroup , String part1 , String part2 , String IP , String location) {
        this.oid        = oid;
        this.type       = type;
        this.oName      = oName;
        this.purpose    = purpose;
        this.oGroup     = oGroup;
        this.part1      = part1;
        this.part2      = part2;
        this.IP         = IP;
        this.location   = location;
    }

}


