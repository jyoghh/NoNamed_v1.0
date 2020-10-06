package jiho.marvel01.domain.Entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Getter
@Setter
@Table(name = "Inspect")
public class InspectEntity extends TimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long iid;

    public InspectEntity() {

    }

    @Column(name = "igid")
    private Integer igid;

    @Column(name = "type")
    private String type;

    @Column(name = "idate")
    private Timestamp idate;

    @Column(name = "content")
    private String content;

    @Column(name = "mdate")
    private Timestamp mdate;

    @Column(name = "status")
    private String status;

    @Builder
    public InspectEntity(Long iid, Integer igid , String type , Timestamp idate , String content , Timestamp mdate , String status) {
        this.iid        = iid;
        this.igid       = igid;
        this.type       = type;
        this.idate      = idate;
        this.content    = content;
        this.mdate      = mdate;
        this.status     = status;
    }

}