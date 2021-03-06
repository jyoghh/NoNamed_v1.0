package jiho.marvel01.domain.Entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "Ticket")
public class TicketEntity extends TimeEntity {

    public TicketEntity() {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tid;

    @Column(name = "rid")
    private Integer rid;

    @Column(name = "iid")
    private Integer iid;

    @Column(name = "oid")
    private Integer oid;

    @Column(name = "cid")
    private Integer cid;

    @Column(name = "content")
    private String content;

    @Column(name = "status")
    private String status;

    @Builder
    public TicketEntity(Integer tid, Integer rid, Integer iid, Integer oid, Integer cid, String content, String status) {
        this.tid     = tid;
        this.rid     = rid;
        this.iid     = iid;
        this.oid     = oid;
        this.cid     = cid;
        this.content = content;
        this.status  = status;
    }

}
