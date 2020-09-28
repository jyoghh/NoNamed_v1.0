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
    private Long tid;

    @Column(name = "rid")
    private Long rid;

    @Column(name = "iid")
    private Long iid;

    @Column(name = "mid")
    private Long mid;

    @Column(name = "oid")
    private Long oid;

    @Column(name = "cid")
    private Long cid;

    @Column(name = "content")
    private String content;

    @Column(name = "status")
    private String status;

    @Builder
    public TicketEntity(Long tid, Long rid, Long iid, Long mid, Long oid, Long cid, String content, String status) {
        this.tid     = tid;
        this.rid     = rid;
        this.iid     = iid;
        this.mid     = mid;
        this.oid     = oid;
        this.cid     = cid;
        this.content = content;
        this.status  = status;
    }

}
