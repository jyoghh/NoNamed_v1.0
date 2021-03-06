package jiho.marvel01.domain.Entity;

import lombok.*;

import javax.persistence.*;
import java.security.Timestamp;

@Entity
@Getter
@Setter
@Table(name = "role_group")
public class RolegroupEntity extends TimeEntity {

    public RolegroupEntity() {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rgid;

    @Column(name = "groupId")
    private Long groupId;

    @Column(name = "roleName")
    private String roleName;

    @Column(name = "url")
    private String url;

    @Column(name = "roleCategory")
    private String roleCategory;

    @Column(name = "level")
    private String level;

    @Column(name = "active")
    private String active;

    @Builder
    public RolegroupEntity(Long rgid, String roleName, String url, String roleCategory, String level, String active) {
        this.rgid         = rgid;
        this.roleName     = roleName;
        this.url          = url;
        this.roleCategory = roleCategory;
        this.level        = level;
        this.active       = active;
    }

}
