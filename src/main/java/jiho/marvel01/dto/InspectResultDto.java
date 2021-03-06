package jiho.marvel01.dto;

import jiho.marvel01.domain.Entity.InspectResultEntity;
import lombok.*;

import java.sql.Timestamp;

@Getter
public class InspectResultDto  {

    private Integer rid;
    private Integer iid;
    private Integer oid;
    private Integer cid;
    private Timestamp date;
    private String result;
    private String status;


    public InspectResultEntity toEntity() {
        InspectResultEntity inspectResultEntity = InspectResultEntity.builder()
                .rid(rid)
                .iid(iid)
                .oid(oid)
                .cid(cid)
                .date(date)
                .result(result)
                .status(status)
                .build();
        return inspectResultEntity;
    }

    @Builder
    public InspectResultDto(Integer rid,
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
