package jiho.marvel01.domain.Entity;

import com.vladmihalcea.hibernate.type.array.StringArrayType;
import lombok.*;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import java.sql.Array;
import java.sql.Date;

@Entity
@Getter
@Setter
@Table(name = "Inspect")
public class InspectEntity extends TimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long iid;

    public InspectEntity() {}

    @Column(name = "igid")
    private Integer igid;

    @Column(name = "cgid")
    private Integer cgid;

    @Column(name = "iName")
    private String iName;

    @Column(name = "type")
    private String type;

    @Column(name = "idate")
    private Date idate;

    @Column(name = "idateEx")
    private Date idateEx;

    @Column(name = "content")
    private String content;

    @Column(name = "mdate")
    private Date mdate;

    @Column(name = "mdateEx")
    private Date mdateEx;

    @Column(name = "status")
    private String status;

    @Builder
    public InspectEntity(Long iid, Integer cgid, Integer igid, String iName, String type, Date idate, Date idateEx, String content, Date mdate, Date mdateEx, String status) {
        this.iid        = iid;
        this.cgid        = cgid;
        this.igid       = igid;
        this.iName      = iName;
        this.type       = type;
        this.idate      = idate;
        this.idateEx    = idateEx;
        this.content    = content;
        this.mdate      = mdate;
        this.mdateEx    = mdateEx;
        this.status     = status;
    }

}
