package jiho.marvel01.domain.Entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "Attach")
public class AttachEntity extends TimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long aid;

    public AttachEntity() {}

    @Column(name = "oid")
    private Long oid;

    @Column(name = "name")
    private String name;

    @Column(name = "path")
    private String path;

    @Builder
    public AttachEntity(Long aid, Long oid, String name, String path) {
        this.aid  = aid;
        this.oid  = oid;
        this.name = name;
        this.path = path;
    }

}
