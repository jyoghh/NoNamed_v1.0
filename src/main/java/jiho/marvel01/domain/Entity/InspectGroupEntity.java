package jiho.marvel01.domain.Entity;

import lombok.*;
import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "InspectGroup")
public class InspectGroupEntity extends TimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long igid;

    public InspectGroupEntity() {}

    @Column(name = "iid")
    private Long iid;

    @Column(name = "oid")
    private Long oid;

    @Builder
    public InspectGroupEntity(Long igid, Long iid, Long oid) {
        this.igid  = igid;
        this.iid  = iid;
        this.oid  = oid;
    }

}
