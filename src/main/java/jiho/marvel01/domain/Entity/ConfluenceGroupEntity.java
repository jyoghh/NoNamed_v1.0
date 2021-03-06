package jiho.marvel01.domain.Entity;

import lombok.*;
import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "ConfluenceGroup")
public class ConfluenceGroupEntity extends TimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cgid;

    public ConfluenceGroupEntity() {}

    @Column(name = "confs")
    private String confs;

    @Column(name = "cgName")
    private String cgName;

    @Builder
    public ConfluenceGroupEntity(Long cgid, String confs, String cgName) {
        this.cgid    = cgid;
        this.confs   = confs;
        this.cgName  = cgName;
    }

}
