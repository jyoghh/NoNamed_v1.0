package jiho.marvel01.domain.Entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "object")
public class ObjectEntity extends TimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long oid;

    public ObjectEntity() {}

    @Column(name = "type")
    private String type;

    @Column(name = "name")
    private String name;

    @Column(name = "purpose")
    private String purpose;

    @Column(name = "group")
    private String group;

    @Column(name = "part1")
    private String part1;

    @Column(name = "part2")
    private String part2;

    @Column(name = "IP")
    private String IP;

    @Column(name = "location")
    private String location;

    @Builder
    public ObjectEntity(Long oid, String type, String name , String purpose , String group , String part1 , String part2 , String IP , String location) {
        this.oid        = oid;
        this.type       = type;
        this.name       = name;
        this.purpose    = purpose;
        this.group      = group;
        this.part1      = part1;
        this.part2      = part2;
        this.IP         = IP;
        this.location   = location;
    }

}
