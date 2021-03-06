package jiho.marvel01.domain.Entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Getter
@Setter
@Table(name = "Manage")
public class ManageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mid;

    public ManageEntity() {}

    @Column(name = "iid")
    private Long iid;

    @Column(name = "rid")
    private Long rid;

    @Column(name = "type")
    private String type;

    @Column(name = "stDate")
    private Date stDate;

    @Column(name = "exDate")
    private Date exDate;

    @Column(name = "comment")
    private String comment;

    @Column(name = "status")
    private String status;

    @Column(name = "aid")
    private Long aid;

    @Builder
    public ManageEntity(Long mid, Long iid, Long rid, String type, Date stDate, Date exDate, String comment, String status, Long aid) {
        this.mid = mid;
        this.iid = iid;
        this.rid = rid;
        this.type = type;
        this.stDate = stDate;
        this.exDate = exDate;
        this.comment = comment;
        this.status  = status;
        this.aid  = aid;
    }

}
