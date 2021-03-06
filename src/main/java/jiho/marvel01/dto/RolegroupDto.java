package jiho.marvel01.dto;

import lombok.*;


@Getter
@Setter
public class RolegroupDto{

    private Long rgid;
    private Long groupId;
    private String roleName;
    private String url;
    private String roleCategory;
    private String level;
    private String active;

    @Builder
    public RolegroupDto(Long rgid, String roleName, String url, String roleCategory, String level, String active) {
        this.rgid         = rgid;
        this.roleName     = roleName;
        this.url          = url;
        this.roleCategory = roleCategory;
        this.level        = level;
        this.active       = active;
    }

}
