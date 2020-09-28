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
    private String name;
    private String content;
    private String category;
    private String risk;
    private String demand;
    private String comply;
    private String manual;
    private Long mid;

    public ConfluenceEntity toEntity() {
        ConfluenceEntity confluenceEntity = ConfluenceEntity.builder()
                .cid(cid)
                .type(type)
                .name(name)
                .content(content)
                .category(category)
                .risk(risk)
                .demand(demand)
                .comply(comply)
                .manual(manual)
                .mid(mid)
                .build();
        return confluenceEntity;
    }

    @Builder
    public ConfluenceDto(Long cid, String type, String name , String content , String category , String risk , String demand , String comply , String manual, Long mid) {
        this.cid       = cid;
        this.type      = type;
        this.name      = name;
        this.content   = content;
        this.category  = category;
        this.risk      = risk;
        this.demand    = demand;
        this.comply    = comply;
        this.manual    = manual;
        this.mid       = mid;
    }

}
