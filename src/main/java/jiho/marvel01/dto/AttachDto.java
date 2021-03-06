package jiho.marvel01.dto;

import jiho.marvel01.domain.Entity.AttachEntity;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class AttachDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long aid;
    private Long oid;
    private String name;
    private String path;

    public AttachEntity toEntity() {
        AttachEntity attachEntity = AttachEntity.builder()
                .aid(aid)
                .oid(oid)
                .name(name)
                .path(path)
                .build();
        return attachEntity;
    }

    @Builder
    public AttachDto(Long aid, Long oid, String name, String path) {
        this.aid  = aid;
        this.oid  = oid;
        this.name = name;
        this.path = path;
    }

}
