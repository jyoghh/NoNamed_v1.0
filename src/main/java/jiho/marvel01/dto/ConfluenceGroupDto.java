package jiho.marvel01.dto;

import jiho.marvel01.domain.Entity.ConfluenceGroupEntity;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class ConfluenceGroupDto {

    private Long cgid;
    private String confs;
    private String cgName;

    public ConfluenceGroupEntity toEntity() {
        ConfluenceGroupEntity confluencegroupEntity = ConfluenceGroupEntity.builder()
                .cgid(cgid)
                .confs(confs)
                .cgName(cgName)
                .build();
        return confluencegroupEntity;
    }

    @Builder
    public ConfluenceGroupDto(Long cgid, String confs, String cgName) {
        this.cgid    = cgid;
        this.confs   = confs;
        this.cgName  = cgName;
    }

}
