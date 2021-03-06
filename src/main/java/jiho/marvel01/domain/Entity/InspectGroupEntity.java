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

    @Column(name = "objects")
    private String objects;

    @Column(name = "igName")
    private String igName;

    @Column(name = "manager")
    private String manager;

    @Builder
    public InspectGroupEntity(Long igid, Long iid, String objects, String igName, String manager) {
        this.igid    = igid;
        this.iid     = iid;
        this.objects = objects;
        this.igName  = igName;
        this.manager = manager;
    }

}
