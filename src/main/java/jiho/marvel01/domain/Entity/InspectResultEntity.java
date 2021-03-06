package jiho.marvel01.domain.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "InspectResult")
public class InspectResultEntity {

    public InspectResultEntity() {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer rid;

    @Column(name = "iid")
    private Integer iid;

    @Column(name = "oid")
    private Integer oid;

    @Column(name = "cid")
    private Integer cid;

    @Column(name = "date")
    private Timestamp date;

    @Column(name = "result")
    private String result;

    @Column(name = "status")
    private String status;

    @Builder
    public InspectResultEntity(Integer rid,
                               Integer iid,
                               Integer oid,
                               Integer cid,
                               Timestamp date,
                               String result,
                               String status) {
        this.rid     = rid;
        this.iid     = iid;
        this.oid     = oid;
        this.cid     = cid;
        this.date    = date;
        this.result  = result;
        this.status  = status;
    }

}
