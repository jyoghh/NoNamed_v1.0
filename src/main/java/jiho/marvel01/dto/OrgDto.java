package jiho.marvel01.dto;

import jiho.marvel01.domain.Entity.OrgEntity;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class OrgDto {
    private Long oid;
    private String codes;
    private String name;
    private String oCode;
    private String oName;
    private String oEngName;
    private String upperCode;
    private String upperName;
    private String status;
    private String orders;
    private Integer topcheck;


    public OrgEntity toEntity() {
        OrgEntity orgEntity = OrgEntity.builder()
                .oid(oid)
                .codes(codes)
                .name(name)
                .oCode(oCode)
                .oName(oName)
                .oEngName(oEngName)
                .upperCode(upperCode)
                .upperName(upperName)
                .status(status)
                .orders(orders)
                .topcheck(topcheck)
                .build();
        return orgEntity;
    }

    @Builder
    public OrgDto(Long oid, String codes, String name, String oCode, String oName, String oEngName, String upperCode, String upperName, String status, String orders, Integer topcheck) {
        this.oid        = oid;
        this.codes      = codes;
        this.name       = name;
        this.oCode      = oCode;
        this.oName      = oName;
        this.oEngName   = oEngName;
        this.upperCode  = upperCode;
        this.upperName  = upperName;
        this.status     = status;
        this.orders     = orders;
        this.topcheck   = topcheck;
    }
}

