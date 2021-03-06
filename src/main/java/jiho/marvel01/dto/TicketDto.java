package jiho.marvel01.dto;

import jiho.marvel01.domain.Entity.TicketEntity;
import lombok.*;


@Getter
@Setter
public class TicketDto{

    private Integer tid;
    private Integer rid;
    private Integer iid;
    private Integer oid;
    private Integer cid;
    private String content;
    private String status;

    public TicketEntity toEntity() {
        TicketEntity tickeEntity = TicketEntity.builder()
                .tid(tid)
                .rid(rid)
                .iid(iid)
                .oid(oid)
                .cid(cid)
                .content(content)
                .status(status)
                .build();
        return tickeEntity;
    }

    @Builder
    public TicketDto(Integer tid, Integer iid, Integer rid, Integer oid, Integer cid, String content, String status) {
        this.tid     = tid;
        this.iid     = iid;
        this.rid     = rid;
        this.oid     = oid;
        this.cid     = cid;
        this.content = content;
        this.status  = status;
    }

}
