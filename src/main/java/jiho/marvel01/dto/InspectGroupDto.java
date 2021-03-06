package jiho.marvel01.dto;

import jiho.marvel01.domain.Entity.InspectGroupEntity;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class InspectGroupDto {

    private Long igid;
    private Long iid;
    private String objects;
    private String igName;
    private String manager;

    public InspectGroupEntity toEntity() {
        InspectGroupEntity inspectgroupEntity = InspectGroupEntity.builder()
                .igid(igid)
                .iid(iid)
                .objects(objects)
                .igName(igName)
                .manager(manager)
                .build();
        return inspectgroupEntity;
    }

    @Builder
    public InspectGroupDto(Long igid, Long iid, String objects, String igName, String manager) {
        this.igid    = igid;
        this.iid     = iid;
        this.objects = objects;
        this.igName  = igName;
        this.manager = manager;
    }

}
