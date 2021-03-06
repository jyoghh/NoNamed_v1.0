package jiho.marvel01.dto;

import lombok.*;

import java.security.Timestamp;

@Getter
@Setter
public class RoleDto{

    private Long rid;
    private Long regId;
    private String gName;
    private String gCode;
    private Timestamp regDate;

    @Builder
    public RoleDto(Long rid, Long regId, String gName,String gCode, Timestamp regDate) {
        this.rid     = rid;
        this.regId   = regId;
        this.gName   = gName;
        this.gCode   = gCode;
        this.gCode   = gCode;
        this.regDate = regDate;
    }

}
