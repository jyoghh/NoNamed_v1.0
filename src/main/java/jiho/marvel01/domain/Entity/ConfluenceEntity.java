package jiho.marvel01.domain.Entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "confluence")
public class ConfluenceEntity extends TimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cid;

    public ConfluenceEntity() {}

    @Column(name = "type")
    private String type;

    @Column(name = "cName")
    private String cName;

    @Column(name = "content")
    private String content;

    @Column(name = "confCategory")
    private String confCategory;

    @Column(name = "risk")
    private String risk;

    @Column(name = "demand")
    private String demand;

    @Column(name = "comply")
    private String comply;

    @Column(name = "manual")
    private String manual;

    @Column(name = "mid")
    private Long mid;

    @Builder
    public ConfluenceEntity(Long cid, String type, String cName, String content, String confCategory, String risk, String demand, String comply, String manual, Long mid) {
        this.cid           = cid;
        this.type          = type;
        this.cName         = cName;
        this.content       = content;
        this.confCategory  = confCategory;
        this.risk          = risk;
        this.demand        = demand;
        this.comply        = comply;
        this.manual        = manual;
        this.mid           = mid;
    }

}
