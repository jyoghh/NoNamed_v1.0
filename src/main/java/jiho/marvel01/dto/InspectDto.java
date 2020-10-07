package jiho.marvel01.dto;

import jiho.marvel01.domain.Entity.InspectEntity;
import lombok.*;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class InspectDto {
    private Long iid;
    private Integer cid;
    private Integer igid;
    private String iName;
    private String type;
    private String objects;
    private Date idate;
    private Date idateEx;
    private String content;
    private Date mdate;
    private Date mdateEx;
    private String status;

    public InspectEntity toEntity() {
        InspectEntity inspectEntity = InspectEntity.builder()
                .iid(iid)
                .cid(cid)
                .igid(igid)
                .iName(iName)
                .type(type)
                .objects(objects)
                .idate(idate)
                .idateEx(idateEx)
                .content(content)
                .mdate(mdate)
                .mdateEx(mdateEx)
                .status(status)
                .build();
        return inspectEntity;
    }

    @Builder
    public InspectDto(Long iid, Integer cid, Integer igid, String iName, String type, String objects, Date idate, Date idateEx, String content, Date mdate, Date mdateEx, String status) {
        this.iid        = iid;
        this.cid        = cid;
        this.igid       = igid;
        this.iName      = iName;
        this.type       = type;
        this.objects    = objects;
        this.idate      = idate;
        this.idateEx    = idateEx;
        this.content    = content;
        this.mdate      = mdate;
        this.mdateEx    = mdateEx;
        this.status     = status;
    }
}
