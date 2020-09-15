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
    private String o_code;
    private String o_name;
    private String o_eng_name;
    private String upper_codes;
    private String upper_name;
    private String status;
    private String orders;
    private Integer topcheck;


    public OrgEntity toEntity() {
        OrgEntity orgEntity = OrgEntity.builder()
                .oid(oid)
                .codes(codes)
                .name(name)
                .o_code(o_code)
                .o_name(o_name)
                .o_eng_name(o_eng_name)
                .upper_codes(upper_codes)
                .upper_name(upper_name)
                .status(status)
                .orders(orders)
                .topcheck(topcheck)
                .build();
        return orgEntity;
    }

    @Builder
    public OrgDto(Long oid, String codes, String name, String o_code, String o_name, String o_eng_name, String upper_codes, String upper_name, String status, String orders, Integer topcheck) {
        this.oid = oid;
        this.codes = codes;
        this.name = name;
        this.o_code = o_code;
        this.o_name = o_name;
        this.o_eng_name = o_eng_name;
        this.upper_codes = upper_codes;
        this.upper_name = upper_name;
        this.status = status;
        this.orders = orders;
        this.topcheck = topcheck;
    }
}
