package jiho.marvel01.domain.Entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "ticket_detail")
public class TicketDetailEntity extends TimeEntity {

    public TicketDetailEntity() {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tdid;

    @Column(name = "tid")
    private Long tid;

    @Column(name = "aid")
    private Long aid;

    @Column(name = "content")
    private String content;

    @Builder
    public TicketDetailEntity(Long tdid, Long tid, Long aid, String content) {
        this.tdid     = tdid;
        this.tid     = tid;
        this.aid     = aid;
        this.content = content;
    }

}
