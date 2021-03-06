package jiho.marvel01.dto;

import jiho.marvel01.domain.Entity.ManageEntity;
import lombok.*;

import java.sql.Date;
import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor

public class ManageDto{

    private Long mid;
    private Long iid;
    private Long rid;
    private String type;
    private Date stDate;
    private Date exDate;
    private String comment;
    private String status;
    private Long aid;

    public ManageEntity toEntity() {
        ManageEntity manageEntity = ManageEntity.builder()
                .mid(mid)
                .iid(iid)
                .rid(rid)
                .type(type)
                .stDate(stDate)
                .exDate(exDate)
                .comment(comment)
                .status(status)
                .aid(aid)
                .build();
        return manageEntity;
    }

    @Builder
    public ManageDto(Long mid, Long iid, Long rid, String type, Date stDate, Date exDate, String comment, String status, Long aid) {
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
