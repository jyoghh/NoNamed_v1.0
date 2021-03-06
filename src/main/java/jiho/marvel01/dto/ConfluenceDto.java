package jiho.marvel01.dto;

import jiho.marvel01.domain.Entity.ConfluenceEntity;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class ConfluenceDto {

    private Long cid;
    private String type;
    private String cName;
    private String content;
    private String confCategory;
    private String risk;
    private String demand;
    private String comply;
    private String manual;
    private Long mid;

    public ConfluenceEntity toEntity() {
        ConfluenceEntity confluenceEntity = ConfluenceEntity.builder()
                .cid(cid)
                .type(type)
                .cName(cName)
                .content(content)
                .confCategory(confCategory)
                .risk(risk)
                .demand(demand)
                .comply(comply)
                .manual(manual)
                .mid(mid)
                .build();
        return confluenceEntity;
    }

    @Builder
    public ConfluenceDto(Long cid, String type, String cName, String content, String confCategory , String risk , String demand , String comply , String manual, Long mid) {
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
