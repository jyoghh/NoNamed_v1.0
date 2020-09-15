package jiho.marvel01.domain.Entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "organazation")
public class OrgEntity extends TimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long oid;

    public OrgEntity() {
    }

//    회사코드
    @Column(name = "codes")
    private String codes;

//    회사명
    @Column(name = "name")
    private String name;

//    조직코드
    @Column(name = "o_code")
    private String o_code;

//    조직명
    @Column(name = "o_name")
    private String o_name;

//    조직영문명
    @Column(name = "o_eng_name")
    private String o_eng_name;

//    상위조직코드
    @Column(name = "upper_codes")
    private String upper_codes;

//    상위조직명
    @Column(name = "upper_name")
    private String upper_name;

//    상태
    @Column(name = "status")
    private String status;

//    순서
    @Column(name = "orders")
    private String orders;

//    최상위여부
    @Column(name = "topcheck")
    private Integer topcheck;

    @Builder
    public OrgEntity(Long oid, String codes, String name, String o_code, String o_name, String o_eng_name, String upper_codes, String upper_name, String status, String orders, Integer topcheck) {
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