package jiho.marvel01.dto;

import jiho.marvel01.domain.Entity.TicketEntity;
import lombok.*;


@Getter
@Setter
public class TicketDto{

    private Long tid;
    private Long rid;
    private Long iid;
    private Long mid;
    private Long oid;
    private Long cid;
    private String content;
    private String status;

    public TicketEntity toEntity() {
        TicketEntity tickeEntity = TicketEntity.builder()
                .tid(tid)
                .rid(rid)
                .iid(iid)
                .mid(mid)
                .oid(oid)
                .cid(cid)
                .content(content)
                .status(status)
                .build();
        return tickeEntity;
    }

    @Builder
    public TicketDto(Long tid, Long iid, Long mid, Long oid, Long cid, String content, String status) {
        this.tid     = tid;
        this.iid     = iid;
        this.mid     = mid;
        this.oid     = oid;
        this.cid     = cid;
        this.content = content;
        this.status  = status;
    }

}
